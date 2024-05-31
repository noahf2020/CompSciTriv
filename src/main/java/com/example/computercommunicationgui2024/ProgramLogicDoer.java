package com.example.computercommunicationgui2024;

import com.example.CommunicationData;
import javafx.application.Platform;

import java.util.ArrayList;

public class ProgramLogicDoer implements Runnable {
    MyCoolDataStructure inData;
    boolean serverMode;
    ClientServerController theController;

    ArrayList<ClientConnection> manyClients = new ArrayList<ClientConnection>();

    public ProgramLogicDoer(MyCoolDataStructure inData, ClientServerController theController, boolean serverMode)  {
        this.inData = inData;
        this.theController = theController;
        this.serverMode = serverMode;
    }

    public void addSocket(ClientConnection newClient) {
        manyClients.add(newClient);
    }

    public void run() {
        CommunicationData inMessage1 = inData.get();
        while (true) {
            if (inMessage1 != null) {
                if (theController != null) {
                    // add the message to your JavaFX Control that displays many messages
                    CommunicationData finalInMessage = inMessage1;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //theController.allMessages.getItems().add(finalInMessage);
                            System.out.println("ProgramLogicDoer got: " + finalInMessage);
                        }
                    });
                } else {
                    System.out.println("ProgramLogicDoer got: " + inMessage1);
                }
                try {
                    if (serverMode) {
                        if (inMessage1.getAnswer().equalsIgnoreCase("ID") &&
                                inMessage1.getTo().equalsIgnoreCase("SERVER")) {
                            String clientName = inMessage1.getFrom();
                            for (ClientConnection aClient: manyClients) {
                                if (inMessage1.getFromIPAddress().equalsIgnoreCase(aClient.getActualSocket().getInetAddress().getHostAddress())) {
                                    System.out.println("ProgramLogicDoer registered: " + clientName + " to IP" + aClient);
                                    aClient.setName(clientName);
                                }
                            }
                        }
                        for (ClientConnection aClient: manyClients) {
                            if (inMessage1.getTo().equalsIgnoreCase("ALL") ||
                                    inMessage1.getTo().equalsIgnoreCase(aClient.getName())) {
                                System.out.println("ProgramLogicDoer relayed to: " + aClient + " message: " + inMessage1);
                                aClient.getObjOut().writeObject(inMessage1);
                            }
                        }
                    } else {

                        // react to messages from server!!!!
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            inMessage1 = inData.get();
        }
    }
}
