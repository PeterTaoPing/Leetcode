import java.util.HashMap;
import java.util.PriorityQueue;

public class _1329_SorttheMatrixDiagonally {
    class Solution {
        public int[][] diagonalSort(int[][] A) {
            int m = A.length;
            int n = A[0].length;
            HashMap<Integer, PriorityQueue<Integer>> d = new HashMap<>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    d.putIfAbsent(i - j, new PriorityQueue<>());
                    d.get(i - j).add(A[i][j]);
                }
            }
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j)
                    A[i][j] = d.get(i - j).poll();
            return A;
        }
    }
}
