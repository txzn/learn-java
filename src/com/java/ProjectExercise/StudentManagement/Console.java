package com.java.ProjectExercise.StudentManagement;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        while (true) {
            System.out.println("\n欢迎使用学生成绩管理系统");
            System.out.println("1. 添加学生");
            System.out.println("2. 录入成绩");
            System.out.println("3. 显示成绩排名");
            System.out.println("4. 退出");
            System.out.println("请选择操作：");

            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("请输入学生姓名");
                    String name = sc.next();
                    studentManagementSystem.addStudent(name);
                    break;
                case 2:
                    studentManagementSystem.inputScores();
                    break;
                case 3:
                    studentManagementSystem.showStudentManagementBySchoolRecordSort();
                    break;
                case 4:
                    System.out.println("感谢使用，再见！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }

        }

    }
}
