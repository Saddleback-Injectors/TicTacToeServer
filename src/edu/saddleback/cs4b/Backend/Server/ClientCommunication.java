package edu.saddleback.cs4b.Backend.Server;

import edu.saddleback.cs4b.Backend.Messages.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Handles communication with a particular client
 */
public class ClientCommunication implements Runnable, ClientConnection {
    private Socket socket;
    private ObjectOutputStream os;
    private ObjectInputStream is;
    private String username; // set when registered
    // probably hold the profile information?
    private AbstractMessageFactory msgFactory;

    public ClientCommunication(Socket socket) {
        this.socket = socket;
        initiateStreams();
        SystemInfoService.getInstance().markUserAsOnline(this);
        this.msgFactory = new AdminMessageFactory();
    }

    private void initiateStreams() {
        try {
            this.is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            this.os = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    // the connection will listen for incoming messages
    public void run() {
        boolean isRunning = false;
        try {
            //ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            while (isRunning) {
                Packet packet = (Packet)is.readObject();
                BaseMessage message = packet.getData();

                // todo user must be registered before they can proceed
                //should be a way to only sign-in and register before
                //other stuff can be done
                handleMessages(message);
            }
        } catch (EOFException eof) {
            isRunning = false;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void handleMessages(BaseMessage message) throws IOException {
        if (message instanceof SignInMessage) {
            SignInMessage signIn = (SignInMessage)message;

            if (AuthenticationService.getInstance().authenticate(signIn.getUserInfo())) {
                // respond with an authenticated message as output
                 os.writeObject(new Packet(msgFactory.createMessage(MsgTypes.AUTHENTICATION.getType())));
                 os.flush();
            } else {
                // output a message that denied the access to the system
                 os.writeObject(new Packet(msgFactory.createMessage(MsgTypes.DENIED.getType())));
                 os.flush();
            }

        } else if (message instanceof ActiveUserMessage) {
            // todo change this out with more efficient way of getting the message
            ActiveUserMessage usrMsg = (ActiveUserMessage) msgFactory.createMessage(MsgTypes.ACTIVE_USER_REQ.getType());
            usrMsg.setActiveUsers(getActiveUsers());
            Packet packet = new Packet(usrMsg);
            os.writeObject(packet);
            os.flush();
        } 
        else if (message instanceof SignOutMessage) {
            SystemInfoService.getInstance().removeOnlineUser(this);
            // todo finish this up
            // propagate to the users
        }
    }

    private List<String> getActiveUsers() {
        List<ClientConnection> connections = SystemInfoService.getInstance().getOnlineUsers();
        List<String> users = new ArrayList<>();
        for (ClientConnection c : connections) {
            users.add(c.identifyClient());
        }
        return users;
    }

    @Override
    public String identifyClient() { return username; }
}
