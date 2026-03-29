package com.nish.ForLoop;

public class EnhancedForLoop {
	public static void main(String[] args) {
		Student[] arr = {new Student(100), new Student(200), new Student(300)};
		
		for(Student s:arr) {
			if(s.marks == 100) {
				s.marks = 1000;
			}
			System.out.println(s.marks);
		}
		
		for(Student s:arr) {
			if(s.marks == 100) {
				s = new Student(500); // IT DOESNT UPDATE ARRAY
			}
			System.out.println(s.marks);
		}
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i].marks == 200) {
				arr[i] = new Student(500);
			}
			System.out.println(arr[i].marks);
		}
	}
}

class Student{
	public int marks;
	Student(int marks){
		this.marks = marks;
	}
	
}
