package application;

import application.database.DBEngine;

public class Main {

    public static void main(String[] args) {
        //playground :)

        DBEngine engine = new DBEngine();
        System.out.println(engine.isConnected());

        //System.out.println(System.getenv("DB_USER"));
        //System.out.println(System.getenv("DB_PASSWORD"));
    }
}
