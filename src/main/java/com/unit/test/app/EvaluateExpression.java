package com.unit.test.app;


import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        System.out.println("CHƯƠNG TRÌNH TÍNH TOÁN");
        System.out.println("Nhập biểu thức cần tính toán(Nhập 0 để thoát):");
        String expression = input();
        while (!expression.equals("0")){
            try {
                System.out.println("Kết quả là: " + evaluateExpression(expression));
            } catch (Exception ex) {
                System.out.println(" Biểu thức lỗi: " + expression);
            }
            System.out.println("Nhập biểu thức cần tính toán(Nhập 0 để thoát):");
            expression = input();
        }
        System.out.println("Kết thúc chương trình!");

    }

    public static String input(){
        Scanner scanner = new Scanner( System.in );
        return scanner.nextLine();
    }

    public static double evaluateExpression(String expression) {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.length() == 0)
                continue;
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (
                        !operatorStack.isEmpty() && (
                                operatorStack.peek() == '+' ||
                                        operatorStack.peek() == '-' ||
                                        operatorStack.peek() == '*' ||
                                        operatorStack.peek() == '/')) {
                    processOperator(operandStack, operatorStack);
                }

                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (
                        !operatorStack.isEmpty() && (
                                operatorStack.peek() == '*' ||
                                        operatorStack.peek() == '/')) {
                    processOperator(operandStack, operatorStack);
                }

                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {
                while (operatorStack.peek() != '(') {
                    processOperator(operandStack, operatorStack);
                }

                operatorStack.pop();
            } else {
                operandStack.push(new Double(token));
            }
        }

        while (!operatorStack.isEmpty()) {
            processOperator(operandStack, operatorStack);
        }

        // Return the result
        return operandStack.pop();
    }

    public static void processOperator(Stack<Double> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        double op1 = operandStack.pop();
        double op2 = operandStack.pop();

        if (op == '+')
            operandStack.push(op2 + op1);
        else if (op == '-')
            operandStack.push(op2 - op1);
        else if (op == '*')
            operandStack.push(op2 * op1);
        else if (op == '/')
            operandStack.push(op2 / op1);
    }
}