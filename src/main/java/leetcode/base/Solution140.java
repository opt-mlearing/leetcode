package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 140. 单词拆分 II
 * https://leetcode-cn.com/problems/word-break-ii/
 */
public class Solution140 {

    private List<String> res;
    private boolean[] dp;

    // 回溯+ 动规，需要提前判断该位置分割后有效性.
    public List<String> wordBreak(String s, List<String> wordDict) {
        res= new ArrayList<String>();
        if(s== null || s.length()== 0 || wordDict== null || wordDict.size()== 0){
            return res;
        }
        int size= s.length();
        dp= new boolean[size+ 1];
        dp[0]= true;
        for(int i= 1; i<= size; ++i){
            for(int j= 0; j< i; ++j){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i]= true;
                }
            }
        }
        if(dp[size]){
            backTracking(s, wordDict, size, new LinkedList<String>());
        }
        return res;
    }

    private void backTracking(String s, List<String> wordDict, int index, Deque<String> path){
        if(index== 0){
            res.add(String.join(" ", path));
            return;
        }
        for(int i= index- 1; i>= 0; --i){
            String word= s.substring(i, index);
            if(wordDict.contains(word) && dp[i]){
                path.push(word);
                backTracking(s, wordDict, i, path);
                path.poll();
            }
        }
    }


}
