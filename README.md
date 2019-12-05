# WordCounter

WordCounter, a program to count words in a file or across files is written in Java
with a command line interface.
Please use the following instructions to run the java executable(jar):
1. Download & Install java(versions greater than 7) on your machine using the
following link:
https://www.java.com/en/download/help/download_options.xml.
Follow the instructions given in the page as per your Operating system.
2. Extract the zip file and run the following command to execute the program
in terminal. Change the directory in the terminal to extracted folder
directory:
java -jar WordCounter.jar
3. Inputs: To explore the test data, browse to the project directory and open
“input_dir”.
[a] files.txt contains list of files to be processed.
[b] All the files contain around 1000-7000 lines. There are 14 such files.
4. Outputs: The output of the program is also stored to a file since the
vocabulary of the files is more than 20k words.
To explore the output file go to the extracted zip folder and open
output_currenttimestamp.txt.
It has the output of the run at a particular time, currenttimestamp. Since the
output is long, it would be cropped in the terminal. Please use this file to
explore the words and their counts.
5. Test files written with Junit are provided in the following directory: src/test
To run the test files use the following commands:
[a] Change directory to src:
cd src
[b] Compile Test
javac -cp ../junit-4.12.jar:. test/GlobalCounterServiceTest.java
test/CounterServiceTest.java
[c] Run Test
java -cp ../junit-4.12.jar:../hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore
test.GlobalCounterServiceTest test.CounterServiceTest
