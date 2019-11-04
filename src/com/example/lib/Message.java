package com.example.lib;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String payload;
    private int gamerId;

    public Message(String payload, int gamerId) {
        super();
        this.payload = payload;
        this.gamerId = gamerId;
    }

    public boolean equals(Object message) {
        Message msg = (Message)message;
        // todo this is not very legal. Both payload and msg payload can be null
        if (msg.gamerId == gamerId && payload.equals(((Message) message).payload)) {
            return true;
        }
        return false;
    }

    public int getGamerId() {
        return gamerId;
    }

    public String getPayload() {
        return payload;
    }
}
