package Midterm;

import java.util.Scanner;

public class Assignment_palindrome {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("enter a word:"+" ");
        String name;
        name = in.nextLine();
        name = name.toUpperCase();

        int length = name.length();

        for (int a = 0, j = length - 1; a < j; a++, j--) {
            if (name.charAt(a) == name.charAt(j)) {
                System.out.println("a Palindrome!");
                return;
            }
        }
        System.out.println("It is not a Palindrome!");
    }
}
