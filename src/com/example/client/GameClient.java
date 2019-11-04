package com.example.client;

import com.example.lib.GameUpdate;
import com.example.lib.Message;
import com.example.server.GameService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class GameClient implements GameClientCallback {
    private String localhost    = "127.0.0.1";
    private String RMI_HOSTNAME = "java.rmi.server.hostname";
    private String SERVICE_PATH = "rmi://localhost/GameService";

    private GameService gameService;
    private int gamerId;

    GameClient() {
        try {
            System.setProperty(RMI_HOSTNAME, localhost);

            String objectName = SERVICE_PATH;

            gameService = (GameService) Naming.lookup(objectName);

            UnicastRemoteObject.exportObject(this, 1099);
            gamerId = gameService.getPlayerId();
            gameService.register(gamerId, this);
        } catch (MalformedURLException | RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.err.println("NotBoundException : " +
                    e.getMessage());
        }
    }

    public void makeMove(String move) throws RemoteException {
        Message msg = new Message(move, gamerId);
        gameService.addNewMessage(msg);
    }

    @Override
    public void updateGame(GameUpdate gameUpdate) throws RemoteException {
        // todo:
        // 1. Print game board
        // 2. If it's my turn, ask user for move
    }
}
