package comp5111.assignment;

import java.io.*;
import java.util.Vector;

public class StmtCounter {
	
	private static Vector<Integer> covered = new Vector<Integer>();
	private static int total;
	public static void cover(int i) { 
		if (!covered.contains(i))
			covered.add(i);
		if (i > total)
			total = i;
//		float percent = ((float) covered.size());
//		System.out.println("current covered: \t" + covered.size() + "\ttotal:\t" + total + "\tpercent:\t" + percent);
	}
	public static void report() { 
		float percent = ((float) covered.size()) / total;
		System.out.println("covered:\t" + covered.size() + "\ttotal:\t" + total + "\tpercent:\t" + percent);
	}
}
