package com.nish.Objects;

public class ObjectAndClass {

    // Class (Blueprint)
    static class House {
        String color;
        int rooms;

        void displayDetails() {
            System.out.println("Color: " + color);
            System.out.println("Rooms: " + rooms);
        }
    }

    public static void main(String[] args) {

        // Object 1
        House house1 = new House();
        house1.color = "White";
        house1.rooms = 3;

        // Object 2
        House house2 = new House();
        house2.color = "Blue";
        house2.rooms = 5;

        house1.displayDetails();
        System.out.println();
        house2.displayDetails();
    }
}

