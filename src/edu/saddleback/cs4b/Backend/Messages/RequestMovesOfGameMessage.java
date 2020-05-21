package edu.saddleback.cs4b.Backend.Messages;

import edu.saddleback.cs4b.Backend.Objects.Move;

import java.util.List;

public class RequestMovesOfGameMessage extends BaseMessage {
    private String gameId;

    public RequestMovesOfGameMessage() {
        this (null);
    }

    public RequestMovesOfGameMessage(String gameId) {
        super(null);
        setGameId(gameId);
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
