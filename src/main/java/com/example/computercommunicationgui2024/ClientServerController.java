package com.example.computercommunicationgui2024;

import com.example.CommunicationData;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClientServerController {
    public TableView<CommunicationData> allMessages;
    public TableColumn<CommunicationData, String> IPColumn;
    public TableColumn<CommunicationData, String> fromColumn;
    public TableColumn<CommunicationData, String> toColumn;
    public TableColumn<CommunicationData, String> messageColumn;
}
