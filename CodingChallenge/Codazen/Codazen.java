/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codazen;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author parth
 */

/*
Assumtion:
        1. Array does not contain duplicate student object.
        2. No two student have same first name, last name and age.
        3. First and Last name will only contain alphabetical and ages will be nonnegative

Test Cases:
        Input 1                     Input 2                             output
        [Student A, Student B]      [Student A, Student C]              1
        [Student A, Student B]      [Student A, Student B, Student C]   2
        [Student A, Student B]      [Student C]                         0
        [Student A, Student B]      [Student A, Student B]              2
        []                          []                                  0
        []                          [Student A, Student B]              0
        [Student A, Student B]      [Student C, Student D]              0

Time Complexity: Max(O(N), O(M)) size of array
Auxiliary Space Complexity: O(N)

I spent 5 minute to understand problem,
        15 to 20 minute to write code,
        10 minute to write Assumtion, Test Cases.


*/
public class Codazen {
    public static void main(String[] args){
        Student A = new Student("George", "Washington", 23);
        Student B = new Student("John", "Adams", 25);
        Student C = new Student("Thomas", "Jefferson", 27);
        Student D = new Student("Parth", "Patel", 25);

        Student[] course1 = {A, C};
        Student[] course2 = {A, B};
        System.out.println("Number of student in both class: " + numberOfStudentInBothClass(course1, course2));

        Student[] course3 = {A, B};
        Student[] course4 = {A, B, C};
        System.out.println("Number of student in both class: " + numberOfStudentInBothClass(course3, course4));

        Student[] course5 = {A, B};
        Student[] course6 = {C};
        System.out.println("Number of student in both class: " + numberOfStudentInBothClass(course5, course6));

        Student[] course7 = {A, B};
        Student[] course8 = {A, B};
        System.out.println("Number of student in both class: " + numberOfStudentInBothClass(course7, course8));

        Student[] course9 = {};
        Student[] course10 = {};
        System.out.println("Number of student in both class: " + numberOfStudentInBothClass(course9, course10));

        Student[] course11 = {};
        Student[] course12 = {A, B};
        System.out.println("Number of student in both class: " + numberOfStudentInBothClass(course11, course12));

        Student[] course13 = {A,B};
        Student[] course14 = {C,D};
        System.out.println("Number of student in both class: " + numberOfStudentInBothClass(course13, course14));
    }

    // Time Complexity: Max(O(N), O(M)) size of array
    // Auxiliary Space Complexity: O(n)
    private static int numberOfStudentInBothClass(Student[] course1, Student[] course2) {
        int count = 0;
        Set<Student> set = new HashSet<Student>();
        for(Student student : course1){
            set.add(student);
        }
        for(Student student : course2){
            if(set.add(student)){}
            else
                count++;
        }
        return count;
    }
}

class Student{
    public String firstName;
    public String lastName;
    public int age;

    public Student(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
