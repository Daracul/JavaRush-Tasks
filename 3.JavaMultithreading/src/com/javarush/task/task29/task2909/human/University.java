package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University  {
    private String name;
    private int age;
    private List<Student> students=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name=name;
        this.age=age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student stud=null;
        for (Student student:students){
            if (student.getAverageGrade()==averageGrade){
                stud=student;
            }
        }
        //TODO:
        return stud;
    }

    public Student getStudentWithMaxAverageGrade() {
        if (!students.isEmpty()){
            Student student=students.get(0);
            for (Student currentStudent:students){
                if (currentStudent.getAverageGrade()>student.getAverageGrade()){
                    student=currentStudent;
                }
            }
            return student;
        }
//        Student stud=null;
//        double max=0;
//        for (Student student:students){
//            if (student.getAverageGrade()>max){
//                max=student.getAverageGrade();
//            }
//        }
//        for (Student student:students){
//            if (student.getAverageGrade()==max){
//                stud=student;
//            }
//        }

        //TODO:
        return null;
    }

    public Student getStudentWithMinAverageGrade(){
        if (!students.isEmpty()){
            Student student=students.get(0);
            for (Student currentStudent:students){
                if (currentStudent.getAverageGrade()<student.getAverageGrade()){
                    student=currentStudent;
                }
            }
            return student;
        }
        return null;
//        Student stud=null;
//        double min=Double.MAX_VALUE;
//        for (Student student:students){
//            if (student.getAverageGrade()<min){
//                min=student.getAverageGrade();
//            }
//        }
//        for (Student student:students){
//            if (student.getAverageGrade()==min){
//                stud=student;
//            }
//        }
//        return stud;
    }

    public void expel(Student student){
        students.remove(student);
    }

}