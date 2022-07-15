package GraderPackage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grader grader = new Grader();
        Scanner sc = new Scanner(System.in);
        String totalMark;
        int credit;
        System.out.print("Enter Credit: ");
        credit = sc.nextInt();
        System.out.print("Enter total marks received: ");
        totalMark = sc.next();


        System.out.println(grader.getGrade(totalMark, credit));
    }
}
