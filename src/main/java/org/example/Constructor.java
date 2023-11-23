package org.example;

public class Constructor {

    private int constructorId;
    private String constructorRef;
    private String name;
    private String nationality;
    private String url;

    public Constructor(int constructorId, String constructorRef, String name, String nationality, String url) {
        this.constructorId = constructorId;
        this.constructorRef = constructorRef;
        this.name = name;
        this.nationality = nationality;
        this.url = url;
    }


    public void setConstructorId(int constructorId) {
        this.constructorId = constructorId;
    }

    public Constructor(String constructorRef, String name, String nationality, String url) {
        this.constructorRef = constructorRef;
        this.name = name;
        this.nationality = nationality;
        this.url = url;
    }

    public int getConstructorId() {
        return constructorId;
    }

    public String getConstructorRef() {
        return constructorRef;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Constructor{" +
                "constructorId='" + constructorId + '\'' +
                ", constructorRef='" + constructorRef + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
