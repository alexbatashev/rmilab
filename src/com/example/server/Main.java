package com.example.server;

import com.example.lib.Message;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        String localhost    = "127.0.0.1";
        String RMI_HOSTNAME = "java.rmi.server.hostname";
        try {
            System.setProperty(RMI_HOSTNAME, localhost);
            // Создание удаленного RMI объекта
            GameService service = new GameServiceImpl();

            // Определение имени удаленного RMI объекта
            String serviceName = "BillingService";

            System.out.println("Initializing " + serviceName);

            /*
             * Регистрация удаленного RMI объекта BillingService
             * в реестре rmiregistry
             */
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(serviceName, service);
            System.out.println("Start " + serviceName);
        } catch (RemoteException e) {
            System.err.println("RemoteException : "+e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Exception : " + e.getMessage());
            System.exit(2);
        }

    }
}
