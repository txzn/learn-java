package com.java.ProjectExercise.StudentManagement;

import java.util.*;

/**
 * 学生管理系统
 */
public class StudentManagementSystem {
    private final ArrayList<Student> studentManagement;

    public StudentManagementSystem() {
        this.studentManagement = new ArrayList<>();
    }

    /**
     * 获取学生信息
     */
    public void showStudentManagement() {
        for (Student student : studentManagement) {
            System.out.println(student);
        }
    }

    /**
     * 根据排序显示学生信息
     */
    public void showStudentManagementBySchoolRecordSort() {
        Collections.sort(studentManagement, Comparator.comparing(Student::getSchoolRecord).reversed());

        System.out.println("学生的成绩排名是：");
        int i = 1;
        for (Student student : studentManagement) {
            System.out.println(i + "." + student.getName() + "-" + student.getSchoolRecord());
            i++;
        }
    }

    /**
     * 输入学生名称
     *
     * @param name 名字
     */
    public void addStudent(String name) {
        studentManagement.add(new Student(name));
    }

    /**
     * 输入成绩
     *
     */
    public void inputScores() {
        Scanner sc = new Scanner(System.in);
        for (Student student : studentManagement) {
            System.out.println("请输入学生" + student.getName() + "的成绩");
            int score = sc.nextInt();
            student.setSchoolRecord(score);
        }

    }


}
