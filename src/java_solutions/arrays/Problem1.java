
package java_solutions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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

    public int lengthOfLongestSubstring(String s) {
        // Edge case: empty string
        if (s == null || s.length() == 0)
            return 0;

        Set<Character> set = new HashSet<>(); // Set to track unique characters in current window
        int maxLength = 0; // Stores the maximum length found
        int start = 0; // Left boundary of sliding window

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If character is already in set, shrink window from the left
            while (set.contains(currentChar)) {
                set.remove(s.charAt(start));
                start++;
            }

            // Add current character to set
            set.add(currentChar);

            // Update maxLength if this window is longer
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA;
    }

    public int majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n / 2];
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }

        return n == 1;
    }

    private static int sumOfSquares(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }

        return sum;
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindromeLinkedLink(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode prev = null;

        while (mid != null) {
            ListNode nextNode = mid.next;
            mid.next = prev;
            prev = mid;
            mid = nextNode;
        }

        ListNode secondHalf = prev;
        while (secondHalf != null) {
            if (head.val != secondHalf.val) {
                return false;
            }

            head = head.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int maxLen = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int sum = map.get(key) + map.get(key + 1);
                maxLen = Math.max(maxLen, sum);
            }
        }

        return maxLen;
    }

    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = Double.NEGATIVE_INFINITY;
        double sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i >= k - 1) {
                maxAverage = Math.max(maxAverage, sum / k);
                sum -= nums[i - k + 1];
            }
        }
        return maxAverage;
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if (k == 0) {
            return res;
        }

        if (k < 0) {
            reverseArr(code);
        }

        int sum = 0;
        int absK = Math.abs(k);
        for (int i = 1; i <= absK; i++) {
            sum += code[i % n];
        }

        for (int i = 0; i < n; i++) {
            res[i] = sum;

            sum -= code[(i + 1) % n];
            sum += code[(absK + i + 1) % n];
        }

        if (k < 0) {
            reverseArr(res);
        }

        return res;
    }

    public void reverseArr(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while (s < e) {
            int temp = arr[e];
            arr[e] = arr[s];
            arr[s] = temp;
            s++;
            e--;
        }
    }

    public String longestNiceSubstring(String s) {
        if (s.length() < 2)
            return "";

        // Check if current string is nice
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(Character.toLowerCase(c)) == -1 || s.indexOf(Character.toUpperCase(c)) == -1) {
                // Split and recurse
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }

        // Whole string is nice
        return s;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        // Should never be reached if input guarantees exactly one solution
        throw new IllegalArgumentException("No two sum solution");
    }

    public int countGoodSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2)
                    && s.charAt(i + 1) != s.charAt(i + 2)) {
                result++;
            }
        }
        return result;

    }

     public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minimumDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            int diff = nums[i + k - 1] - nums[i];
            minimumDiff = Math.min(minimumDiff, diff);
        }

        return minimumDiff;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);

        return result;

    }

    private void inorder(TreeNode node, List<Integer>  result){

        if(node == null){
            return;
        }

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        return result;
    }

    private void preorder(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }

        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        postorder(root, result);

        return result;
    }

    private void postorder(TreeNode node, List<Integer> result){
        if(node != null){
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.val);
        }
    }

    class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q2.offer(x);

        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
    // Move everything out of s1
    while (!s1.isEmpty()) {
        s2.push(s1.pop());
    }

    // Push new element at bottom of queue
    s2.push(x);

    // Move everything back to s1
    while (!s2.isEmpty()) {
        s1.push(s2.pop());
    }
}

    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

    private Integer prev = null;
    private int count = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);

        // Convert List<Integer> to int[]
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        if (prev != null && node.val == prev) {
            count++;
        } else {
            count = 1;
        }

        if (count > maxCount) {
            maxCount = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == maxCount) {
            modes.add(node.val);
        }

        prev = node.val;

        inOrder(node.right);
    }

    class Solution_getMinimumDifference{
    private int min = Integer.MAX_VALUE;
    private Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);

        return min;
    }

    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        
        if(prev != null){
            int sub = node.val - prev;

            if(sub < min){
                min = sub;
            }
        }
        prev = node.val;
        inOrder(node.right);
    }
}

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

     private boolean dfs(TreeNode node, int k, HashSet<Integer> set) {
        if (node == null) return false;
        
        if (set.contains(k - node.val)) return true;
        
        set.add(node.val);
        
        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        return inOrder(root, val);
    }

    private TreeNode inOrder(TreeNode node, int val){
      if(node == null){
            return null;
        }

        if(node.val == val){
            return node;
        }

        TreeNode leftResult = inOrder(node.left, val);
        if(leftResult != null){
            return leftResult;
        }

        return inOrder(node.right, val);
}

 public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;

        int left = 0;
        int right = x;
        
        while(left <= right){
            int mid = left + (right - left)/2;

            long square = (long) mid * mid;
            if(square == x){
                return mid;
            } else if(square < x){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        return left -1;
    }

     public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

     public int missingNumber(int[] nums) {
         int n = nums.length;
        int xorResult = 0;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xorResult ^= i;
        }

        // XOR all numbers in the array
        for (int num : nums) {
            xorResult ^= num;
        }

        // The remaining value is the missing number
        return xorResult;
    }

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(isBadVersion(mid)){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return left;
        
    }

      public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();

        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }

         Set<Integer> set2 = new HashSet<>();

        for(int i = 0; i < nums2.length; i++){
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }

        int[] result = new int[set2.size()];

         int index = 0;
        for (int num : set2) {
            result[index++] = num;
        }

        return result;
    }

     public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (countMap.getOrDefault(num, 0) > 0) {
                result.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        int[] arr = new int[result.size()];

        int i = 0;
        for(int el : result){
            arr[i++] = el;
        }

        return arr;
    }

    public boolean isPerfectSquare(int num) {

        long left = 1;
        long right = num/2;

        if(num == 1){
            return true;
        }

        while(left <= right){
            long mid = left + (right - left)/2;

            if(mid * mid == num) return true;

            if(mid * mid > num){
                right = mid - 1;
            }

            if(mid * mid < num){
                left = mid + 1;
            }
        }

        return false;

    }

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
        
        int left = 1;
        int right = n;

        while(left <= right){
            int mid = left + (right - left)/2;

            int res = guess(mid);

            if(res == 0){
                return mid;
            }else if(res < 0){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }

        return -1;
        }
    }

    public int arrangeCoins(int n) {
        int left = 0;
        int right = n;

        while(left <= right){
            int mid = left + (right-left)/2;
            long rows = (long) mid * (mid + 1) / 2; // ✅ cast to long before multiply

            if(rows == n){
                return mid;
            } else if(rows < n){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(target == nums[mid]){
                return mid;
            } else if(target < nums[mid]){
                right = mid - 1; 
            } else{
                left = mid + 1;
            }
        }

        return -1;
        
    }

     public int rotatedSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target) return mid;

            if(nums[left] <= nums[mid]){
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target in left half
                } else {
                    left = mid + 1; // target in right half
                }
            } else{
                 if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // target in right half
                } else {
                    right = mid - 1; // target in left half
                }
            }
        }

          return -1;
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
          // 1. Compute sums
        int sumA = 0, sumB = 0;
        for (int a : aliceSizes) sumA += a;
        for (int b : bobSizes) sumB += b;

        // 2. Compute delta (the difference Alice needs to give compared to Bob)
        int delta = (sumA - sumB) / 2;

        // 3. Put all of Bob’s candy box sizes in a HashSet
        Set<Integer> bobSet = new HashSet<>();
        for (int b : bobSizes) bobSet.add(b);

        // 4. For each candy size Alice has, check if a matching box exists in Bob’s set
        for (int x : aliceSizes) {
            int y = x - delta; // candidate from Bob
            if (bobSet.contains(y)) {
                return new int[]{x, y}; // found valid pair
            }
        }

        // 5. Guaranteed one answer exists, but just in case
        return new int[0];
    }

}