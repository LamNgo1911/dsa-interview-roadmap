
package java_solutions.arrays;

import java.util.ArrayList;
import java.util.List;

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

    public int removeElement(int[] nums, int val) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Keep it
                k++;
            }
        }
        return k;

    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 <= 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] ar = new int[digits.length + 1];
        ar[0] = 1;
        return ar;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        int val = nums[mid];
        TreeNode node = new TreeNode(val);

        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);

        return node;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> valueArr = new ArrayList<>();
            valueArr.add(1);

            for (int j = 1; j <= i - 1; j++) {
                int preFirstVal = result.get(i - 1).get(j - 1);
                int preSecondVal = result.get(i - 1).get(j);
                int val = preFirstVal + preSecondVal;

                valueArr.add(val);
            }

            if (i > 0) {
                valueArr.add(1);
            }
            result.add(valueArr);
        }

        return result;
    }
}