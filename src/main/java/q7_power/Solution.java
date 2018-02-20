package q7_power;

public class Solution {

    //递归倍数降级
    public int power_2(int base, int power) {
        if (power == 0) {
            return 1;
        }
        else if (power == 1) {
            return base;
        }
        else if (power % 2 == 0) {
            return power(base, power / 2) * power(base, power / 2);
        }
        else if (power % 2 == 1) {
            return power(base, power / 2) * power(base, (power / 2) +1);
        }

        return 0;
    }





    //递归常量降级
    public int power(int base, int power) {
        if (power == 1) {
            return base;
        }
        return power(base,power - 1) * base;
    }
}
