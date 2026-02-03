// Problem: Reverse an array
// Approach: Two pointer technique
// Time Complexity: O(n)
// Space Complexity: O(1)

public class ReverseArray {

    public static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
