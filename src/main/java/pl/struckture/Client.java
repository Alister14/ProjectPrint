package pl.struckture;

public class Client {
    protected String name;
    protected Integer idClient;

    public Client(String name, Integer idClient) {
        this.name = name;
        this.idClient = idClient;
    }

    public Client() {

    }


    public String getName() {
        return name;
    }

    public Integer getIdClient() {
        return idClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", idClient=" + idClient +
                '}';
    }
}//Klasa która stworzy klienta
