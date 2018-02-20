package q6_fib;

public class Solution {

    public int fib(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }
        else if (i > 2) {
            return fib(i - 1) + fib(i - 2);
        }
        return 0;
    }
}
