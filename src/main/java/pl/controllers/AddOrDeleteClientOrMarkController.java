package pl.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.Data.DatabaseHandling;
import pl.modelFx.ClientFx;
import pl.modelFx.ClientModel;
import pl.modelFx.MarkFx;
import pl.modelFx.MarkModel;
import pl.struckture.Client;
import pl.struckture.Mark;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddOrDeleteClientOrMarkController implements Initializable {


    @FXML
    private TextField clientAddTextField;
    @FXML
    private TextField markAddTextField;
    @FXML
    private Button clientAddButton;
    @FXML
    private Button markAddButton;
    @FXML
    private Button clientDeleteButton;
    @FXML
    private Button markDeleteButton;
    @FXML
    private ComboBox<ClientFx> clientAddComboBox;
    @FXML
    private ComboBox<MarkFx> markAddComboBox;

    private ClientModel clientModel;
    private MarkModel markModel;


    @FXML
    void onActionComboBox() {
        this.clientModel.setClientFxObjectProperty(this.clientAddComboBox.getSelectionModel().getSelectedItem());
    }

    @FXML
    void markonActionComboBox() {
        this.markModel.setMarkFxObjectProperty(this.markAddComboBox.getSelectionModel().getSelectedItem());
    }

    @FXML
    void clientAddButtonAction() {
        ArrayList<Client> clients = DatabaseHandling.getClients();
        DatabaseHandling.addNewClient(clients, clientAddTextField.getText());
        clientAddTextField.clear();
        this.clientModel.init();
    }

    @FXML
    void markAddButtonAction() {
        ArrayList<Mark> marks = DatabaseHandling.getMarks();
        DatabaseHandling.addNewMark(marks, markAddTextField.getText());
        markAddTextField.clear();
        this.markModel.init();
    }

    @FXML
    void clientDeleteButtonAction() {
        DatabaseHandling.deleteClient(this.clientAddComboBox.getSelectionModel().getSelectedItem());
        this.clientModel.init();
    }

    @FXML
    void markDeleteButtonAction() {
        DatabaseHandling.deleteMark(this.markAddComboBox.getSelectionModel().getSelectedItem());
        this.markModel.init();
    }



    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.clientModel = new ClientModel();
        this.clientModel.init();
        this.markModel = new MarkModel();
        this.markModel.init();
        this.clientAddComboBox.setItems(clientModel.getClientList());
        this.markAddComboBox.setItems(markModel.getMarkList());
        diabler();

    }

    public void diabler() {
        clientAddButton.disableProperty().bind(clientAddTextField.textProperty().isEmpty());//Sprawdza czy pole textfield jest puste
        clientDeleteButton.disableProperty().bind(this.clientModel.clientFxObjectPropertyProperty().isNull());
        markAddButton.disableProperty().bind(markAddTextField.textProperty().isEmpty());//Sprawdza czy pole textfield jest puste
        markDeleteButton.disableProperty().bind(this.markModel.markFxObjectPropertyProperty().isNull());
    }
}
