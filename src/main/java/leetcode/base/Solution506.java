package leetcode.base;

import java.util.PriorityQueue;

/**
 * 506. 相对名次
 * https://leetcode.cn/problems/relative-ranks/
 */
public class Solution506 {

    private PriorityQueue<Athlete> queue;
    private static final String[] names = {"Gold Medal", "Silver Medal", "Bronze Medal"};

    public String[] findRelativeRanks(int[] score) {
        int size = score.length;
        String[] res = new String[size];
        // 大顶堆
        queue = new PriorityQueue<Athlete>((item1, item2) -> item2.score - item1.score);
        for (int i = 0; i < size; ++i) {
            queue.offer(new Athlete(i, score[i]));
        }
        int index = 0;
        while (!queue.isEmpty()) {
            Athlete athlete = queue.poll();
            if (index < names.length) {
                res[athlete.pos] = names[index];
            } else {
                res[athlete.pos] = String.valueOf(index + 1);
            }
            index++;
        }
        return res;
    }

    private static class Athlete {
        private int pos;
        private int score;

        public Athlete(int pos, int score) {
            this.pos = pos;
            this.score = score;
        }
    }

}
