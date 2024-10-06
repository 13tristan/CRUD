package com.my.pkg;

import java.util.Random;

public class Student {


    private String name, address,age,course;
    private int year, id;

    Random random = new Random();
    int randomNumber = 100000 + random.nextInt(999999);

    public Student(String name, String address, String age,String course,int year, int id) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.year = year;
        this.id = id;
        this.course = course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGrade(int year) {
        this.year = year;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    public int getId(){
        return id;
    }


    @Override
    public String toString() {
        return "Name: " + name.toUpperCase() + "\n   Age: " + age + "\n   Address: " + address.toUpperCase() +
                "\n   Course: " + course.toUpperCase() + "\n   ID: " + id;
    }
}