package pl.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.Data.DatabaseHandling;
import pl.struckture.Client;

import java.util.ArrayList;

public class ClientModel {

    private ObservableList<ClientFx> clientList = FXCollections.observableArrayList();
    private ObjectProperty<ClientFx> clientFxObjectProperty = new SimpleObjectProperty<>();



public void init(){

    ArrayList<Client> clients = DatabaseHandling.getClients();
    this.clientList.clear();
    clients.forEach(client -> {
        ClientFx clientFx= new ClientFx();
        clientFx.setIdClient(client.getIdClient());
        clientFx.setName(client.getName());
        this.clientList.add(clientFx);
    });
}



    public ObservableList<ClientFx> getClientList() {
        return clientList;
    }



    public void setClientFxObjectProperty(ClientFx clientFxObjectProperty) {
        this.clientFxObjectProperty.set(clientFxObjectProperty);
    }

    public ObjectProperty<ClientFx> clientFxObjectPropertyProperty() {
        return clientFxObjectProperty;
    }
}
