package com.nish.Regex;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexUtility {

    // Checks if whole string strictly matches pattern
    public static boolean strictMatch(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    // Checks if pattern exists anywhere inside the string
    public static boolean patternExistsInString(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.find();
    }

    // Finds and prints ALL matches with position
    public static void findAllMatches(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        System.out.println("All found matches (value : start-end):");
        boolean foundAny = false;
        while (m.find()) {
            System.out.println(m.group() + " : " + m.start() + "-" + (m.end() - 1));
            foundAny = true;
        }
        if (!foundAny)
            System.out.println("  No matches found");
    }

    // Count how many times regex appears
    public static int countOccurrences(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        int count = 0;
        while (m.find()) count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String to test : ");
        String inputString = sc.nextLine();

        System.out.println("Enter Regex Pattern : ");
        String regexPattern = sc.nextLine();

        boolean strict = strictMatch(inputString, regexPattern);
        System.out.println("Strict whole match : " + strict);

        boolean exists = patternExistsInString(inputString, regexPattern);
        System.out.println("Exists in string: " + exists);

        System.out.println("All matched occurrences : ");
        findAllMatches(inputString, regexPattern);

        int count = countOccurrences(inputString, regexPattern);
        System.out.println("Total matches : " + count);

        sc.close();
    }
}
