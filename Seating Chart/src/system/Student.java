package system;
//class used to hold information on what a student needs.
//the class only contains get and set methods to access information of Student object.
public class Student {
	private String firstName;
	private String lastName;
	private String ID;
	private String dateOfBirth;
	private int row;
	private int col;
	
	public String getFirstName() {return this.firstName;}
	public String getLastName() {return this.lastName;}
	public String getID() {return this.ID;}
	public String getDateOfBirth() {return this.dateOfBirth;}
	public void setRow(int row) {this.row = row;}
	public void setCol(int col) {this.col = col;}
	public int getRow() {return this.row;}
	public int getCol() {return this.col;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setID(String ID) {this.ID = ID;}
	public void setdateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}
//constructor used to fill out necessary information that a Student must have.
	public Student(String firstName, String lastName, String ID, String dateOfBirth, int row, int col) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
		this.dateOfBirth = dateOfBirth;
		this.row = row;
		this.col = col;
	}
}
