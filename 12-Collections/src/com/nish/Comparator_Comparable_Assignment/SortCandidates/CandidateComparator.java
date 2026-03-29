package com.nish.Comparator_Comparable_Assignment.SortCandidates;
import java.util.*;

public class CandidateComparator implements Comparator<Candidate> {
	public int compare(Candidate c1, Candidate c2) {
		int nameCompare = c1.name.compareTo(c2.name);
		
		if(nameCompare != 0) {
			return nameCompare;
		}
		
//		return c1.age - c2.age;
		return Integer.compare(c1.age, c2.age);
	}
}
