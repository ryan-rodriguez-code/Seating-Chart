package system;
//class used to handle the inputs and commands of the user while running program.
public class UserControl {
	private Chart map;
//constructor which is called by main method.
//responsible for asking the user what they want to do and creating 10 example students.
//asks user about the dimensions of the class room and handles 2 modes of information access for the user to view.
	public UserControl() {
		String input = JOP.in("How many rows of seats do you have (must be 4 or greater to see initial 10 students): ");
		while(!JOP.isInt(input)) {input = JOP.in("How many rows of seats do you have (must be 4 or greater to see initial 10 students): ");}
		String input2 = JOP.in("How many columns of seats do you have (must be 4 or greater to see initial 10 students): ");
		while(!JOP.isInt(input2)) {input2 = JOP.in("How many columns of seats do you have (must be 4 or greater to see initial 10 students): ");}
		
		this.map = new Chart(Integer.valueOf(input), Integer.valueOf(input2));
		if(Integer.valueOf(input) >= 4 && Integer.valueOf(input2) >= 4) {
			this.map.addStudent(new Student("Sam", "Adams", "0001", "1/20/2006", 0, 0));
			this.map.addStudent(new Student("Jack", "Edwards", "0002", "6/4/2006", 0, 1));
			this.map.addStudent(new Student("Ella", "Palmer", "0003", "3/17/2004", 0, 2));
			this.map.addStudent(new Student("Lucas", "Diaz", "0004", "2/5/2005", 0, 3));
			this.map.addStudent(new Student("Emily", "Fernandez", "0005", "2/26/2004", 1, 0));
			this.map.addStudent(new Student("Sofia", "Baker", "0006", "7/9/2005", 1, 1));
			this.map.addStudent(new Student("Alexander", "Carter", "0007", "9/10/2005", 1, 2));
			this.map.addStudent(new Student("Max", "Martinez", "0008", "11/18/2004", 1, 3));
			this.map.addStudent(new Student("Olivia", "Jordan", "0009", "8/26/2006", 2, 0));
			this.map.addStudent(new Student("Ethan", "Hansen", "0010", "1/1/2005", 2, 1));
		}
		
		while(true) {
			String input3 = JOP.in("What do you want to do change or view student information type 1; to view or change chart information type 2; you can exit at any time by pressing cancel:");
			String[] options = {"1", "2"};
			while(JOP.waitUntil(input3, options)) {input3 = JOP.in("What do you want to do change or view student information type 1; to view or change chart information type 2; you can exit at any time by pressing cancel:");}
			
			if(input3.equals("1")) {
				this.studentSystem();
			}
			else if(input3.equals("2")) {
				this.chartSystem();
			}
		}
	}
//allows the user to edit the students in the list of students in Chart object.
//can edit a student's information or add/remove students from list.
	private void studentSystem() {
		String input = JOP.in(this.map.stringChart() + "\nWhat do you want to do type 1 to add a student; type 2 to remove a student; type 3 to view/edit student information: ");
		String[] options = {"1", "2", "3"};
		while(JOP.waitUntil(input, options)) {input = JOP.in(this.map.stringChart() + "\nWhat do you want to do type 1 to add a student; type 2 to remove a student; type 3 to view/edit student information: ");}
		
		if(input.equals("1")) {
			String input2 = JOP.in("What is the student's name:");
			String input3 = JOP.in("What is the student's lastname:");
			String input4 = JOP.in("What is the student's ID:");
			String input7 = JOP.in("What is the student's birth day:");
			String input5 = JOP.in("What is the row of the student:");
			while(!JOP.isInt(input5)) {input5 = JOP.in("What is the row of the student:");}
			String input6 = JOP.in("What is the column of the student:");
			while(!JOP.isInt(input6)) {input6 = JOP.in("What is the column of the student:");}
			while(!this.map.isSeatAvaliable(Integer.valueOf(input5), Integer.valueOf(input6))) {
				input5 = JOP.in("What is the row of the student:");
				while(!JOP.isInt(input5)) {input5 = JOP.in("What is the row of the student:");}
				input6 = JOP.in("What is the column of the student:");
				while(!JOP.isInt(input6)) {input6 = JOP.in("What is the column of the student:");}
			}
			this.map.addStudent(new Student(input2, input3, input4, input7, Integer.valueOf(input5), Integer.valueOf(input6)));
		}
		else if(input.equals("2")) {
			String input2 = JOP.in("What is the ID of the student:");
			this.map.removeStudent(input2);
		}
		else if(input.equals("3")) {
			String input2 = JOP.in(this.map.stringChart() + "\nWhat student do you want to edit/view:");
			while(Integer.valueOf(input2) >= this.map.getStudents().size()) {input2 = JOP.in(this.map.stringChart() + "\nWhat student do you want to edit/view:");}
			String input3 = JOP.in("Student " + Integer.valueOf(input2) + ": Firstname: " + this.map.getStudents().get(Integer.valueOf(input2)).getFirstName() + " Lastname: " + this.map.getStudents().get(Integer.valueOf(input2)).getLastName() + " ID: " + this.map.getStudents().get(Integer.valueOf(input2)).getID() + " Birthday: " + this.map.getStudents().get(Integer.valueOf(input2)).getDateOfBirth() + " Row: " + this.map.getStudents().get(Integer.valueOf(input2)).getRow() + " Column: " + this.map.getStudents().get(Integer.valueOf(input2)).getCol() + "\nDo you want to change the firstname type 1; to change the lastname type 2; to change the ID type 3; to change the birthday type 4; \nto change the row type 5; to change the column type 6; to not change anything type 7:");
			String[] options2 = {"1", "2", "3", "4", "5", "6", "7"};
			while(JOP.waitUntil(input3, options2)) {input3 = JOP.in("Student " + Integer.valueOf(input2) + ": Firstname: " + this.map.getStudents().get(Integer.valueOf(input2)).getFirstName() + " Lastname: " + this.map.getStudents().get(Integer.valueOf(input2)).getLastName() + " ID: " + this.map.getStudents().get(Integer.valueOf(input2)).getID() + " Birthday: " + this.map.getStudents().get(Integer.valueOf(input2)).getDateOfBirth() + " Row: " + this.map.getStudents().get(Integer.valueOf(input2)).getRow() + " Column: " + this.map.getStudents().get(Integer.valueOf(input2)).getCol() + "\nDo you want to change the firstname type 1; to change the lastname type 2; to change the ID type 3; to change the birthday type 4; \nto change the row type 5; to change the column type 6; to not change anything type 7:");}
			if(input3.equals("1")) {
				this.map.getStudents().get(Integer.valueOf(input2)).setFirstName(JOP.in("What do you want the firstname of the student to be:"));
			}
			else if(input3.equals("2")) {
				this.map.getStudents().get(Integer.valueOf(input2)).setLastName(JOP.in("What do you want the lastname of the student to be:"));
			}
			else if(input3.equals("3")) {
				this.map.getStudents().get(Integer.valueOf(input2)).setID(JOP.in("What do you want the ID of the student to be:"));
			}
			else if(input3.equals("4")) {
				this.map.getStudents().get(Integer.valueOf(input2)).setdateOfBirth(JOP.in("What do you want the birthday of the student to be:"));
			}
			else if(input3.equals("5")) {
				String input4 = JOP.in("What do you want the row of the student to be:");
				while(!JOP.isInt(input4) || Integer.valueOf(input4) >= this.map.getChart().length) {input4 = JOP.in("What do you want the row of the student to be:");}
				this.map.getStudents().get(Integer.valueOf(input2)).setRow(Integer.valueOf(input4));
			}
			else if(input3.equals("6")) {
				String input4 = JOP.in("What do you want the column of the student to be:");
				while(!JOP.isInt(input4) || Integer.valueOf(input4) >= this.map.getChart()[0].length) {input4 = JOP.in("What do you want the column of the student to be:");}
				this.map.getStudents().get(Integer.valueOf(input2)).setCol(Integer.valueOf(input4));
			}
		}
	}
//allows the user to view the chart of students and allows the user to change the order in which students are shown.
	private void chartSystem() {
		String input = JOP.in("What do you want to do sort the chart by lastname in row major order type 1; to sort the chart by lastname in column major order type 2; \nto sort the chart by ID in row major order type 3; to sort the chart by ID in column major order type 4; to look at the chart type 5:");
		String[] options = {"1", "2", "3", "4", "5"};
		while(JOP.waitUntil(input, options)) {input = JOP.in("What do you want to do sort the chart by lastname in row major order type 1; to sort the chart by lastname in column major order type 2; \nto sort the chart by ID in row major order type 3; to sort the chart by ID in column major order type 4; to look at the chart type 5:");}
		if(input.equals("1")) {
			this.map.sortByRowLastName();
			JOP.msg(this.map.stringChart());
		}
		else if(input.equals("2")) {
			this.map.sortByColLastName();
			JOP.msg(this.map.stringChart());
		}
		else if(input.equals("3")) {
			this.map.sortByRowID();
			JOP.msg(this.map.stringChart());
		}
		else if(input.equals("4")) {
			this.map.sortByColID();
			JOP.msg(this.map.stringChart());
		}
		else if(input.equals("5")) {
			JOP.msg(this.map.stringChart());
		}
	}
}
