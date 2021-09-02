package pl.struckture;

public class Screen {
    protected Integer id;
    protected Integer idPatterns;//numerWzoru
    protected Integer numberScreen;
    protected String name;//Nazwa sita
    protected Integer order;//Kolejnosc
    protected String paint;//farba
    protected boolean availability;//Czyt sito jest dostępne
    protected Integer density;//Na jakiej siatce sito zostało naświetlone
    protected String sign;//oznaczenie sita

    public Screen(Integer id, Integer idPatterns, Integer numberScreen, String name, Integer order, String paint, boolean availability, Integer density, String sign) {
        this.id = id;
        this.idPatterns = idPatterns;
        this.numberScreen = numberScreen;
        this.name = name;
        this.order = order;
        this.paint = paint;
        this.availability = availability;
        this.density = density;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return " sito ze wzorem "+ name + " jego numer=" + numberScreen +
                " kolejnosc na maszynie =" + order +
                " farba " + paint +
                " czy jest dostepne " + availability +
                " jaka gestosc siatki " + density +"\n";
    }


    public String getName() {
        return name;
    }

    public int getIdPatterns() {
        return idPatterns;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumberScreen() {
        return numberScreen;
    }

    public String getSign() {
        return sign;
    }


    public Integer getOrder() {
        return order;
    }

    public String getPaint() {
        return paint;
    }

    public boolean isAvailability() {
        return availability;
    }

    public Integer getDensity() {
        return density;
    }

    public void setName(String name) {
        this.name = name;
    }
}//Klasa która ma za zadanie tworzyć obiekt sito
