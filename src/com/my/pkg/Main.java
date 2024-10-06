package com.my.pkg;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // scanner object
        crudStudent crud = new crudStudent(); //crud student object

        while (true) {
            //Main.Main UI
            System.out.println("\n");
            System.out.println("1. Add student ");
            System.out.println("2. View student ");
            System.out.println("3. Update student ");
            System.out.println("4. Delete student ");
            System.out.println("5. Exit");
            System.out.print("-> ");
            String user = scanner.nextLine();

            switch (user) {
                case "1":
                    crud.addStudent();
                    break;
                case "2":
                    crud.viewStudent();
                    break;
                case "3":
                    crud.updateStudent();
                    break;
                case "4":
                    crud.deleteStudent();
                    break;
                case "5":
                    System.out.println("Exitting...");
                    return;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}