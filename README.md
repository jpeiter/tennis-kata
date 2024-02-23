# Tennis Kata

This Java project implements a simple scoring system for a tennis set between two players. Players can score points by entering 'A' for player A or 'B' for player B through the terminal. Additionally, the program can read sequences of 'A's and 'B's from a file and simulate the scoring accordingly.

## How to Run the Project

1. Ensure you have Java and Maven installed on your system. You can download and install Java from the [official website](https://www.java.com/en/download/) and Maven from [here](https://maven.apache.org/download.cgi).

2. Clone this repository to your local machine or download and extract the ZIP file.

3. Open a terminal or command prompt and navigate to the project directory.

4. Compile and package the project using Maven with the following command:

`mvn clean package`

6. Run the project using the following command:

` java -jar target/tennis-kata-jeanpeiter-1.0-SNAPSHOT.jar`

7. Follow the on-screen instructions to input scores for player A or player B. Enter 'A' for player A or 'B' for player B.

8. Optionally, you can provide a path to a file containing sequences of 'A's and 'B's. The program will read the file and simulate the scoring accordingly. For example:

`java -jar target/tennis-kata-jeanpeiter-1.0-SNAPSHOT.jar /path/to/input.txt`


## Running JUnit Test Files

This project includes JUnit test files to ensure the correctness of the implemented methods. To run the JUnit tests, follow these steps:

1. Ensure you have Maven installed on your system.

2. Open a terminal or command prompt and navigate to the project directory.

3. Run the following Maven command to execute the tests:

`mvn test`

5. View the test results in the terminal to ensure all tests pass successfully.
