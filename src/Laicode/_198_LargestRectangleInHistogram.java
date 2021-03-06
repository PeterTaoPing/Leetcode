package Laicode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _198_LargestRectangleInHistogram {
    public class Solution1 {
        public int largest(int[] array) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.offerFirst(-1);
            int maxArea = 0;
            for(int i = 0; i < array.length; i++) {
                while(stack.peekFirst() != -1 && array[i] <= array[stack.peekFirst()]) {
                    maxArea = Math.max(maxArea, array[stack.pollFirst()] * (i - stack.peekFirst() - 1));
                }
                stack.offerFirst(i);
            }
            while(stack.peekFirst() != -1) {
                maxArea = Math.max(maxArea, array[stack.pollFirst()] * (array.length - stack.peekFirst() - 1));
            }
            return maxArea;
        }
    }

    public class Solution2 {
        public int largest(int[] array) {
            Deque<Integer> stack = new ArrayDeque<>();
            int res = 0;
            for(int i = 0; i <= array.length; i++) {
                int cur = i == array.length ? 0 : array[i];
                while(!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
                    int height = array[stack.pollFirst()];
                    int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                    res = Math.max(res, (i - left) * height);
                }
                stack.offerFirst(i);
            }
            return res;
        }
    }

}
