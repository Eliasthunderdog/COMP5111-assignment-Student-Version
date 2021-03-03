package comp5111.assignment;

import java.util.HashMap;

public class BranchCounter {
	// count the coverage of all branches and mark the coverage
	private static HashMap<Integer, int[]> branches;
	private static int covered;
	private static int total;
	private static boolean lastIf = false;
	public static void addBranch(int key) {
		int[] new_branch = {0, 0};
		branches.put(key, new_branch);
		if (!branches.containsKey(key)) total += 1;
		lastIf = true;
	}
	
	public static void coverBranch(int key, int decision) {
		int[] branch = branches.get(key);
		if (branch[decision] == 0)
			covered += 1;
		branch[decision] = 1;
		branches.put(key, branch);
		lastIf = false;
	}
	
	public static void report() {
		float percent = ((float) covered ) / (2 * total);
		System.out.println("covered: " + covered + "\ttotal:\t" + 2 * total + "\tpercent\t" + percent);
	}
}
