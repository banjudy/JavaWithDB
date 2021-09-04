package application.models;

public class Element {

    private String name;
    private byte[] icon_img;

    public Element() {
    }

    public Element(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getIcon_img() {
        return icon_img;
    }

    public void setIcon_img(byte[] icon_img) {
        this.icon_img = icon_img;
    }
}
