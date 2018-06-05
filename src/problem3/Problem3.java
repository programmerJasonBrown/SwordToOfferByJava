package problem3;

public class Problem3 {
/*
  思路：因为数字限定在0-n-1的范围内，则可以将数字与下标对应，若遇到乱序则进行还原；时间复杂度o(n)，空间复杂度o(1)
  step：从头到尾扫描这个数组中的每个数字。当扫描到下标为i的数字时，首先比较这个数字（用m表示）是不是等于i
    如果是：i++ 扫描下一个数
    如果不是：比较m和数组下标为m处的数字，
        如果相等：则表示找到重复数字m，返回true；
        如果不等：将下标为m和i处的数字。重复step；
*/

    public static boolean duplicate(int numbers[]) {
        if (numbers == null || numbers.length == 0)
            return false;
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers[i])
                i++;
            else {
                if (numbers[i] == numbers[numbers[i]])
                    return true;
                else {
                    int temp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate(a));
    }
}
