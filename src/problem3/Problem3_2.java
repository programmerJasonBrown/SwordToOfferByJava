package problem3;

/*
*二分法找重复的数， 适用性太窄
* */
public class Problem3_2 {
    public static int getDuplication(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;
        int start = 1;
        int end = numbers.length - 1;
        while (start <= end) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, start, middle);
            if (start == end) {
                if (count > 1)
                    return start;
                break;
            }
            if (count > middle - start + 1) {
                end = middle;
            } else
                start = middle + 1;
        }
        return -1;
    }

    private static int countRange(int[] numbers, int start, int middle) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= start && numbers[i] <= middle) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 3, 6, 2, 2};
        System.out.println(getDuplication(nums));

    }

}
