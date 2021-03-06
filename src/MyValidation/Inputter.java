/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyValidation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    public static double inputDouble(String msg, double min) throws Exception{
        double data;
        do{
            System.out.print(msg);
            data = Double.parseDouble(sc.nextLine());
        }
        while(data<=min);
        return data;
    }
    public static String inputStr(String msg) throws Exception{
        System.out.print(msg);
        String data = sc.nextLine().trim();
        return data;
    }
    public static String inputNonBlankStr(String msg) throws Exception{
        String data;
        do{
            System.out.print(msg);
            data = sc.nextLine().trim();
        }
        while(data.length()==0);
        return data;
    }
    public static String inputPattern(String msg, String pattern) throws Exception{
        String data;
        do{
            System.out.print(msg);
            data = sc.nextLine().trim();
        }while(!data.matches(pattern));
        return data;
    }
    
    public static String inputNonBlankStr_Pattern(String msg, String pattern) throws Exception{
        String data;
        do{
            System.out.print(msg);
            data = sc.nextLine().trim().toUpperCase();
        }while(data.length()==0 || !data.matches(pattern));
        return data;
    }
    
    public static LocalDate inputNonBlankStr_Date(String msg) throws Exception{
        LocalDate lcd ;
        String data;          
        do{
            System.out.print(msg);
            data = sc.nextLine().trim();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            lcd = LocalDate.parse(data, dtf);
            System.out.println(lcd);
        }
        while(data.length()==0);
        return lcd;
    }
}
