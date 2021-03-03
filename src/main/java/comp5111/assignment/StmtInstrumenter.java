package comp5111.assignment;

import java.util.*;
import java.lang.String;

import soot.*;
import soot.jimple.*;
import soot.util.*;

public class StmtInstrumenter extends BodyTransformer {

//	private static StmtInstrumenter stmt_instrumenter = new StmtInstrumenter();
//	private StmtInstrumenter() {}
//	public static StmtInstrumenter v() {return stmt_instrumenter;}
	static SootClass counterClass;
	static SootMethod coverCounter, reportCounter;
	static SootField totalStmt;
	static {
		counterClass = Scene.v().loadClassAndSupport("comp5111.assignment.StmtCounter");
		coverCounter = counterClass.getMethod("void cover(int)");
		reportCounter = counterClass.getMethod("void report()");
	}
	
	private static int stmt_num;
	
	@Override
	protected void internalTransform(Body b, String phaseName, Map<String, String> options) {
		
		
//		System.out.println("Current method: "+ b.getMethod().toString());
		if (b.getMethod().isConstructor() || b.getMethod().isStaticInitializer()) {
			return;
		}
		Chain<Unit> units = b.getUnits();
		Iterator stmtIt = units.snapshotIterator();
		while(stmtIt.hasNext()) {
			Stmt stmt = (Stmt) stmtIt.next();
			InvokeExpr markExpr = Jimple.v().newStaticInvokeExpr(
					coverCounter.makeRef(), IntConstant.v(stmt_num));
			Stmt cvrStmt = Jimple.v().newInvokeStmt(markExpr);
			units.insertBefore(cvrStmt, stmt);
			if ((stmt instanceof ReturnStmt)
						|| (stmt instanceof ReturnVoidStmt)) {
				InvokeExpr reportExpr = Jimple.v().newStaticInvokeExpr(reportCounter.makeRef());
				Stmt reportStmt = Jimple.v().newInvokeStmt(reportExpr);
				units.insertBefore(reportStmt, stmt);
			}
			stmt_num += 1;
		}
		
//		Chain<SootClass> classes = Scene.v().getClasses();
//		Iterator<SootClass> classIt = classes.iterator();
//		// first round, count stmt number
//		while (classIt.hasNext()) {
//			SootClass curClass = (SootClass) classIt.next();
//			if (curClass.toString().contains("ToolBox")) {
//				Iterator<SootMethod> methodIt = curClass.methodIterator();
//				while (methodIt.hasNext()) {
//					SootMethod curMethod = (SootMethod) methodIt.next();
//					Body curBody = curMethod.retrieveActiveBody();
//					Chain units = curBody.getUnits();
//					stmt_num += units.size();
//				}
//			}
//		}
//		System.out.println("all Stmt number: " + stmt_num);
//		// second round, insert new stmts
//		int stmt_index = 0;
//		classIt = classes.iterator();
//		while (classIt.hasNext()) {
//			SootClass curClass = (SootClass) classIt.next();
//			if (curClass.toString().contains("ToolBox")) {
//				Iterator<SootMethod> methodIt = curClass.methodIterator();
//				while (methodIt.hasNext()) {
//					SootMethod curMethod = (SootMethod) methodIt.next();
//					Body curBody = curMethod.retrieveActiveBody();
//					Chain units = curBody.getUnits();
//					Iterator stmtIt = units.snapshotIterator();
//					while (stmtIt.hasNext()) {
//						Stmt stmt = (Stmt) stmtIt.next();
//						InvokeExpr markExpr = Jimple.v().newStaticInvokeExpr(
//								coverCounter.makeRef(), IntConstant.v(stmt_index), IntConstant.v(stmt_num));
//						Stmt cvrStmt = Jimple.v().newInvokeStmt(markExpr);
//						units.insertBefore(cvrStmt, stmt);
//						stmt_index += 1;
//					}
////					System.out.println(curBody.toString());
//				}
//			}
//		}
	}

}
