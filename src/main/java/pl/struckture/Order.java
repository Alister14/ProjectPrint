package pl.struckture;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    protected int idOrder;
    protected Client client=new Client();
    protected Pattern pattern=new Pattern();
    protected Quantity quantity=new Quantity();

    public Order(int idOrder, Client client, Pattern pattern, Quantity quantity) {
        this.idOrder = idOrder;
        this.client = client;
        this.pattern = pattern;
        this.quantity = quantity;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public Client getClient() {
        return client;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Zamowieninie o numerze " + idOrder +"\n"+
                "klient " + client.getName() +"\n"+
                "wzor " + pattern.getName() +"\n"+
                "ilosc " + quantity+"\n\n";
    }
}//Klasa w której klient zostanie połączony ze wzorkiem i iloscia zamowienia
