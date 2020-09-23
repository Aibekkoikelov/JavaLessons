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
                switch (s) {
                    case "+":
//                        newStack.push(stack);
                        sum(stack);
                        break;
                    case "-":
//                        newStack.push(stack);
                        subtraction(stack);
                        break;
                    case "*":
//                        newStack.push(stack);
                        multiply(stack);
                        break;
                    case "/":
//                        newStack.push(stack);
                        division(stack);
                        break;
                    case "sqrt":
//                        newStack.push(addToStackHistory(stack));
                        squareRoot(stack);
                        break;
                    case "undo":
                        stack = undoOperation(newStack);
                        break;
                    case "clear":
//                        newStack.push(addToStackHistory(stack));
                        stack.clear();
                        break;
                    default:
                        addToStackHistory(stack);
                        addToStack(stack, s);
                }
            printStack(stack);
        }
    }

    public static void addToStack(Stack<Double> stack, String a) {
        try {
            double number = Integer.parseInt(a);
            stack.push(number);

        } catch (NumberFormatException e) {
            System.out.println("чо ты ввёл , пёс?");
        }

    }

    public static void sum(Stack<Double> stack) {
        try {
            stack.push(stack.pop() + stack.pop());
        } catch (EmptyStackException e) {
            System.out.println("куда ты лезешь, укурок? нет столько чисел");
        }
    }

    public static void subtraction(Stack<Double> stack) {
        try {
            double n1 = stack.pop();
            double n2 = stack.pop();
            stack.push(n2 - n1);
        } catch (EmptyStackException e) {
            System.out.println("куда ты лезешь, укурок? нет столько чисел");
        }
    }

    public static void multiply(Stack<Double> stack) {
        try {
            stack.push(stack.pop() * stack.pop());
        } catch (EmptyStackException e) {
            System.out.println("куда ты лезешь, укурок? нет столько чисел");
        }
    }

    public static void division(Stack<Double> stack) {
        try {
            double n1 = stack.pop();
            double n2 = stack.pop();
            stack.push(n2 / n1);
        } catch (EmptyStackException e) {
            System.out.println("куда ты лезешь, укурок? нет столько чисел");
        }
    }

    public static void squareRoot(Stack<Double> stack) {
        try {
            double n = Math.sqrt(stack.pop());
            stack.push(n);
        } catch (EmptyStackException e) {
            System.out.println("куда ты лезешь, укурок? нет столько чисел");
        }
    }

    public static Stack<Double> undoOperation(Stack<Stack<Double>> newStack) {
        return newStack.peek();
    }

    public static void addToStackHistory(Stack<Double> stack) {
        Stack<Double> tempStack = new Stack<>();
        tempStack.addAll(stack);
        newStack.add(tempStack);
    }

    public static void printStack(Stack<Double> stack) {
        for (Double d : stack) {
            System.out.printf(BigDecimal.valueOf(d).stripTrailingZeros().toPlainString() + " ");
        }
    }
}
