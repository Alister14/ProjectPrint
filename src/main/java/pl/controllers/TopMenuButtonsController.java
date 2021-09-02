package pl.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {
    public static final String READ_RECORD_FXML = "/fxml/ReadPatterns.fxml";//Refaktoryzacja kodu
    public static final String ADD_OR_DELETE_CLIENT = "/fxml/AddOrDeleteClientOrMark.fxml";

    @FXML
    void readPattern()  {
        mainController.setCenter(READ_RECORD_FXML);//Ustawia centralnie formatke Wybierz bohatera w border painie
    }

    @FXML
    void addOrDeleteClient() {
        mainController.setCenter(ADD_OR_DELETE_CLIENT);//Ustawia centralnie formatke Wybierz bohatera w border painie
    }


    @FXML
    private MainController mainController;
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML // fx:id="toggleButons"
    private ToggleGroup toggleButons; // Value injected by FXMLLoader


}