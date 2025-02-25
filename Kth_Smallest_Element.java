import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Insert first column elements into the heap
        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        // Extract min k-1 times
        for (int i = 0; i < k - 1; i++) {
            int[] smallest = minHeap.poll();
            int row = smallest[1], col = smallest[2];

            // Insert next element from the same row
            if (col + 1 < n) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return minHeap.poll()[0]; // k-th smallest element
    }
}
