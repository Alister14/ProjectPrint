package pl.utilis;

import pl.struckture.Pattern;
import pl.struckture.Screen;

import java.util.ArrayList;

public class DataBaseUtilis {


    public static int findNewIdPattern(ArrayList<Pattern> patterns) {

        int idPattern = 1;//To ustawiamy je na 1 bo od tego zaczynamy nasze id
        for (int i = 0; i < patterns.size(); i++) {//następnie skanujemy całą liste patterns
            if (patterns.get(i).getId() == idPattern) {//Jeśli nasze id jest takie samo jak id które jest już na liście
                //   System.out.println("dalej szukam swojego idPattern, akttualne idPattern to "+idPattern);
                idPattern++;//to wtedy zwiekszamy je o 1 i szukamy dalej
            } else {
                //  System.out.println("znalazłem swoj numer "+idPattern);
                break;
            } //Jeśli natomiast jest inne to wtedy przerywamy pętle
        }
        return idPattern;//z naszym znalezionym idPattern wychodzimy z funkcji
    }

    public static int findIdPattern(ArrayList<Pattern> patterns, String nameScreen) {
        int idPattern = 1406;//To ustawiamy je na 1406 bo wtedy bedziemy wiedziec ze cos sie zepsulo
        for (int i = 0; i < patterns.size(); i++) {//następnie skanujemy całą liste patterns
            if (patterns.get(i).getName().equals(nameScreen)) {
                idPattern = patterns.get(i).getId();
                break;
            }
        }
        return idPattern;//z naszym znalezionym idPattern wychodzimy z funkcji
    }

    public static int findNewIdScreens(ArrayList<Screen> screens) {
        Integer idScreen = 1;
        for (int i = 0; i < screens.size(); i++) {
            if (screens.get(i).getId() == idScreen) {
                idScreen++;
            } else break;
        }//Tutaj chodzi o wyszkanie miejsca dla idScreen by bylo niepowtarzalne
        return idScreen;
    }


    public static int finNewNumberScreenWithSignO(ArrayList<Screen> screens, String nameScreen, String sign) {
        Integer numberScreen = -1;//Ustawiamy na -1 bo numberScreen zawsze jest dodatni
        if (sign.equals(sign)) {//Jeżeli nasz sign to O to wtedy
            for (int i = 0; i <= screens.size(); i++) {//Przelatujemy przez całą liste screens
                if (screens.get(i).getName().equals(nameScreen)) {//Jeżeli jakis screens ma taka samą nazwe jak nasza
                    numberScreen = screens.get(i).getNumberScreen();//to wtedy ustawiami jego numer na nasz
                    break;//i wychodzimy z pętli
                }
            }//jeśli pętla przeszła i nic się nie zmieniło
            if (numberScreen == -1) {//Czyli nasze numberScreen dalej równa się-1
                numberScreen = finNewNumberScreen(screens, sign);
            }
        }
        return numberScreen;
    }

    public static int finNewNumberScreen(ArrayList<Screen> screens, String sign) {
        Integer numberScreen = 1;//Ustawiamy je na 1, bo to jest początek naszej numeracji sit
        ArrayList<Screen> screensWithSing = new ArrayList<>();//Tworzymy nową liste która będzie miała tylko te screensy z odpowiednim znakiem
        for (int i = 0; i < screens.size(); i++) {//Przelatujemy po całej liście screens by znaleźć te
            if (screens.get(i).getSign().equals(sign)) {//które mają taki sam znak jak nasz
                screensWithSing.add(screens.get(i));//jeśli mają to dodajemy je do wcześneijszej listy
            }
        }
        Integer badNumber = 0;
        numberScreen = 1;//To wtedy ustawiamy je na 1, bo to jest początek naszej numeracji sit
        for (int i = 0; i < screensWithSing.size(); i++) {// przelatujemy przez liste screens
            if (screensWithSing.get(i).getNumberScreen() == numberScreen || screensWithSing.get(i).getNumberScreen() == badNumber) {
                numberScreen++;
                badNumber = screensWithSing.get(i).getNumberScreen();
                //Jeżeli nasza wartosc numberScreen jest taka sama lub nasz badNumber jest taki jak poprzedni
                // to dodajemy 1 i zmieniamy badNumber na aktualna pozycje
            }
        }                //Jeżeli mamy inna wartosc numberScreen


        return numberScreen;
    }

    public static void uploadNumberofScreens(Integer idPatterns,ArrayList<Pattern> patterns){
        int place=0;
        int numberOfScreen=0;
        for(int i=0;i<patterns.size();i++){
            if(patterns.get(i).getId()==idPatterns){
                place=i;
                break;
            }
        }
        numberOfScreen=patterns.get(place).getNumberOfScreen();
        numberOfScreen++;
        patterns.get(place).setNumberOfScreen(numberOfScreen);

    }

}
