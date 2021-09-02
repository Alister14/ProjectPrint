package pl.Data;

import pl.modelFx.ClientFx;
import pl.modelFx.MarkFx;
import pl.struckture.*;
import pl.utilis.DataBaseUtilis;

import java.sql.*;
import java.util.ArrayList;


public class DatabaseHandling {
    private static final String databaseURL = "jdbc:ucanaccess://src/main/resources/database/sito2.accdb";
    private static LibraryDatabase libraryDatabase;
    private static DataBaseUtilis dataBaseUtilis;

    public static void ReadDatabase() {

        ArrayList<Client> clients = readClientsFromDatabase();
        ArrayList<Pattern> patterns = readPatternsFromDatabase();
        ArrayList<Screen> screens = readScreensFromDatabase();
        ArrayList<Quantity> quantities = readQuantitiesFromDatabase();
        ArrayList<Order> orders = readOrdersFromDatabase();
        ArrayList<Mark> marks = readMarksFromDatabase();
        ArrayList<String> langauges=readLanguageFromDatabase();
        ArrayList<String> colors=readeColorsFromDatabase();
        ArrayList<String> types=readTypesFromDatabase();
        libraryDatabase = new LibraryDatabase(clients, orders, patterns, screens, quantities, marks,langauges,colors,types);

    }




    private static ArrayList<Client> readClientsFromDatabase() {
        ArrayList<Client> clients = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Clients";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Integer idClient = result.getInt("idClient");
                String name = result.getString("ClientName");

                clients.add(new Client(name, idClient));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;
    }

    private static ArrayList<Screen> readScreensFromDatabase() {
        ArrayList<Screen> screens = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Screens";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Integer idScreen = result.getInt("idScreen");
                Integer idPatterns = result.getInt("idPatterns");
                Integer numberScreen = result.getInt("numberScreen");
                String nameScreen = result.getString("nameScreen");
                Integer orders = result.getInt("orders");
                String paint = result.getString("paint");
                boolean availability = result.getBoolean("availability");
                Integer density = result.getInt("density");
                String sign = result.getString("sign");
                screens.add(new Screen(idScreen, idPatterns, numberScreen, nameScreen, orders, paint, availability, density, sign));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return screens;
    }

    private static ArrayList<Mark> readMarksFromDatabase() {
        ArrayList<Mark> marks = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Marks";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Integer idMark = result.getInt("idMark");
                String mark = result.getString("mark");

                marks.add(new Mark(idMark, mark));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return marks;
    }

    private static ArrayList<String> readLanguageFromDatabase() {
        ArrayList<String> languages = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Languages";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String language = result.getString("language");

                languages.add(language);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return languages;
    }

    private static ArrayList<String> readeColorsFromDatabase() {
        ArrayList<String> colors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Colors";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String color = result.getString("color");

                colors.add(color);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return colors;
    }

    private static ArrayList<String> readTypesFromDatabase() {
        ArrayList<String> types = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Types";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String type = result.getString("type");

                types.add(type);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return types;
    }

