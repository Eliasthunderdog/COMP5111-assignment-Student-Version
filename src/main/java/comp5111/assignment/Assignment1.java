package comp5111.assignment;

import java.util.Arrays;
import soot.*;
import soot.options.Options;
import java.io.File;

public class Assignment1 {
    public static void main(String[] args) {

        /* check the arguments */
        if (args.length <= 1 || (args[0].compareTo("0") != 0 && args[0].compareTo("1") != 0 && 
        		args[0].compareTo("2") != 0)) {
            System.err.println("Usage: java Assignment1 [coverage level] classnames ...");
            System.err.println("Usage: [coverage level] = 0 for statement coverage");
            System.err.println("Usage: [coverage level] = 1 for branch coverage");
            System.err.println("Usage: [coverage level] = 2 for line coverage");
            System.exit(0);
        }

        // these args will be passed into soot.
        String[] classNames = Arrays.copyOfRange(args, 1, args.length);
        Options.v().set_output_dir("./target/classes");
        Options.v().set_soot_classpath(Scene.v().defaultClassPath()
    			+File.pathSeparator+"target/classes/comp5111/assignment"
    			+File.pathSeparator+"target/classes/"
    			+File.pathSeparator+"target/classes/comp5111/assignment/cut"
    			+File.pathSeparator+"lib/junit-4.12.jar"
        		+File.pathSeparator+"lib/hamcrest-core-1.3.jar");

        if (args[0].compareTo("0") == 0) {
    		Pack jtp = PackManager.v().getPack("jtp");
    		jtp.add(new Transform("jtp.instrumenter",
    				new StmtInstrumenter()));
    		soot.Main.main(classNames);

        } else if (args[0].compareTo("1") == 0) {
            // TODO invoke your branch coverage instrument function

            // TODO run tests on instrumented classes to generate coverage report

        } else if (args[0].compareTo("2") == 0) {
            // TODO invoke your line coverage instrument function

            // TODO run tests on instrumented classes to generate coverage report

        }
    }
}
