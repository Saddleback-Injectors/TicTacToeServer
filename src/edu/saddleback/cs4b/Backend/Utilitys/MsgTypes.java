package edu.saddleback.cs4b.Backend.Utilitys;

public enum MsgTypes {
    INVALID_REG("Invalid Registration"),
    SUCCESS_REG("Successful Registration"),
    SIGN_IN("Sign-in"),
    AUTHENTICATION("Authentication"),
    DENIED("Denied"),
    SIGN_OUT("Sign-out"),
    DISCONNECTION("Disconnection"),
    ACTIVE_USER_REQ("Active User Request"),
    DEACTIVATION("Deactivation");
    // we will need to add our Reg/Profile

    private String type;
    private MsgTypes(String type) {
        this.type = type;
    }

    public String getType() { return type; }
}
