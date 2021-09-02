package pl.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.Data.DatabaseHandling;
import pl.struckture.Order;
import pl.struckture.Pattern;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReadOrdersController {

    @FXML
    private TableView<Order> orderTableView;

    @FXML
    private TableColumn<Order, String> NameColumn;

    @FXML
    private TableColumn<Order, String> ClientColumn;

    @FXML
    private TableColumn<Order, String> OrdersColumn;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        writeRecordsTabel();
    }
    private void writeRecordsTabel() {
        ArrayList<Order> orders = DatabaseHandling.getOrders();
        NameColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("name"));
        //NameColumn.se

        orderTableView.getItems().setAll(orders);
        NameColumn.setSortType(TableColumn.SortType.DESCENDING);//Funkcja ustawia sortowanie kolumny Point od największego w dół
        orderTableView.getSortOrder().add(NameColumn);//Funkcja sortuje tablice według kolumny Points
    }
}
