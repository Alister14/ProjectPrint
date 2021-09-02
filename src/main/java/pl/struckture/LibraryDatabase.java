package pl.struckture;

import java.util.ArrayList;

public class LibraryDatabase {
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Pattern> patterns = new ArrayList<>();
    private ArrayList<Screen> screens = new ArrayList<>();
    private ArrayList<Quantity> quantities = new ArrayList<>();
    private ArrayList<Mark> marks = new ArrayList<>();
    private ArrayList<String> languages=new ArrayList<>();
    private ArrayList<String> colors=new ArrayList<>();
    private ArrayList<String> types=new ArrayList<>();

    public LibraryDatabase(ArrayList<Client> clients, ArrayList<Order> orders, ArrayList<Pattern> patterns,
                           ArrayList<Screen> screens, ArrayList<Quantity> quantities, ArrayList<Mark> marks,
                           ArrayList<String> languages, ArrayList<String> colors, ArrayList<String> types) {
        this.clients = clients;
        this.orders = orders;
        this.patterns = patterns;
        this.screens = screens;
        this.quantities = quantities;
        this.marks = marks;
        this.languages = languages;
        this.colors = colors;
        this.types = types;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Pattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(ArrayList<Pattern> patterns) {
        this.patterns = patterns;
    }

    public ArrayList<Screen> getScreens() {
        return screens;
    }

    public void setScreens(ArrayList<Screen> screens) {
        this.screens = screens;
    }

    public ArrayList<Quantity> getQuantities() {
        return quantities;
    }

    public void setQuantities(ArrayList<Quantity> quantities) {
        this.quantities = quantities;
    }


    public void setMarks(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }


    public ArrayList<String> getLanguages() {
        return languages;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public ArrayList<String> getTypes() {
        return types;
    }
}
