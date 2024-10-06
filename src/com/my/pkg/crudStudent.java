package com.my.pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class crudStudent {
    //Declare objects
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    List<Student> arr = new ArrayList<Student>();
    int id;
    //Add student
    public void addStudent() {
        while (true) {

            System.out.print("Enter Main.Main.Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Main.Main.Student Address: ");
            String address = scanner.nextLine();

            System.out.print("Enter Main.Main.Student Age: ");
            String age = scanner.nextLine();

            System.out.print("Education Level: ");
            String educationLevel = scanner.nextLine();

            System.out.print("Enter Program: ");
            String course = scanner.nextLine();

            System.out.print("Enter Grade or Year: ");
            int year = scanner.nextInt();


            //Store generated id
            id = generateId();

            //Assign the user input to the student constructor
            Student student = new Student(name, address, age, course, year, id);
            arr.add(student); //Store it to the list

            System.out.println("\nAdded succesfully!!");
            System.out.println("Main.Main.Student ID: " + id);
            scanner.nextLine();
            return;
        }
    }


    // View students
    public void viewStudent() {
        //Check if the student is empty
        if (arr.isEmpty()) {
            System.out.println("\nNo Main.Main.Student! You must add students first.");
            scanner.nextLine();
            return;
        } else {
            System.out.println("List of Students:");
            System.out.println("=====================");

            for (int i = 0; i < arr.size(); i++) { //iterate thru list to print the students
                Student student = arr.get(i);
                System.out.println((i + 1) + ". " + student);
                System.out.println("---------------------------");
            }
        }
    }


    //Update student
    public void updateStudent() {
        String newName, newAddress, newAge;

        //check if empty
        if (arr.isEmpty()) {
            System.out.println("\nNo Main Student! You must add students first.");
            scanner.nextLine();
            return;
        }

        //Display Students
        viewStudent();


        //Ask user which user to update
        System.out.print("Enter the index of the student you want to update: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        //Store the selected student into this
        Student selectedStudent = arr.get(index - 1);

        //check if the index is valid
        if (index <= 0 || index > arr.size()) {
            System.out.println("Invalid student index");
            return;
        }

        //If the index is valid
        System.out.print("\nUpdating details for student id: " + selectedStudent.getId() + "\n");

        while (true) {
            //Ask user to choose what to change
            System.out.println("1. To enter new name ");
            System.out.println("2. To enter new address ");
            System.out.println("3. To enter new age ");
            System.out.println("4. To exit ");
            System.out.print("-> ");
            String user = scanner.nextLine();


            //Assign new name
            switch (user) {
                case "1" -> {
                    System.out.println("Enter new name( press ENTER to keep the current name of the student )");
                    System.out.print("->");
                    newName = scanner.nextLine();
                    if (!newName.isEmpty()) {
                        selectedStudent.setName(newName);
                        System.out.println("***Name Updated***\n");
                    }
                }
                //Assign new address
                case "2" -> {
                    System.out.println("Enter new Address( press ENTER to keep the current address of the student )");
                    System.out.print("->");
                    newAddress = scanner.nextLine();
                    if (!newAddress.isEmpty()) {
                        selectedStudent.setAddress(newAddress);
                        System.out.println("***Address Updated***\n");
                    }
                }

                //Assign new age
                case "3" -> {
                    System.out.println("Enter new Age( press ENTER to keep the current age of the student )");
                    System.out.print("->");
                    newAge = scanner.nextLine();
                    if (!newAge.isEmpty()) {
                        selectedStudent.setAge(newAge);
                        System.out.println("***Age Updated***\n");
                    }
                }
                case "4" -> {
                    System.out.println("Exitting...");
                    return;
                }
                default -> {
                    System.out.println("Invalid");
                    scanner.nextLine();
                }
            }
        }

    }

    //Delete Main.Main.Student
    public void deleteStudent() {
        String user;
        while (true) {
            if (arr.isEmpty()) {
                System.out.println("\nNo Main Student! You must add students first.");
                scanner.nextLine();
                return;
            }


            //FLow control to remove student
            System.out.println("1. To remove user by index ");
            System.out.println("2. To remove all ");
            System.out.println("3. Exit");
            System.out.print("-> ");
            user = scanner.nextLine();


            //Remove student based from the user input
            switch (user) {
                case "1" -> {
                    viewStudent();
                    //Ask user which user to update
                    System.out.print("Enter the index of student you want to delete: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    //check if the index is valid
                    if (index <= 0 || index > arr.size()) {
                        System.out.println("Invalid student number");
                        return;
                    }

                    //Select the student based from the given index by the user ( -1 )
                    Student selectedStudent = arr.get(index - 1);
                    arr.remove(selectedStudent);

                    System.out.println("Main.Main.Student Removed!");
                }
                case "2" -> {
                    arr.removeAll(arr);
                    System.out.println("All Students Removed!");
                    scanner.nextLine();
                    return;
                }
                case "3" -> {
                    System.out.println("Exitting");
                    scanner.nextLine();
                    return;
                }
                default -> System.out.println("Invalid");
            }
        }
    }

    public int generateId() {
        //Generate random id for student
        int id = 100000 + random.nextInt(999999);
        return id;
    }

    private Student findStudentById(int id) {
        for (Student student : arr) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
}