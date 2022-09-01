package sample;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private String Country;
    private int age;
    private double height;
    private String club;
    private String position;
    private int number;
    private double weeklysalary;


    public Player() {
        name = "";
        Country = "";
        this.club="";
        this.age = 0;
        this.height = 0;
        this.position = "";
        this.number =0;
        weeklysalary=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club=club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getWeeklysalary() {
        return weeklysalary;
    }

    public void setWeeklysalary(double weeklysalary) {
        this.weeklysalary = weeklysalary;
    }



}
