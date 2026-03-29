package com.nish.Comparator_Comparable_Assignment.SortCandidates;
import java.util.*;

public class SortCandidates {

    public static void main(String[] args) {

        List<Candidate> list = new ArrayList<>();

        list.add(new Candidate("Radha", 22));
        list.add(new Candidate("Krishn", 25));
        list.add(new Candidate("Radha", 19));
        list.add(new Candidate("Krishn", 21));

        Collections.sort(list, new CandidateComparator());

        for(Candidate c : list)
            System.out.println(c);
    }
}
