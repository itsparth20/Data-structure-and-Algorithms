package practiceProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Sort data by last name then first name
public class SortPerson {
	public static void main(String[] args) {

//		char x = 0x20;
//		int y = 1;

//		System.out.println(1<<2);

		Person p = new Person();
		Person p1 = new Person();
		Person p2 = new Person();

		p.m_firstName = "Parth";
		p.m_lastName = "Patel";

		p1.m_firstName = "Bi";
		p1.m_lastName = "Patel";

		p2.m_firstName = "Angel";
		p2.m_lastName = "Zee";

		List<Person> l = new ArrayList<Person>();
		l.add(p);
		l.add(p1);
		l.add(p2);

		Collections.sort(l);
		for(Person per : l){
			System.out.println(per.m_lastName + " " + per.m_firstName);
		}
	}
}

class Person implements Comparable<Person> {

	String m_firstName;

	String m_lastName;

	public int compareTo(Person p) {
	    int rLast = m_lastName.compareTo(p.m_lastName); 
	    return rLast == 0 ? m_firstName.compareTo(p.m_firstName) : rLast; 
	}
}
