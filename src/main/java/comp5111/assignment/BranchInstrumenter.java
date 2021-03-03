package comp5111.assignment;

import java.util.Iterator;
import java.util.Map;

import soot.*;
import soot.util.*;
import soot.jimple.*;

public class BranchInstrumenter extends BodyTransformer {

	static SootClass counterClass;
	static SootMethod coverBranch, report, addBranch;
	static SootField totalStmt;
	static {
		counterClass = Scene.v().loadClassAndSupport("comp5111.assignment.BranchCounter");
		addBranch = counterClass.getMethod("void addBranch(int)");
		coverBranch = counterClass.getMethod("void cover(int, int)");
		report = counterClass.getMethod("void report()");
	}
	
	private static int branch_num;
	
	@Override
	protected void internalTransform(Body b, String phaseName, Map<String, String> options) {
		
		if (b.getMethod().isConstructor() || b.getMethod().isStaticInitializer()) {
			return;
		}
		
		Chain<Unit> units = b.getUnits();
		Iterator stmtIt = units.snapshotIterator();
		while(stmtIt.hasNext()) {
			Stmt stmt = (Stmt) stmtIt.next();
			if (stmt instanceof IfStmt) {
				IfStmt curIfStmt = (IfStmt) stmt;
				Stmt targetStmt = curIfStmt.getTarget();
			}
		}
	}

}
