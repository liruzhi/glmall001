package com.glmall.user.controller;

import org.yaml.snakeyaml.tokens.BlockEndToken;

import java.util.LinkedList;

public class leetCodeController {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);

        for (int i:res) {
            System.out.println(i);
        }
    }


    //239. 滑动窗口最大值
    public static int[] maxSlidingWindow(int[] nums, int k)   {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        for (int i=0;i<nums.length;i++) {
            //将超出左边界的截取掉
            if (i>=k && queue.getFirst() <= i-k) {
                queue.pollFirst();
            }
            //构造单调递减，保证最左侧为最大
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.pollLast();
            }
            //追加到队列中
            queue.add(i);
            //追加到结果中
            if (i >= k-1) {
                result[i-k+1] = nums[queue.getFirst()];
            }
        }

        return result;
    }

}
