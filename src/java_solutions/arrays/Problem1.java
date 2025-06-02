
package java_solutions.arrays;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println("✅ Java is running!");
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int k = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[k] != nums[i]) {
                ++k;
                nums[k] = nums[i];
            }
        }

        return k + 1;
    }

}