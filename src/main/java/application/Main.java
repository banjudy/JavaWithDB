package application;

import application.database.DBEngine;
import application.models.Dragon;
import application.models.Rarity;

import java.sql.SQLOutput;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //playground :)

        DBEngine engine = new DBEngine();
        System.out.println(engine.isConnected());

        //System.out.println(System.getenv("DB_USER"));
        //System.out.println(System.getenv("DB_PASSWORD"));

       if (engine.isConnected()) {
            Dragon dragon = new Dragon("Paff", "A bűvös sárkány", Rarity.HEROIC);
            boolean success = engine.addDragonToDB(dragon);
           System.out.println(success);
        } else {
            System.out.println("no connection");
        }


    }
}