    private static ArrayList<Quantity> readQuantitiesFromDatabase() {
        ArrayList<Quantity> quantities = new ArrayList<>();
        ArrayList<Mark> marks = readMarksFromDatabase();
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Quantity";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Integer idQuantity = result.getInt("idQuantity");
                Integer sizeS = result.getInt("sizeS");
                Integer sizeM = result.getInt("sizeM");
                Integer sizeL = result.getInt("sizeL");
                Integer sizeXL = result.getInt("sizeXL");
                Integer size2XL = result.getInt("size2XL");
                Integer size3XL = result.getInt("size3XL");
                Integer size4XL = result.getInt("size4XL");
                Integer size5XL = result.getInt("size5XL");
                Integer other = result.getInt("other");
                Integer idMark = result.getInt("idMark");
                for (Mark mark : marks) {
                    if (idMark == mark.getIdMark()) {
                        quantities.add(new Quantity(idQuantity, sizeS, sizeM, sizeL, sizeXL,
                                size2XL, size3XL, size4XL, size5XL, other, idMark, mark.getMark()));
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return quantities;
    }

    private static ArrayList<Pattern> readPatternsFromDatabase() {
        ArrayList<Pattern> patterns = new ArrayList<>();
        ArrayList<Screen> screens = readScreensFromDatabase();
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Patterns";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                ArrayList<Screen> screensWithPatterns = new ArrayList<>();
                Integer idPattern = result.getInt("idPattern");
                String description = result.getString("description");
                String imagePath = result.getString("imagePath");
                String namePattern = result.getString("namePattern");
                Integer numberOfScreen = result.getInt("numberOfScreen");
                String colors = result.getString("colors");
                String language = result.getString("language");
                String type = result.getString("type");
                for (int i = 0; i < screens.size(); i++) {
                    if (idPattern == screens.get(i).getIdPatterns()) {
                        screensWithPatterns.add(screens.get(i));
                    }
                }
                patterns.add(new Pattern(screensWithPatterns, idPattern, description, imagePath, namePattern, numberOfScreen,
                        colors, language, type));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return patterns;
    }

    private static ArrayList<Order> readOrdersFromDatabase() {
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Client> clients = readClientsFromDatabase();
        ArrayList<Pattern> patterns = readPatternsFromDatabase();
        ArrayList<Quantity> quantities = readQuantitiesFromDatabase();
        Client client = new Client();
        Pattern pattern = new Pattern();
        Quantity quantity = new Quantity();

        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Orders";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Integer idOrder = result.getInt("idOrder");
                Integer idPatterns = result.getInt("idPatterns");
                Integer idClients = result.getInt("idClients");
                Integer idQuantity = result.getInt("idQuantity");
                for (int i = 0; i < clients.size(); i++) {
                    if (clients.get(i).getIdClient() == idClients)
                        client = clients.get(i);
                }
                for (int i = 0; i < patterns.size(); i++) {
                    if (patterns.get(i).getId() == idPatterns)
                        pattern = patterns.get(i);
                }
                for (int i = 0; i < quantities.size(); i++) {
                    if (quantities.get(i).getIdQuantity() == idQuantity)
                        quantity = quantities.get(i);
                }


                orders.add(new Order(idOrder, client, pattern, quantity));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orders;
    }


    public static void addNewClient(ArrayList<Client> clients, String clientName) {
        Integer idClient = 1;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getIdClient() == idClient) {
                idClient++;
            } else break;
        }

        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "INSERT INTO Clients (idClient, clientName) VALUES ( ?, ?) ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idClient);
            preparedStatement.setString(2, clientName);
            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("Dodalem klienta " + clientName);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        libraryDatabase.setClients(readClientsFromDatabase());
        System.out.println(libraryDatabase.getClients().toString());
    }

    public static void addNewScreens(ArrayList<Screen> screens, ArrayList<Pattern> patterns, String nameScreen, Integer orders, String paint, Integer density, String sign) {
        Integer idScreen = DataBaseUtilis.findNewIdScreens(screens);
        Integer idPatterns = DataBaseUtilis.findIdPattern(patterns, nameScreen);
        boolean availability = true;
        DataBaseUtilis.uploadNumberofScreens(idPatterns, patterns);
        Integer numberScreen;
        if (sign.equals("O")) {
            numberScreen = DataBaseUtilis.finNewNumberScreenWithSignO(screens, nameScreen, sign);
        } else numberScreen = DataBaseUtilis.finNewNumberScreen(screens, sign);


        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "INSERT INTO Screens (idScreen, idPatterns,numberScreen,nameScreen,orders,paint,availability,density,sign) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idScreen);
            preparedStatement.setInt(2, idPatterns);
            preparedStatement.setInt(3, numberScreen);
            preparedStatement.setString(4, nameScreen);
            preparedStatement.setInt(5, orders);
            preparedStatement.setString(6, paint);
            preparedStatement.setBoolean(7, availability);
            preparedStatement.setInt(8, density);
            preparedStatement.setString(9, sign);
            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("Dodalem sito " + nameScreen);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        libraryDatabase.setScreens(readScreensFromDatabase());
    }

