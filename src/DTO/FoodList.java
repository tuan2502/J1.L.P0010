/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import MyValidation.Inputter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class FoodList extends ArrayList<Food> {

    public FoodList() {
        super();
    }

    public Food searchID(String code) {
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equalsIgnoreCase(code)) {
                return this.get(i);
            }
        }
        return null;
    }

    private boolean isCodeDuplicated(String ID) {
        ID = ID.trim().toUpperCase();
        return searchID(ID) != null;
    }

    public void addFood() {
        String newFoodID, newFoodName, newType, newPlace;
        LocalDate newExDate;
        double newWeight;
        boolean IdDuplicated = false;
        boolean cont = false;
        String ans;
        do {
            try {
                System.out.println("Add new Food details");
                do {
                    newFoodID = Inputter.inputStr("Input new Food ID: ");
                    newFoodID = newFoodID.trim().toUpperCase();
                    IdDuplicated = isCodeDuplicated(newFoodID);
                    if (IdDuplicated) {
                        System.out.println("Food ID is duplicated!");
                    }
                } while (IdDuplicated == true);
                newFoodName = Inputter.inputNonBlankStr("New Food Name: ");
                newFoodName = newFoodName.toUpperCase();
                newWeight = Inputter.inputDouble("New Weight: ", 0);
                newType = Inputter.inputNonBlankStr("New Type: ");
                newType = newType.toUpperCase();
                newPlace = Inputter.inputNonBlankStr("New Place: ");
                newPlace = newPlace.toUpperCase();
                newExDate = Inputter.inputNonBlankStr_Date("New Expired Date (dd/mm/yyyy): ");
                Food f = new Food(newFoodID, newFoodName, newWeight, newType, newPlace, newExDate);
                this.add(f);
                System.out.println("Food " + newFoodID + " has been added.");
                ans = Inputter.inputNonBlankStr_Pattern("Do you want to continue adding another food? (Y/N): ", "[Y]|[N]");
                if (ans.equalsIgnoreCase("Y")) {
                    cont = true;
                }
                if (ans.equalsIgnoreCase("N")) {
                    cont = false;
                }
            } catch (Exception e) {
                System.out.println("Error!");
                cont = true;
            }
        } while (cont);

    }

    public Food searchByName(String fName) {
        fName = fName.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getName().contains(fName)) {
                return this.get(i);
            }
        }
        return null;
    }

    public void searchFoodByName() {
        String sName;
        boolean cont = false;
        String ans;
        do {
            try {
                if (this.isEmpty()) {
                    System.out.println("Empty list: No search can be performed!");
                } else {
                    sName = Inputter.inputStr("Input Food name for search: ");
                    Food f = this.searchByName(sName);
                    if (f == null) {
                        System.out.println("This food doesn't exist!");
                    } else {
                        System.out.println("Found: " + f);
                    }
                }
                ans = Inputter.inputNonBlankStr_Pattern("Do you want to continue searching another food? (Y/N): ", "[Y]|[N]");
                if (ans.equalsIgnoreCase("Y")) {
                    cont = true;
                }
                if (ans.equalsIgnoreCase("N")) {
                    cont = false;
                }
            } catch (Exception e) {
                System.out.println("Error!");
                cont = true;
            }
        } while (cont);
    }

    public void removeFoodByID() {
        boolean cont = false;
        String ans;
        do {
            try {
                if (this.isEmpty()) {
                    System.out.println("Empty list: No search can be performed!");
                } else {
                    String rID = Inputter.inputStr("Input Food ID code for search: ");
                    Food f = this.searchID(rID); 
                    if (f == null) {
                        System.out.println("This food doesn't existed.");
                        cont = true;
                    } else {
                        ans = Inputter.inputNonBlankStr_Pattern("Do you want to remove this food? (Y/N): ", "[Y]|[N]");
                        if (ans.equalsIgnoreCase("Y")) {
                            this.remove(f);
                            System.out.println("Food " + rID + " has been removed.");
                            cont = false;
                        }
                        if (ans.equalsIgnoreCase("N")) {
                            cont = false;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error!");
                cont = true;
            }
        } while (cont);
    }

    public void listFoods() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("Food list: ");
            this.sort(null);
            Collections.reverse(this);
            for (Food f : this) {
                System.out.println(f);
            }
            System.out.println("Total: " + this.size() + " Food(s).");
        }
    }

    public boolean saveToFile(String fName) {
        if (this.isEmpty()) {
            System.out.println("Empty List");
            return false;
        }
        try {
            File f = new File(fName);
            FileOutputStream fw = new FileOutputStream(f);
            ObjectOutputStream fo = new ObjectOutputStream(fw);
            for (Food x : this) {
                fo.writeObject(x);
            }
            fo.close();
            fw.close();
            System.out.println("Saving succesfully!");
        } catch (Exception e) {
            System.out.println("Error!");
        }
        return true;
    }
}
