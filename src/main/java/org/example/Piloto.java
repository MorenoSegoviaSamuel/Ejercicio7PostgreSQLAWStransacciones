package org.example;

import java.time.LocalDate;

public class Piloto {

    private String driverId;
    private String code;
    private String forename;
    private String surname;
    private LocalDate dob;
    private String nationality;
    private String url;
    private Constructor equipo;


    public Piloto(String driverId, String code, String forename, String surname, LocalDate dob, String nationality, String url, Constructor equipo) {
        this.driverId = driverId;
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.url = url;
        this.equipo = equipo;
    }

    public Piloto(String code, String forename, String surname, LocalDate dob, String nationality, String url, Constructor equipo) {
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.url = url;
        this.equipo = equipo;
    }

    public Constructor getEquipo() {
        return equipo;
    }

    public String getCode() {
        return code;
    }



    public String getForename() {
        return forename;
    }



    public String getSurname() {
        return surname;
    }



    public LocalDate getDob() {
        return dob;
    }



    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "code='" + code + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", nationality='" + nationality + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

