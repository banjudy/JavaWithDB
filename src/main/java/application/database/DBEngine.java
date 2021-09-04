package application.database;

import application.models.Dragon;
import application.models.Rarity;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBEngine {

    private Connection connection;

    public DBEngine() {
        connection = connect();

    }
    public boolean isConnected() {
        return (connection != null);
    }

    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/dragonDB" +
                "?useUnicode=yes&characterEncoding=UTF-8";

        Properties properties = new Properties();
        properties.put("user", System.getenv("DB_USER"));
        properties.put("password", System.getenv("DB_PASSWORD"));

        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            return null;
        }
    }

    public Dragon findDragonByName(String searchName) {
        String query = "SELECT * FROM dragon WHERE unique_name = ?";

        Dragon result = null;

        try {
            //Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, searchName);
            ResultSet resultSet = ps.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");   //adatbazisban szerepli mezo neve kerul ide, ill. ugyanez resultSet.getLong(1);
                String name = resultSet.getString("unique_name");
                String text = resultSet.getString("dragon_text");
                String rarityFromDB = resultSet.getString("rarity");    //Rarity rarity = Rarity.valuOf(rarityFromDB.toUpperCas());
                Rarity rarity = Rarity.find(rarityFromDB);

                result = new  Dragon(id, name, text, rarity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //utasítás, ami visszaad minden sárkányt a DB-ből

    public List<Dragon> listAllDragons(){
        String query = "SELECT * FROM dragon;";

        List<Dragon> dragons = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");   //adatbazisban szerepli mezo neve kerul ide, ill. ugyanez resultSet.getLong(1);
                String name = resultSet.getString("unique_name");
                String text = resultSet.getString("dragon_text");
                String rarityFromDB = resultSet.getString("rarity");    //Rarity rarity = Rarity.valuOf(rarityFromDB.toUpperCas());
                Rarity rarity = Rarity.find(rarityFromDB);

                Dragon dragon = new Dragon(id, name, text, rarity);

                dragons.add(dragon);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dragons;
    }


}
