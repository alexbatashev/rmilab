package com.example.server;

import com.example.client.GameClientCallback;
import com.example.lib.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class GameServiceImpl extends UnicastRemoteObject implements GameService {

    private static final long serialVersionUID = 1L;

    private int[][] gameField = new int[10][10];

    private int gamers = 0;

    private HashMap<Integer, GameClientCallback> callbacks = new HashMap<>();

    public GameServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public void addNewMessage(Message msg) throws RemoteException {

    }

    @Override
    public int getPlayerId() throws RemoteException {
        if (gamers >= 2) throw new RemoteException("2 players max");
        return gamers++;
    }

    @Override
    public void register(int playerId, GameClientCallback callback) {
        callbacks.put(playerId, callback);
    }
}
