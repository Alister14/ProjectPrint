package pl.controllers;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.utilis.DialogUtilis;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static javafx.application.Application.STYLESHEET_CASPIAN;
import static javafx.application.Application.STYLESHEET_MODENA;

public class MainController implements Initializable {
    DialogUtilis dialogUtilis=new DialogUtilis();
    public static final String MAIN_PANE_FXML = "fxml/BorderPaneMain.fxml";
    @FXML
    private BorderPane borderPaine;//To jest głowne fx:id naszej głowneji formatki border pane
    @FXML
    private TopMenuButtonsController topMenuButtonsController;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        topMenuButtonsController.setMainController(this);//Ta funkcja pozwala stereować topMenuButtonem
    }
    public void setCenter(String fxmlPath) { //Funckja dostaje stringa ze ściążką i ustawia w centralnej cześci
        // borderpane to co dostała
        FXMLLoader loader=new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        borderPaine.setCenter(parent);
    }
    public void closseAplication() {//Funkcja wyświetla okienko dialogowe które pyta nas czy chcemy wyjść
        //Jeśli tak to wysła kod zakończenia aplikacji 0
        Optional<ButtonType> result = dialogUtilis.confirmationDialog();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }
    public void setCaspian() {
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);//Funkcja ustawia stylk na Caspian, który jest
        // standardowym stylem
    }
    public void setModena() {
        Application.setUserAgentStylesheet(STYLESHEET_MODENA);//Funkcja ustawia stylk na Caspian, który jest
        // standardowym stylem
    }
    public void setAlwayOnTop(ActionEvent event) {
        Stage stage = (Stage) borderPaine.getScene().getWindow();
        boolean value = ((CheckMenuItem) event.getSource()).selectedProperty().get();//Funkcja zbiera informację czy
        // opcja "Zawsze na wierzchu" jest zaznaczona czy nie
        stage.setAlwaysOnTop(value);//Funkcja ustawia okno aplikacji by było zawsze na wierzchz
    }
    public void aboutUs() {
        dialogUtilis.dialogApplicatio();
    }
}