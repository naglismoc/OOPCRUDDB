package org.example;

import org.example.models.Author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
    public static Scanner sc;
    public static void main(String[] args) {
        System.out.println(Author.selectAll());
        Author a =  Author.findById(8);
        System.out.println(a);
        a.setName("Valdemaras");
        a.setSurname("Vunderkindas");
        a.update();
        a = Author.findById(8);
        System.out.println(a);
        Author.delete(112);
        Author.create("Valdemaras","Jaunesnysis Indigo-Vunderkindas");


        sc = new Scanner(System.in);
        while(true){
            System.out.println("1. authors");
            System.out.println("2. books");
            switch (sc.nextInt()){
                case 1://autoriai
                    authorsMenu();
                    break;
                case 2://knygos
                   booksMenu();
                    break;
                case 3://exit
                    break;
            }
        }
    }

    public static void booksMenu(){
        boolean doBooks = true;
        while(doBooks){
            switch (sc.nextInt()){
                case 1://
                    System.out.println("select all books");
                    break;
                case 2://select 1
                    System.out.println("select 1 book");
                    break;
                case 3://insert
                    System.out.println("insert 1 book");
                    break;
                case 4://update
                    System.out.println("update 1 book");
                    break;
                case 5://delete
                    System.out.println("delete 1 book");
                    break;
                case 6://go back
                    System.out.println("go back to main menu");
                    doBooks = false;
                    break;
                case 7://exit
                    System.out.println("quit");
                    break;
            }
        }
    }
    public static void authorsMenu(){
        boolean doAuthors = true;
        while(doAuthors){
            switch (sc.nextInt()){
                case 1://
                    System.out.println("select all authors");
                    break;
                case 2://select 1
                    System.out.println("select 1 author");
                    break;
                case 3://insert
                    System.out.println("insert 1 author");
                    break;
                case 4://update
                    System.out.println("update 1 author");
                    break;
                case 5://delete
                    System.out.println("delete 1 author");
                    break;
                case 6://go back
                    System.out.println("go back to main menu");
                    doAuthors = false;
                    break;
                case 7://exit
                    System.out.println("quit");
                    break;
            }
        }
    }
    public static Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaa_240513_library","root","");
        }catch (Exception e){
            System.out.println("Failed to connect to database");
        }
        return connection;
    }
}