package Midterm;

import java.util.Scanner;

public class ToribioJL_SimpleCalculator {
    public static double add(double a, double b){
        return a + b;
    }
    public static double subtract(double a, double b){
        return a - b;
    }
    public static double multiply(double a, double b){
        return a * b;
    }
    public static double divide(double a, double b){
    if(b == 0){
    System.out.println("Error! Any number divided by zero is undefined.");
           return 0; 
}
    return a / b;
    }  
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double a = in.nextDouble();
        
        System.out.println("Choose an operation: ");
        System.out.println("Add = +");
        System.out.println("Subtract = -");
        System.out.println("Multiply = *");
        System.out.println("Divide = /");
        
        System.out.print("Enter your choice: ");
        char operator = in.next().charAt(0);
        
        System.out.print("Enter second number: ");
        double b = in.nextDouble();

        double result = 0;

        switch (operator) {
            case '+':
                result = add(a, b);
                System.out.println("Result = " + result);
                break;
            case '-':
                result = subtract(a, b);
                System.out.println("Result = " + result);
                break;
            case '*':
                result = multiply(a, b);
                System.out.println("Result = " + result);
                break;
            case '/':
                result = divide(a, b);
                if (b != 0) {
                    System.out.println("Result = " + result);
                }
                break;
            default:
                System.out.println("Invalid choice! Please enter a valid operation.");
        }
    
        in.close();
    }
}
