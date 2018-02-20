package q12_394;

import java.util.LinkedList;

/*
 *  https://leetcode.com/contest/leetcode-weekly-contest-3/problems/decode-string/
 *  Hint: List
 *
 *  请将代码提交到上面的网址进行测试
 */
public class Solution {
    public String decodeString(String s) {
        if (s.equals("")) {
            return "";
        }

        LinkedList<Character> charList = new LinkedList<>();
        LinkedList<Integer> numList = new LinkedList<>();

        StringBuilder num = new StringBuilder();
        StringBuilder subList = new StringBuilder();

        char c = ' ';
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isDigit(c)) {
                num.append(c);
            }
            else if (c == '[') {
                numList.add(Integer.parseInt(num.toString()));
                num.delete(0, num.length());
                charList.add('[');
            }
            else if (c == ']') {
                int index = charList.lastIndexOf('[');
                charList.remove(index);
                int times = numList.getLast();
                numList.removeLast();
                for (int k = 1; k < times ; k++) {
                    for (int j = index; j < charList.size(); j++) {
                        subList.append(charList.get(j));
                    }
                }
                for (int j = 0; j < subList.length(); j++) {
                    charList.add(subList.charAt(j));
                }
                subList.delete(0, subList.length());
            }
            else if (!Character.isDigit(c)){
                charList.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : charList) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("1[a]"));
    }
}

