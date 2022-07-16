/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class Food implements Comparable, Serializable{
    String id = "";
    String name = "";
    double weight = 0;
    String type = "";
    String place = "";
    LocalDate exDate = null;
    
    public Food() {
    }

    public Food(String Id, String Name, double Weight, String Type, String Place, LocalDate ExDate){
        this.id = Id;
        this.name = Name;
        this.weight = Weight;
        this.type = Type;
        this.place = Place;
        this.exDate = ExDate;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDate getDate() {
        return exDate;
    }

    public void setDate(LocalDate date) {
        this.exDate = date;
    }

    @Override
    public String toString() {
        return "Food: " + "ID: " + id + ", Name: " + name + ", Weight: " + weight + ", Type: " + type + ", Place: " + place + ", Date: " + exDate ;
    }
    
    @Override
    public int compareTo(Object o) {
        return this.getDate().compareTo(((Food)o).getDate());
    }

}