    public static void addNewMark(ArrayList<Mark> marks, String mark) {
        Integer idMark = 1;
        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i).getIdMark() == idMark) {
                idMark++;
            } else break;
        }

        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "INSERT INTO Marks (idMark, mark) VALUES ( ?, ?) ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idMark);
            preparedStatement.setString(2, mark);
            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("Dodalem marke " + mark);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        libraryDatabase.setMarks(readMarksFromDatabase());
    }

    public static void addNewQuantity(ArrayList<Quantity> quantities, Integer sizeS, Integer sizeM,
                                      Integer sizeL, Integer sizeXL, Integer size2XL, Integer size3XL, Integer size4XL,
                                      Integer size5XL, Integer other, Integer idMark) {
        Integer idQuantity = 1;
        for (int i = 0; i < quantities.size(); i++) {
            if (quantities.get(i).getIdQuantity() == idQuantity) {
                idQuantity++;
            } else break;
        }

        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "INSERT INTO Quantity (idQuantity, sizeS,sizeM,sizeL," +
                    "sizeXL,size2XL,size3XL,size4XL,size5XL,other,idMark) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idQuantity);
            preparedStatement.setInt(2, sizeS);
            preparedStatement.setInt(3, sizeM);
            preparedStatement.setInt(4, sizeL);
            preparedStatement.setInt(5, sizeXL);
            preparedStatement.setInt(6, size2XL);
            preparedStatement.setInt(7, size3XL);
            preparedStatement.setInt(8, size4XL);
            preparedStatement.setInt(9, size5XL);
            preparedStatement.setInt(10, other);
            preparedStatement.setInt(11, idMark);
            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("Dodalem ilosc o id " + idQuantity);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        libraryDatabase.setQuantities(readQuantitiesFromDatabase());
    }

    public static void addNewPattern(ArrayList<Pattern> patterns, String description, String imagePath, String namePattern, String colors, String language, String type) {
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            Integer idPattern = DataBaseUtilis.findNewIdPattern(patterns);
            Integer numberOfScreen = 0;
            String sql = "INSERT INTO Patterns (idPattern, description,imagePath,namePattern,numberOfScreen,colors,language,type) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?) ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPattern);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, imagePath);
            preparedStatement.setString(4, namePattern);
            preparedStatement.setInt(5, numberOfScreen);
            preparedStatement.setString(6, colors);
            preparedStatement.setString(7, language);
            preparedStatement.setString(8, type);
            int row = preparedStatement.executeUpdate();


            if (row > 0) {
                System.out.println("Dodalem wzor " + namePattern);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        libraryDatabase.setPatterns(readPatternsFromDatabase());
    }

    public static void addNewOrder(ArrayList<Order> orders, Integer idPatterns,Integer idClients,Integer idQuantity) {
        Integer idOrder = 1;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getIdOrder() == idOrder) {
                idOrder++;
            } else break;
        }

        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "INSERT INTO Clients (idOrder, idPatterns,idClients,idQuantity) VALUES ( ?, ?, ?, ?) ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idOrder);
            preparedStatement.setInt(2, idPatterns);
            preparedStatement.setInt(3, idClients);
            preparedStatement.setInt(4, idQuantity);
            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("Dodalem zamówienie nr " + idOrder);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        libraryDatabase.setOrders(readOrdersFromDatabase());
        System.out.println(libraryDatabase.getOrders().toString());
    }




    public static ArrayList<Client> getClients() {
        return libraryDatabase.getClients();
    }

    public static ArrayList<Order> getOrders() {
        return libraryDatabase.getOrders();
    }

    public static ArrayList<Pattern> getPatterns() {
        return libraryDatabase.getPatterns();
    }

    public static ArrayList<Screen> getScreens() {
        return libraryDatabase.getScreens();
    }

    public static ArrayList<Mark> getMarks() {
        return libraryDatabase.getMarks();
    }

    public static ArrayList<String> getLannguage() {
        return libraryDatabase.getLanguages();
    }

    public static ArrayList<String> getColors() {
        return libraryDatabase.getColors();
    }
    public static ArrayList<String> getType() {
        return libraryDatabase.getTypes();
    }

    public static void deleteClient(ClientFx client) {
        Integer id = client.getIdClient();


        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "DELETE FROM Clients WHERE idClient=" +id;


            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("usuneloem klienta " + client.getName());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        libraryDatabase.setClients(readClientsFromDatabase());
        System.out.println(libraryDatabase.getClients().toString());
    }

    public static void deleteMark(MarkFx markFx) {
        Integer id = markFx.getIdMark();


        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "DELETE FROM Marks WHERE idMark=" +id;


            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("usuneloem marke " + markFx.getMark());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        libraryDatabase.setMarks(readMarksFromDatabase());
        System.out.println(libraryDatabase.getMarks().toString());
    }
}
