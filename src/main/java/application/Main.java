package application;

import application.database.DBEngine;
import application.models.Dragon;

import java.sql.SQLOutput;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //playground :)

        DBEngine engine = new DBEngine();
        System.out.println(engine.isConnected());

        //System.out.println(System.getenv("DB_USER"));
        //System.out.println(System.getenv("DB_PASSWORD"));

        List<Dragon> myDragons;

        myDragons = engine.listAllDragons();

        for (Dragon dragon:myDragons) {
            System.out.println("no connection");
        }
    }
}
