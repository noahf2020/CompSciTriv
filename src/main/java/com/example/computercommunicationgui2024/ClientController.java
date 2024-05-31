package com.example.computercommunicationgui2024;

import com.example.CommunicationData;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.Socket;

public class ClientController extends ClientServerController {

    public TableView tableView;
    public TableColumn Questions;
    public TableColumn A;
    public TableColumn B;
    public TableColumn C;
    public TableColumn D;
    public Button buttonA;
    public Button buttonB;
    public Button buttonC;
    public Button buttonD;
    MyCoolDataStructure queue;
    ClientConnection serverConnection;

    public void initialize() throws Exception {


        System.out.println("Connecting to my server");
        Socket newSocket = new Socket("10.37.146.33",3256);
        queue = new MyCoolDataStructure();
        serverConnection = new ClientConnection(newSocket);
        DataReader myDataReader = new DataReader(serverConnection, queue);
        ProgramLogicDoer myProgramLogicDoer = new ProgramLogicDoer(queue, this, false);
        Thread dataReadThread = new Thread(myDataReader);
        Thread programLogicThread = new Thread(myProgramLogicDoer);
        dataReadThread.start();
        programLogicThread.start();

        CommunicationData identity = new CommunicationData("Victor","SERVER","ID", 0);
        serverConnection.getObjOut().writeObject(identity);
        System.out.println("ClientController initialize() wrote: " + identity);
    }

    public void sendMessage() throws Exception {

    }
}