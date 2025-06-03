
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
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]+1<=9){
                digits[i]+=1;
                return digits;
            }else{
                digits[i]=0;
            }
       }
       int[] ar=new int[digits.length+1];
       ar[0]=1;
       return ar;
    }

}