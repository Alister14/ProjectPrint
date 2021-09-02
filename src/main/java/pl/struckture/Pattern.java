package pl.struckture;

import java.util.ArrayList;

public class Pattern {
    ArrayList<Screen> patterns=new ArrayList<>();
    protected Integer id;
    protected String description;//Dodatkowe informacje
    protected String imagePath;//Sćieżka do zdjęcia wzoru
    protected String name;
    protected Integer numberOfScreen;
    protected String colors;
    protected String language;
    protected String type;


    public Pattern(ArrayList<Screen> patterns, Integer id, String description, String imagePath, String name, Integer numberOfScreen, String colors, String language, String type) {
        this.patterns = patterns;
        this.id = id;
        this.description = description;
        this.imagePath = imagePath;
        this.name = name;
        this.numberOfScreen = numberOfScreen;
        this.colors = colors;
        this.language = language;
        this.type = type;
    }

    public Pattern() {

    }

    public String getColors() {
        return colors;
    }

    public String getLanguage() {
        return language;
    }

    public String getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfScreen() {
        return numberOfScreen;
    }

    public void setNumberOfScreen(Integer numberOfScreen) {
        this.numberOfScreen = numberOfScreen;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Screen> getPatterns() {
        return patterns;
    }

    @Override
    public String toString() {
        return "wzor " + name+"\n"+
                "sita"+"\n"+ patterns+"\n";
    }
}//Klasa która tworzy wzory