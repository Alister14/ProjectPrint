package pl.utilis;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Optional;

public class DialogUtilis {



    public void dialogApplicatio() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);//Tworzy okienko dialogowe
        informationAlert.setTitle("O nas");//Ustawiam tytuł okna i korzystam z gotowych Stringów
        informationAlert.setHeaderText("Twórcą tej aplikacji jest Patrk Zielewski");//Ustawia głowny tekst
        informationAlert.setContentText("Aplikacja ma zadanie ułatwić prace na sicie");//Ustawia Tekst opisowy
        informationAlert.showAndWait();
    }
    public static Optional<ButtonType> confirmationDialog() {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);//Tworzy okienko które będzie pytało czy
        //napewno chcesz wyjśc z aplikacji
        confirmationDialog.setTitle("EXIT");//Ustawiam tytuł okna i korzystam z gotowych Stringów
        confirmationDialog.setHeaderText("Czy napewno chcesz nas opuścić, będzie nam z tego powodu przykro");
        Optional<ButtonType> result = confirmationDialog.showAndWait();// Ta metoda pokazuję który przycisk został kliknięty
        //
        return result;
    }
}