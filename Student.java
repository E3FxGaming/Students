package school;

/**
 * A class to "objectize" a student.
 * @author E3FxGaming
 * @version 1.0
 */
public class Student {
	
	private String name; //The name of this student
	private int grade; //The grade of this student
	private String behaviour; //The behaviour of this student
	
	/**
	 * This is a constructor for this student.
	 * @param name The name that you want to set for this student. (Can't be changed later)
	 * @param grade The grade that you want to set for this student. (Cant't be changed later)
	 * @param behaviour The behaviour that you want to set for this student. (Can't be changed later) 
	 */
	public Student(String name, int grade, String behaviour) { 
		this.name = name; //Set the name of the student.
		this.grade = grade; //Set the grade of the student.
		this.behaviour = behaviour; //Set the behaviour of this student.
	}
	/**
	 * A getter for the name of this student.
	 * @return The name as String of this student.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * A getter for the grade of this student.
	 * @return The grade as int of this student.
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * A getter for the behaviour of this student.
	 * @return The behaviour as String of this student.
	 */
	public String getBehaviour() {
		return behaviour;
	}

	/**
	 * This is an overwritten toString method to better represent the data of this student-object.
	 */
	@Override
	public String toString() {
		return name + "s " + "grade is " + grade + " and his/her behaviour is " + behaviour; //The new toString method will return this String
	}
	
	
}
