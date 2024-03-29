package mycode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

public class SimpleCalc {
    private static Stack<Double> stack = new Stack<>();
    private static Stack<Stack<Double>> history = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int index = 0;
            String input = reader.readLine();
            String[] inputLine = input.trim().split("\\s+");
            for (String s : inputLine)
                try {
                    index++;
                    calc(s);
                } catch (EmptyStackException e) {
                    System.out.println("operator " + s + " (position: " + (index * 2 - 1) + ") insucient parameters");
                    stack = undoOperation();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input is not a number or operator");
                    stack = undoOperation();
                    break;
                }
            printStack();
        }
    }

    public static void calc(String s) {
        switch (s) {
            case "+":
                addToStackHistory();
                sum();
                break;
            case "-":
                addToStackHistory();
                subtraction();
                break;
            case "*":
                addToStackHistory();
                multiply();
                break;
            case "/":
                addToStackHistory();
                division();
                break;
            case "sqrt":
                addToStackHistory();
                squareRoot();
                break;
            case "undo":
                stack = undoOperation();
                break;
            case "clear":
                addToStackHistory();
                stack.clear();
                break;
            default:
                addToStackHistory();
                addToStack(s);
        }
    }

    public static void addToStack(String a) {
        double number = Double.parseDouble(a);
        stack.push(number);
    }

    public static void sum() {
            stack.push(stack.pop() + stack.pop());
    }

    public static void subtraction() {
            double n1 = stack.pop();
            double n2 = stack.pop();
            stack.push(n2 - n1);
    }

    public static void multiply() {
            stack.push(stack.pop() * stack.pop());
    }

    public static void division() {
        if (stack.peek() != 0) {
            double n1 = stack.pop();
            double n2 = stack.pop();
            stack.push(n2 / n1);
        } else System.out.println("Division by 0");
    }

    public static void squareRoot() {
        if (stack.peek() >= 0) {
            double n = Math.sqrt(stack.pop());
            stack.push(n);
        } else System.out.println("Cant calc square root of negative number");
    }

    public static Stack<Double> undoOperation() {
        return history.pop();
    }

    public static void addToStackHistory() {
        Stack<Double> tempStack = new Stack<>();
        tempStack.addAll(stack);
        history.push(tempStack);
    }

    public static void printStack() {
        System.out.print("stack: ");
        for (Double d : stack) {
            System.out.printf(BigDecimal.valueOf(d).stripTrailingZeros().toPlainString() + " ");
        }
    }
}
