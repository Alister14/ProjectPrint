package pl.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.Data.DatabaseHandling;
import pl.struckture.Pattern;

import java.util.ArrayList;

public class PatternModel {

    private ObservableList<String> colorsList = FXCollections.observableArrayList();
    private ObjectProperty<String> colorFxObjectProperty = new SimpleObjectProperty<>();

    private ObservableList<String> languageList = FXCollections.observableArrayList();
    private ObjectProperty<String> languageFxObjectProperty = new SimpleObjectProperty<>();

    private ObservableList<String> typeList = FXCollections.observableArrayList();
    private ObjectProperty<String> typeFxObjectProperty = new SimpleObjectProperty<>();

    private ObservableList<String> patrernList = FXCollections.observableArrayList();
    private ObjectProperty<String> patternFxObjectProperty = new SimpleObjectProperty<>();

    public  void clearpatrernList(){
        this.patrernList.clear();
    }

    public void init() {
        PatternFx patternFx = new PatternFx();
        ArrayList<Pattern> patterns = DatabaseHandling.getPatterns();
        ArrayList<String> languages = DatabaseHandling.getLannguage();
        ArrayList<String> colors = DatabaseHandling.getColors();
        ArrayList<String> types = DatabaseHandling.getType();
        this.colorsList.clear();
        this.languageList.clear();
        this.typeList.clear();
        this.patrernList.clear();
        for (int i = 0; i < languages.size(); i++) {
            patternFx.setLanguage(languages.get(i));
            this.languageList.add(patternFx.getLanguage());
        }
        for (int i = 0; i < colors.size(); i++) {
            patternFx.setColors(colors.get(i));
            this.colorsList.add(patternFx.getColors());
        }
        for (int i = 0; i < types.size(); i++) {
            patternFx.setType(types.get(i));
            this.typeList.add(patternFx.getType());
        }
        for (int i = 0; i < patterns.size(); i++) {
            patternFx.setName(patterns.get(i).getName());
            this.patrernList.add(patternFx.getName());
        }
    }

    public ObservableList<String> getColorsList() {
        return colorsList;
    }

    public String getColorFxObjectProperty() {
        return colorFxObjectProperty.get();
    }

    public ObjectProperty<String> colorFxObjectPropertyProperty() {
        return colorFxObjectProperty;
    }

    public ObservableList<String> getLanguageList() {
        return languageList;
    }

    public String getLanguageFxObjectProperty() {
        return languageFxObjectProperty.get();
    }

    public ObjectProperty<String> languageFxObjectPropertyProperty() {
        return languageFxObjectProperty;
    }

    public ObservableList<String> getTypeList() {
        return typeList;
    }

    public String getTypeFxObjectProperty() {
        return typeFxObjectProperty.get();
    }

    public ObjectProperty<String> typeFxObjectPropertyProperty() {
        return typeFxObjectProperty;
    }

    public void setColorsList(ObservableList<String> colorsList) {
        this.colorsList = colorsList;
    }

    public void setColorFxObjectProperty(String colorFxObjectProperty) {
        this.colorFxObjectProperty.set(colorFxObjectProperty);
    }

    public void setLanguageList(ObservableList<String> languageList) {
        this.languageList = languageList;
    }

    public void setLanguageFxObjectProperty(String languageFxObjectProperty) {
        this.languageFxObjectProperty.set(languageFxObjectProperty);
    }

    public void setTypeList(ObservableList<String> typeList) {
        this.typeList = typeList;
    }

    public void setTypeFxObjectProperty(String typeFxObjectProperty) {
        this.typeFxObjectProperty.set(typeFxObjectProperty);
    }

    public ObservableList<String> getPatrernList() {
        return patrernList;
    }

    public void addPatrernList(String name) {
        this.patrernList.add(name);
    }
    public void setPatrernList(ObservableList<String> patrernList) {
        this.patrernList = patrernList;
    }

    public String getPatternFxObjectProperty() {
        return patternFxObjectProperty.get();
    }

    public ObjectProperty<String> patternFxObjectPropertyProperty() {
        return patternFxObjectProperty;
    }

    public void setPatternFxObjectProperty(String patternFxObjectProperty) {
        this.patternFxObjectProperty.set(patternFxObjectProperty);
    }
}
