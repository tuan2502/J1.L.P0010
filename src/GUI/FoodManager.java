/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Food;
import DTO.FoodList;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class FoodManager {
    public static void main(String[] args){
        String[] options = {"Add a new food.", "Search a food by name.", "Remove the food by ID."
        , "Print the food list in the descending order of exprired date.", "Save file.", "Quit."};
        FoodList fList = new FoodList();
        fList.add(new Food("F100", "Beef", 900 , "Animal", "2nd Floor", LocalDate.of(2021, 9, 15)));
        fList.add(new Food("F101", "Eggs", 500 , "Animal", "2nd Door", LocalDate.of(2021, 10, 23)));
        fList.add(new Food("F102", "Carrot", 300 , "Vegetable", "Box", LocalDate.of(2021, 9, 30)));
        fList.add(new Food("F103", "Potato", 500 , "Vegetable", "Box", LocalDate.of(2021, 9, 26)));
        fList.add(new Food("F104", "Milk", 800 , "Liquid", "1st Floor", LocalDate.of(2021, 9, 20)));       
        String fNameFood = "Foods.dat";
        int choice;
        Menu menu = new Menu();
        boolean cont = false;
        do{
            try{
                do{
                    System.out.println("\nFood Manager Program\n--------------------------------");
                    choice = menu.int_getChoice(options);
                    switch(choice){
                        case 1: fList.addFood(); break;
                        case 2: fList.searchFoodByName(); break;
                        case 3: fList.removeFoodByID(); break;
                        case 4: fList.listFoods(); break;
                        case 5: fList.saveToFile(fNameFood); break;
                        case 6: System.out.println("Bye");System.exit(0); break;
                        default: System.out.println("Incorrect!");break;
                    }
                }while(choice>0 || choice <8);
                cont = false;
            }catch (Exception e){
                System.out.println("Syntax Error!");
                cont = true;
            }
        }while(cont);
    }
}
