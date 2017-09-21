package lab2;

import java.util.*;
import java.io.*;

public class SeatMap {

	private String[][] nameList;
	private ArrayList<String> studentList=new ArrayList<String>();
	private int size=0;
	
	public SeatMap() {
		
	}
	public void readIn() {
		File list=new File("names.dat");
		Scanner fileInput=null;
		try {
			fileInput = new Scanner(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int count=0;
		while(fileInput.hasNextLine()) {
			studentList.add(fileInput.nextLine());
			count++;
		}
		arrayMaker(count);
		fileInput.close();
	}
	
	public void arrayMaker(int amount) {
		if(amount>0&&Math.sqrt(amount)%10==0)
			size=(int)Math.sqrt(amount);
		else
			size=(int)Math.sqrt(amount)+1;
		nameList=new String [size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				nameList[j][i]=studentList.remove(0);
			}
		}
	}
	
	public String seat(int row, int column) {
		if(row<=size&&column<=size&&nameList[row][column]!=null)
			return nameList[row][column];
		else if(row<=size&&column<=size&&nameList[row][column]==null)
			return "empty seat";
		else
			return "invalid seat";
	}

	public static void main(String[] args) {
		SeatMap students=new SeatMap();
		students.readIn();
		System.out.println(students.seat(4,2));
	}

}
