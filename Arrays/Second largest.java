class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int first = -1;
        int second = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                first = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != first && arr[i] > second) {
                second = arr[i];
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 10, 5, 10 };
        System.out.println("Second largest: " + sol.getSecondLargest(arr));
    }
}