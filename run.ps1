$TEST_PATH=".\target\classes"
$JUNIT_PATH=".\lib\junit-4.12.jar"
$SOOT_PATH=".\lib\soot-4.2.1-jar-with-dependencies.jar"
$HAMCREST_PATH=".\lib\hamcrest-core-1.3.jar"
$TOOL_PATH=".\target\classes\comp5111\assignment\cut"
$SOOT_OUTPUT_PATH=".\sootOutput\comp5111"

# generate soot

#java -cp "$TEST_PATH;$JUNIT_PATH;$SOOT_PATH;" comp5111.assignment.Assignment1 3 comp5111.assignment.cut.ToolBox`$StringTools `
# comp5111.assignment.cut.ToolBox`$LocaleTools `
# comp5111.assignment.cut.ToolBox`$ArrayTools `
# comp5111.assignment.cut.ToolBox`$CharSequenceTools `
# comp5111.assignment.cut.ToolBox`$CharTools `
# comp5111.assignment.cut.ToolBox`$RegExTools 
  
# java -cp "$TEST_PATH;$JUNIT_PATH;$SOOT_PATH" comp5111.assignment.Assignment1 4 comp5111.assignment.cut.ToolBox
# run test

java -cp "$TEST_PATH;$JUNIT_PATH;$HAMCREST_PATH" org.junit.runner.JUnitCore comp5111.assignment.cut.RegressionTest0
java -cp "$TEST_PATH;$JUNIT_PATH;$HAMCREST_PATH" org.junit.runner.JUnitCore comp5111.assignment.cut.RegressionTest1
java -cp "$TEST_PATH;$JUNIT_PATH;$HAMCREST_PATH" org.junit.runner.JUnitCore comp5111.assignment.cut.RegressionTest2
java -cp "$TEST_PATH;$JUNIT_PATH;$HAMCREST_PATH" org.junit.runner.JUnitCore comp5111.assignment.cut.RegressionTest3
java -cp "$TEST_PATH;$JUNIT_PATH;$HAMCREST_PATH" org.junit.runner.JUnitCore comp5111.assignment.cut.RegressionTest4
java -cp "$TEST_PATH;$JUNIT_PATH;$HAMCREST_PATH" org.junit.runner.JUnitCore comp5111.assignment.cut.RegressionTest5