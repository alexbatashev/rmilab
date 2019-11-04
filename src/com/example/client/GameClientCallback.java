package com.example.client;

import com.example.lib.GameUpdate;

import java.rmi.Remote;
import java.rmi.RemoteException;


// see https://stackoverflow.com/questions/29284276/how-to-send-a-message-from-server-to-client-using-java-rmi
public interface GameClientCallback extends Remote {
    void updateGame(GameUpdate gameUpdate) throws RemoteException;
}
