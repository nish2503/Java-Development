package com.nish.ExceptionHandling.Assignment;

public class NestedTryCatch {

    public static void main(String[] args) {

        try {   // OUTER TRY

            try {   // INNER TRY

                int[] arr = {10, 20, 30};

                System.out.println("Accessing invalid index : ");
                System.out.println(arr[5]);   // Triggers ArrayIndexOutOfBoundsException

            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner Catch: Array index is invalid.");
            }

            System.out.println("Now performing division : ");
            int result = 10 / 0;   // Triggers ArithmeticException

        }
        catch (ArithmeticException e) {
            System.out.println("Outer Catch: Cannot divide by zero.");
        }

        System.out.println("Program continues normally.");
    }
}