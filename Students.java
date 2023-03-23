/// Student Class

package First_Task;

public class Student {

	int id;
	String name;
	int age;
	String city;

	Student(int id, String name, int age, String city) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String toString() {
		return id + " " + name + " " + age + " " + city;
	}

}



// Student Report Class



public class StudentReportCard {

	int id;
	String name;
	int tamil;
	int english;
	int maths;
	int science;
	int Sscience;
	int total;

	StudentReportCard(int id, String name, int s1, int s2, int s3, int s4, int s5) {

		this.id = id;
		this.name = name;
		this.tamil = s1;
		this.english = s2;
		this.maths = s3;
		this.science = s4;
		this.Sscience = s5;
		this.total = tamil + english + maths + science + Sscience;

	}

	public String toString() {
		char grade = 'e';
		if (total > 490) {
			grade = 'a';
		} else if (total > 450) {
			grade = 'b';
		} else if (total > 300) {
			grade = 'c';
		}
		return "name :  " + name + "  tamil: " + tamil + "  english: " + english + "  maths: " + maths + "  science: "
				+ science + "  Sscience: " + Sscience + "  grade : " + grade;
	}

}


// Now we can see Student Files

package First_Task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class StudentFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate date = LocalDate.now();
		LocalDate plus = date.plusDays(1);
		LocalTime ltnow = LocalTime.now();
		DateTimeFormatter Dateformatt = DateTimeFormatter.ofPattern("dd/yy/MM");
		String actualDate = Dateformatt.format(plus);

		String s = "varathan";

		// StudentFiles sf = new StudentFiles("varathan");

		List<Student> sl = Arrays.asList(new Student(1, "Aarthi", 17, "chennai"),
				new Student(2, "Bharathi", 18, "trichy"), new Student(3, "karthik", 17, "madhrai"),
				new Student(4, "Ravi", 19, "covai"), new Student(5, "kathir", 17, "pondy"));

		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("Print Student Details Enter 0");
			System.out.println("Print StudentReport Card Enter 1");

			try {
				int userInput = scan.nextInt();

				switch (userInput) {

				case 0: {

					Stream<Student> stream = sl.stream();
					stream.forEach(System.out::println);
					break;
				}
				case 1: {
					System.out.println("Enter Student ID");
					int userID = scan.nextInt();
					List<StudentReportCard> srl = Arrays.asList(new StudentReportCard(1, "Aarthi", 67, 76, 86, 55, 35),
							new StudentReportCard(2, "Bharathi", 74, 73, 89, 75, 35),
							new StudentReportCard(3, "Karthik", 47, 36, 56, 55, 55),
							new StudentReportCard(4, "Ravi", 74, 75, 86, 55, 45),
							new StudentReportCard(5, "Kathir", 68, 76, 89, 54, 35));

					Stream<StudentReportCard> stream2 = srl.stream();
					stream2.filter(e -> e.id == userID).forEach(f -> System.out.println(f + " " + actualDate));
					break;
				}

				}

			} catch (InputMismatchException e) {
				System.out.println("Please Enter Valid Number");
			}
		}

	}

}

