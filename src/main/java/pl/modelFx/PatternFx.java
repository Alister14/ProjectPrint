package pl.modelFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PatternFx {

    private IntegerProperty id=new SimpleIntegerProperty();
    private StringProperty description=new SimpleStringProperty();
    private StringProperty imagePath=new SimpleStringProperty();
    private StringProperty name=new SimpleStringProperty();
    private IntegerProperty numberOfScreen=new SimpleIntegerProperty();
    private StringProperty colors=new SimpleStringProperty();
    private StringProperty language=new SimpleStringProperty();
    private StringProperty type=new SimpleStringProperty();


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getImagePath() {
        return imagePath.get();
    }

    public StringProperty imagePathProperty() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath.set(imagePath);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getNumberOfScreen() {
        return numberOfScreen.get();
    }

    public IntegerProperty numberOfScreenProperty() {
        return numberOfScreen;
    }

    public void setNumberOfScreen(int numberOfScreen) {
        this.numberOfScreen.set(numberOfScreen);
    }

    public String getColors() {
        return colors.get();
    }

    public StringProperty colorsProperty() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors.set(colors);
    }

    public String getLanguage() {
        return language.get();
    }

    public StringProperty languageProperty() {
        return language;
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    @Override
    public String toString() {
        return "PatternFx{" +
                "id=" + id +
                ", description=" + description +
                ", imagePath=" + imagePath +
                ", name=" + name +
                ", numberOfScreen=" + numberOfScreen +
                ", colors=" + colors +
                ", language=" + language +
                ", type=" + type +
                '}';
    }
}
