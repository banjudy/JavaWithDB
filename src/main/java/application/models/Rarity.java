package application.models;

public enum Rarity {


    COMMON,         //DB-ben ez az 1-es indexen van
    RARE,           //2
    VERY_RARE,      //3
    EPIC,           //4
    LEGENDARY,      //5
    HEROIC;         //6

    public static Rarity find(String name) {
        for (Rarity rarity : Rarity.values()) {
            if (rarity.toString().equalsIgnoreCase(name))
                return rarity;
        }
        return Rarity.COMMON;
    }

    public int getDBIndex() {

        return ordinal() + 1;
    }

}
