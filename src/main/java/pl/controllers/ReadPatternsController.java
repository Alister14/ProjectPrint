package pl.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import pl.Data.DatabaseHandling;
import pl.modelFx.PatternFx;
import pl.modelFx.PatternModel;
import pl.struckture.Pattern;
import pl.struckture.Screen;

import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class ReadPatternsController implements Initializable {

    ArrayList<Pattern> patterns = DatabaseHandling.getPatterns();

    @FXML
    private ComboBox<String> languageComboBox;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private ComboBox<String> colorComboBox;

    @FXML
    private TextField namePatternsTextField;

    @FXML
    private ListView<String> patternsListView;

    @FXML
    private VBox patternNameTextField;

    @FXML
    private Text namePatternText;

    @FXML
    private ImageView patternImageView;

    @FXML
    private TableView<Screen> patternsTableView;

    @FXML
    private TableColumn<Screen, Integer> numberScreenTableColumn;

    @FXML
    private TableColumn<Screen, String> signTableColumn;

    @FXML
    private TableColumn<Screen, Integer> ordersTableColumn;

    @FXML
    private TableColumn<Screen, String> colorTableColumn;

    @FXML
    private TableColumn<Screen, Boolean> availabityTableColumn;

    @FXML
    private TableColumn<Screen, Integer> densityTableColumn;

    @FXML
    private Text descriptionText;

    @FXML
    private Text placeText;


    private PatternModel patternModel;


    @FXML
    void languageComboBoxAction() {
        patternModel.clearpatrernList();
        String filterLanguage = this.languageComboBox.getSelectionModel().getSelectedItem();
        String name = null;
        for (int i=0;i<patterns.size();i++) {
            if (patterns.get(i).getLanguage().equals(filterLanguage)) {
                name = patterns.get(i).getName();
                patternModel.addPatrernList(name);
            }
        }
    }

    @FXML
    void typeComboBoxAction() {
        patternModel.clearpatrernList();
        String filterType = this.typeComboBox.getSelectionModel().getSelectedItem();
        String name = null;
        for (int i=0;i<patterns.size();i++) {
            if (patterns.get(i).getType().equals(filterType)) {
                name = patterns.get(i).getName();
                patternModel.addPatrernList(name);
            }
        }
    }

    @FXML
    void colorComboBoxAction() {
        patternModel.clearpatrernList();
        String filterColor = this.colorComboBox.getSelectionModel().getSelectedItem();
        String name = null;
        for (int i=0;i<patterns.size();i++) {
            if (patterns.get(i).getColors().equals(filterColor)) {
                name = patterns.get(i).getName();
                patternModel.addPatrernList(name);
            }
        }


    }

    @FXML
    void patternListViewAction(MouseEvent event) {
        patternListViewActionAll();
    }

    @FXML
    void patternListViewActionKey(KeyEvent event) {
        patternListViewActionAll();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.patternModel = new PatternModel();
        this.patternModel.init();
        this.languageComboBox.setItems(patternModel.getLanguageList());
        this.colorComboBox.setItems(patternModel.getColorsList());
        this.typeComboBox.setItems(patternModel.getTypeList());
        patternsListView.setItems(patternModel.getPatrernList());
    }

    public void patternListViewActionAll() {
        String names;
        int place = 0;
        names = patternsListView.getSelectionModel().getSelectedItem();
        namePatternText.setText(String.valueOf(names));
        PatternFx patternFx = new PatternFx();
        for (int i = 0; i < patterns.size(); i++) {
            if (names.equals(patterns.get(i).getName())) {
                patternFx.setImagePath(patterns.get(i).getImagePath());
                patternFx.setDescription(patterns.get(i).getDescription());
                place = i;
                break;
            }
        }

        Image image = new Image(getClass().getResourceAsStream
                (patternFx.getImagePath()), 800, 800, false, false);
        patternImageView.setImage(image);
        System.out.println(patternFx.getImagePath());
        descriptionText.setText(patternFx.getDescription());
        String patternSign = patterns.get(place).getPatterns().get(0).getSign();
        if (patternSign.equals("O")) {
            placeText.setText("Sito jest w dupie");
        } else placeText.setText("Sam jestes w dupie");
        writeRecordsTabel(patterns.get(place).getPatterns());

    }

    private void writeRecordsTabel(ArrayList<Screen> screens) {
        numberScreenTableColumn.setCellValueFactory(new PropertyValueFactory<Screen, Integer>("numberScreen"));
        signTableColumn.setCellValueFactory(new PropertyValueFactory<Screen, String>("sign"));
        ordersTableColumn.setCellValueFactory(new PropertyValueFactory<Screen, Integer>("order"));
        colorTableColumn.setCellValueFactory(new PropertyValueFactory<Screen, String>("paint"));
        availabityTableColumn.setCellValueFactory(new PropertyValueFactory<Screen, Boolean>("availability"));
        densityTableColumn.setCellValueFactory(new PropertyValueFactory<Screen, Integer>("density"));
        patternsTableView.getItems().setAll(screens);
        //numberScreenTableColumn.setSortType(TableColumn.SortType.DESCENDING);//Funkcja ustawia sortowanie kolumny Point od największego w dół
        //patternsTableView.getSortOrder().add(numberScreenTableColumn);//Funkcja sortuje tablice według kolumny Points
    }

    public void filter() {
        patternModel.clearpatrernList();
        String filterTitle = namePatternsTextField.getText();
        String name = null;
        for (Pattern pattern : patterns) {
            if (pattern.getName().toLowerCase(Locale.ROOT).contains(filterTitle.toLowerCase(Locale.ROOT))) {
                name = pattern.getName();
                patternModel.addPatrernList(name);
            }


        }

    }
}
