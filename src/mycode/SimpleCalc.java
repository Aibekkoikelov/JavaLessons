package mycode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

public class SimpleCalc {
    private static Stack<Double> stack = new Stack<>();
    private static Stack<Stack<Double>> newStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = reader.readLine();
            String[] inputLine = input.trim().split("\\s+");
            for (String s : inputLine)
                try {
                    calc(s);
                } catch (EmptyStackException e) {
                    System.out.println("куда ты лезешь, укурок? нет столько чисел");
                    printStack(stack);
//                    break;
                }
            printStack(stack);
        }
    }

    public static void calc(String s) {
        switch (s) {
            case "+":
                addToStackHistory(stack);
                sum(stack);
                break;
            case "-":
                addToStackHistory(stack);
                subtraction(stack);
                break;
            case "*":
                addToStackHistory(stack);
                multiply(stack);
                break;
            case "/":
                addToStackHistory(stack);
                division(stack);
                break;
            case "sqrt":
                addToStackHistory(stack);
                squareRoot(stack);
                break;
            case "undo":
                stack = undoOperation(newStack);
                break;
            case "clear":
                addToStackHistory(stack);
                stack.clear();
                break;
            default:
                addToStackHistory(stack);
                addToStack(stack, s);
        }
    }

    public static void addToStack(Stack<Double> stack, String a) {

        double number = Integer.parseInt(a);
        stack.push(number);
    }

    public static void sum(Stack<Double> stack) {
        stack.push(stack.pop() + stack.pop());

    }

    public static void subtraction(Stack<Double> stack) {
        double n1 = stack.pop();
        double n2 = stack.pop();
        stack.push(n2 - n1);
    }

    public static void multiply(Stack<Double> stack) {
        stack.push(stack.pop() * stack.pop());
    }

    public static void division(Stack<Double> stack) {
        double n1 = stack.pop();
        double n2 = stack.pop();
        stack.push(n2 / n1);
    }

    public static void squareRoot(Stack<Double> stack) {
        double n = Math.sqrt(stack.pop());
        stack.push(n);
    }

    public static Stack<Double> undoOperation(Stack<Stack<Double>> newStack) {
        return newStack.pop();
    }

    public static void addToStackHistory(Stack<Double> stack) {
        Stack<Double> tempStack = new Stack<>();
        tempStack.addAll(stack);
        newStack.push(tempStack);
    }

    public static void printStack(Stack<Double> stack) {
        for (Double d : stack) {
            System.out.printf(BigDecimal.valueOf(d).stripTrailingZeros().toPlainString() + " ");
        }
    }
}
