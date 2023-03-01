CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf *.class
rm -rf testResult.txt
git clone $1 student-submission
echo 'Finished cloning'
if [[ -f "student-submission/ListExamples.java" ]]
then
    echo "File is found!"
else
    echo "Cannot find ListExamples.java! Exit code: 1"
    exit 1
fi
cp student-submission/ListExamples.java .
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
if [[ $? -ne 0 ]]
then
    echo "Compile error"
    exit 2
fi
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > testResult.txt
RESULT=`grep "failure" testResult.txt`
if [[ $RESULT == "" ]]
then
    echo "Tests all Pass" # If tests all pass
else
    echo `grep "Failures:" testResult.txt` # If any of the tests fail
fi