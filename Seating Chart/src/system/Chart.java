package system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//class used to hold information on where the students are located at.
public class Chart {
	private String[][] chart;
	private List<Student> students;
	private int longestNameWithNum;
	
	public String[][] getChart() {return this.chart;}
	public List<Student> getStudents(){return this.students;}
//constructor used to create Chart object with number of rows and columns of the class room.
	public Chart(int rows, int cols) {
		this.chart = new String[rows][cols];
		this.students = new ArrayList<Student>();
	}
//adds the Student student into the list of students held in the Chart object.
	public void addStudent(Student student) {
		this.students.add(student);
		this.longestNameWithNum = this.findLongestNameWithNum();
	}
//removes a student the the ID passed into the parameter from the Student list held in the Chart object.
	public void removeStudent(String ID) {
		for(int i = 0; i < this.students.size(); i++) {
			if(this.students.get(i).getID().equals(ID)) {
				this.students.remove(i);
				this.longestNameWithNum = this.findLongestNameWithNum();
				break;
			}
		}
	}
//sorts the Chart by last name and reassigns the seats the students are in by row major order.
	public void sortByRowLastName() {
		this.sortStudentsByLastName();
		int i = 0;
		for(int r = 0; r < this.chart.length; r++) {
			for(int c = 0; c < this.chart[r].length; c++) {
				if(i < this.students.size()) {
					this.students.get(i).setRow(r);
					this.students.get(i).setCol(c);
				}
				else {
					return;
				}
				i++;
			}
		}
	}
	//sorts the Chart by last name and reassigns the seats the students are in by column major order.
	public void sortByColLastName() {
		this.sortStudentsByLastName();
		int i = 0;
		for(int c = 0; c < this.chart[0].length; c++) {
			for(int r = 0; r < this.chart.length; r++) {
				if(i < this.students.size()) {
					this.students.get(i).setRow(r);
					this.students.get(i).setCol(c);
				}
				else {
					return;
				}
				i++;
			}
		}
	}
//sorts the chart in row major order by student row ID.
	public void sortByRowID() {
		this.sortStudentsByID();
		int i = 0;
		for(int r = 0; r < this.chart.length; r++) {
			for(int c = 0; c < this.chart[r].length; c++) {
				if(i < this.students.size()) {
					this.students.get(i).setRow(r);
					this.students.get(i).setCol(c);
				}
				else {
					return;
				}
				i++;
			}
		}
	}
	//sorts the chart in row major order by student column ID.
	public void sortByColID() {
		this.sortStudentsByID();
		int i = 0;
		for(int c = 0; c < this.chart[0].length; c++) {
			for(int r = 0; r < this.chart.length; r++) {
				if(i < this.students.size()) {
					this.students.get(i).setRow(r);
					this.students.get(i).setCol(c);
				}
				else {
					return;
				}
				i++;
			}
		}
	}
//converts the Chart object into a String so it can be displayed to the user.
//shows where each student sits and displays their name.
//if no one sits in a location NONE is displayed.
	public String stringChart() {
		String s = "";
		for(int r = 0; r < this.chart.length; r++) {
			for(int c = 0; c < this.chart[r].length; c++) {
				boolean foundStudent = false;
				for(int i = 0; i < this.students.size(); i++) {
					if(this.students.get(i).getRow() == r && this.students.get(i).getCol() == c) {
						foundStudent = true;
						s += this.students.get(i).getFirstName() + "," + i;
						s += this.spaceNames(this.students.get(i).getFirstName() + "," + i);
						break;
					}
				}
				if(!foundStudent) {
					s += "NONE";
					s += this.spaceNames("NONE");
				}
			}
			s += "\n";
		}
		return s;

	}
//checks to see if a seat is empty.
	public boolean isSeatAvaliable(int row, int col) {
		for(int i = 0; i < this.students.size(); i++) {
			if(this.students.get(i).getRow() == row && this.students.get(i).getCol() == col) {
				return false;
			}
		}
		return true;
	}
//returns the amount of spaces in a String needed to make the Chart object String look better.
	private String spaceNames(String name) {
		int difference = this.longestNameWithNum - name.length();
		String space = "";
		for(int i = 0; i < difference; i++) {
			space += ' ';
		}
		space += ' ';
		return space;
	}
//returns the value of the longest name in the list of students.
	private int findLongestNameWithNum() {
		int longest = 0;
		for(int i = 0; i < this.students.size(); i++) {
			if(this.students.get(i).getFirstName().length() > longest) {
				longest = this.students.get(i).getFirstName().length();
			}
		}
		longest += 4;
		return longest;
	}
//sorts the list of students in the Chart object by last name in alphabetical order.
	private void sortStudentsByLastName() {
		String[] lastNames = new String[this.students.size()];
		for(int i = 0; i < this.students.size(); i++) {
			lastNames[i] = this.students.get(i).getLastName() + "," + i;
		}
		Arrays.sort(lastNames);
		List<Student> newStudents = new ArrayList<Student>();
		for(int i = 0; i < lastNames.length; i++) {
			newStudents.add(this.students.get(Integer.valueOf(lastNames[i].substring(lastNames[i].indexOf(",") + 1))));
		}
		this.students = newStudents;
	}
//sorts the list of students in the chart object by ID in alphabetical order.
	private void sortStudentsByID() {
		String[] IDs = new String[this.students.size()];
		for(int i = 0; i < this.students.size(); i++) {
			IDs[i] = this.students.get(i).getID() + "," + i;
		}
		Arrays.sort(IDs);
		List<Student> newStudents = new ArrayList<Student>();
		for(int i = 0; i < IDs.length; i++) {
			newStudents.add(this.students.get(Integer.valueOf(IDs[i].substring(IDs[i].indexOf(",") + 1))));
		}
		this.students = newStudents;
	}
}
