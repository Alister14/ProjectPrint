package pl.main;

import pl.Data.DatabaseHandling;
import pl.struckture.Client;
import pl.struckture.Order;
import pl.struckture.Pattern;
import pl.struckture.Screen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) throws IOException {
        DatabaseHandling dataHandling = new DatabaseHandling();
        DatabaseHandling.ReadDatabase();
        ArrayList<Client> clients = DatabaseHandling.getClients();
        ArrayList<Order> orders = DatabaseHandling.getOrders();
        ArrayList<Pattern> patterns = DatabaseHandling.getPatterns();
        ArrayList<Screen> screens = DatabaseHandling.getScreens();
        ArrayList<String> languages=DatabaseHandling.getLannguage();
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BorderPaneMain.fxml"));
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sito");
        primaryStage.show();
    }
}