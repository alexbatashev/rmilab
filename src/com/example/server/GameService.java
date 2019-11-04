package com.example.server;

import com.example.client.GameClientCallback;
import com.example.lib.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameService extends Remote {
    void addNewMessage(Message msg) throws RemoteException;
    int getPlayerId() throws RemoteException;
    void register(int playerId, GameClientCallback callback);
}
