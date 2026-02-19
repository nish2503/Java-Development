package com.nish.Learnings;

public class WrapperClass {

    public static void main(String[] args) {

        int primitiveValue = 100;
        System.out.println("Primitive int: " + primitiveValue);

        Integer manualBox = Integer.valueOf(primitiveValue);
        System.out.println("Manual Boxing: " + manualBox);

        Integer autoBox = primitiveValue;
        System.out.println("Autoboxing: " + autoBox);

        int manualUnbox = manualBox.intValue();
        System.out.println("Manual Unboxing: " + manualUnbox);

        int autoUnbox = autoBox;
        System.out.println("Auto-Unboxing: " + autoUnbox);

    }
}
