package school;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A program that allows a user to gain knowlege about students.
 * 
 * @author E3FxGaming
 * @version 1.0
 */
public class Start {
		
	private static ArrayList<Student> students = new ArrayList<Student>(); //This ArrayList will contain all Student-Objects
	
	/**
	 * A small method that will create a few students. For testing purposes only!
	 */
	private static void writeTestData(){
		students.add(new Student("John", 79, "aggressive"));
    	students.add(new Student("Ben", 86, "distractable"));
    	students.add(new Student("Lisa", 90, "attentive"));
    	students.add(new Student("Stewart", 89, "disruptive"));
    	students.add(new Student("Cora", 99, "angelic"));
	}
	
	/**
	 * The main method of the Student information program.
	 * @param args Possible console arguments (not used in this program)
	 */
    public static void main(String args[]) {
    	
    	writeTestData(); //create a few students that we can use later
    	
        Scanner kb = new Scanner(System.in); //Create a Scanner object that allows the user to interact with the program.
        boolean userChoice = true; //a boolean value that keeps the program as long as necessary running.
        String userInput = ""; //A String variable that will store any user keyboard input
       

        while(userChoice) { //while the program should run
        	
        	String studentNames = getStudentNames(); //get the name of all students
        	
        	if(studentNames == null){ //If you couldn't find any students
        		System.out.println("Error, no Students were found. Program will end now"); //Inform the user that the program will end now
        		System.exit(1); //Exit with an error code (1)
        	}
        	
        	System.out.println("Name(s) of Students: " + studentNames); //Print out the name/names of the only/all student(s)
            System.out.println("Please enter a student's name (case-sensitive) to get their progress report: "); //Ask the user for a Student name

            userInput = kb.nextLine(); //recieve user input

           try {
                System.out.println(getStudentbyName(userInput).toString()); //try to get the student object with the name stored in userinput and then ouput information about him/her.
           } catch (IllegalArgumentException e) { //if you failed to find the Student
                System.out.println("Not a valid student's name"); //Tell the user that you couldn't find the user with the name he/she typed in.
            }

            
           String choice = ""; //Create a choice object that will store the continue-choice of the user. IMPORTANT: This has to be within the while(userChoice) while-loop.
           
            while (!(choice.equals("n") || choice.equals("y"))){ //while you didn't get an acceptable answer
            	
            	System.out.println("Would you like to enter another student's name? (y/n)"); //Ask the user if he wants to look up another student.
            	
            	choice = kb.nextLine(); //recieve user input

                if (choice.equalsIgnoreCase("n")) { //If the user doesn't want to look up another user
                    userChoice = false; //break free from the outer loop by setting userChoice to false
                }
                
                if(!(choice.equals("n") || choice.equals("y"))){ //If you didn't recieve an acceptable answer
                	System.out.println("Please answer with \"y\" or \"n\""); //Kindly ask the user to only use acceptable choices.
                }
            }
        }
        
        System.out.println("The program has reached the end."); //Inform the user that the program is going to end
        
        kb.close(); //Close the Scanner, simply because you should do that
        
        System.out.println("Thank you for using this program. Have a nice day."); //Program end reached
    }
    
    /**
     * A method to get the names of all Students
     * @return A String that contains the names of all students or null if no students were found
     */
    private static String getStudentNames(){
    	String studentsList = ""; //The future String that will contain the name of all students
    	
    	for (Student student : students) { //A simple for-each loop (way better than your (initialize variable, condition, do-this)-loop
			studentsList += student.getName(); //add the name of the student to the list
			
			if(students.indexOf(student)<students.size()-1){ //if its not the last student in the list
				studentsList += ", "; //ad a comma and a space for the name of the next student
			}
		}
    	
    	if(studentsList.equals("")){ //if no students were found
    		return null; //return null
    	}
    	 
    	 return studentsList; //return the studentList-String if you found one or more students
    }
    
    /**
     * A method to find a Student by searching for his name
     * @param studentName The name of the student that you're looking for
     * @return The Student object (the first student that could be found with the studentName-name
     * @throws IllegalArgumentException //Exception will be thrown when you couldn't find a user
     */
    private static Student getStudentbyName(String studentName) throws IllegalArgumentException{
    	for (Student student : students) { //An easy for-each loop to iterate through students
			if(student.getName().equals(studentName)){ //if the name of the current student matches the studentName-String as name
				return student; //return the Student that you found
			}
		}
    	
    	throw new IllegalArgumentException(); //Throw an IllegalArgumentException if you couldn't find a student with the studentName-String as name
    }  
}