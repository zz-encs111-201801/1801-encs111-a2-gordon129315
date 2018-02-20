package q5_expression;

import java.util.LinkedList;

public class Solution {

    /*
     * 假设 formula 一定不会是 null
     * 假设 formula 里的公式一定是合法的，也就是说 不可能出现 "1+"
     * 假设 formula 里至少有一个数
     * 假设 formula 里 的运算符只有 + - * /
     * 假设 formula 的 数和运算符 之间 可能有空格，"1 + 2"， 或者 "1 +2"
     */

    public double evaluate(String formula) {
        formula += "$";
        LinkedList<Double> num_list = new LinkedList<>();
        LinkedList<Character> oprt_list = new LinkedList<>();
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == ' ') {
                continue;
            }
            else if (formula.charAt(i) == '$') {
                while (!oprt_list.isEmpty()) {
                    num_list.add(calculate(num_list.removeLast(), num_list.removeLast(), oprt_list.removeLast()));
                }
            }
            else if (Character.isDigit(formula.charAt(i))) {
                num_list.add(Double.parseDouble(formula.charAt(i) + ""));
            }
            else {
                if (oprt_list.isEmpty() || priority(formula.charAt(i)) > priority(oprt_list.getLast())) {
                    oprt_list.add(formula.charAt(i));
                }
                else {
                    num_list.add(calculate(num_list.removeLast(), num_list.removeLast(), oprt_list.removeLast()));
                    oprt_list.add(formula.charAt(i));
                }
            }
        }

        String result = "";
        for (double value: num_list) {
            result += (int)value +"";
        }

//        return num_list.getLast();
        return Double.parseDouble(result);
    }

    public int priority (char ch) {
        if (ch == '*' || ch == '/') {
            return 2;
        }
        else if (ch == '-' || ch == '+') {
            return 1;
        }
        return 0;
    }

    public double calculate(double v2, double v1, char oprt) {
        double result = 0;
        switch (oprt)
        {
            case '+':
                result = v1 + v2;
                break;

            case '-':
                result = v1 - v2;
                break;

            case '*':
                result = v1 * v2;
                break;

            case '/':
                result = v1 / v2;
                break;
        }
        return result;
    }
}
