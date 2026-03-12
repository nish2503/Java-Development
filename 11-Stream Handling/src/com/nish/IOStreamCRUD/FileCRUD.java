package com.nish.IOStreamCRUD;
import java.io.*;

public class FileCRUD {
	static String file = "students.txt";
	public static void create(String data) throws IOException {
		FileWriter writer = new FileWriter(file, true);
		writer.write(data + "\n");
		writer.close();
		System.err.println("Record added");
	}
	
	public static void read() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine())!= null) {
			System.out.println(line);
		}
		reader.close();
	}
	
	public static void update(String id, String newData) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		FileWriter writer = new FileWriter("temp.txt");
		String line;
		while((line = reader.readLine())!=null) {
			if(line.startsWith(id + " ")) {
				writer.write(newData + "\n");
			}
			else {
				writer.write(line + "\n");
			}
		}
		reader.close();
		writer.close();
		
		new File(file).delete();
		new File("temp.txt").renameTo(new File(file));
		
		System.out.println("Record updated");
	}
	
	public static void delete(String id) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		FileWriter writer = new FileWriter("temp.txt");
		
		String line;
		
		while((line = reader.readLine())!= null) {
			if(!line.startsWith(id + " ")) {
				writer.write(line + "\n");
			}
		}
		
		reader.close();
		writer.close();
		
		new File(file).delete();
		new File("temp.txt").renameTo(new File(file));
		
		System.out.println("Record deleted");
	}
}
