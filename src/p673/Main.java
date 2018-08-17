package p673;

import java.util.Scanner;
import java.util.Stack;

/**
 * You are given a string consisting of parentheses () and []. A string of this type is said to be correct:
 * (a) if it is the empty string
 * (b) if A and B are correct, AB is correct,
 * (c) if A is correct, (A) and [A] is correct.
 * Write a program that takes a sequence of strings of this type and check their correctness. Your
 * program can assume that the maximum string length is 128.
 */
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCaseCount = in.nextInt();
        in.nextLine();
        for (int i = 0; i < testCaseCount; i++) {
            String testCase = in.nextLine();
            System.out.println(isCorrect(testCase) ? "Yes" : "No");
        }
    }

    private static boolean isCorrect(String testCase) {
        Stack<Character> stack = new Stack<>();
        for (char c : testCase.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c == '(' || c == '[') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character queueHead = stack.pop();
                if (queueHead == null) {
                    return false;
                }
                if ((c == ')' && queueHead != '(') || (c == ']' && queueHead != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}