package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 不同字符的最小子序列
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
 */
public class Solution1081 {

    public String smallestSubsequence(String s) {
        char[] chars= s.toCharArray();
        int size= chars.length;
        int[] lastIndex= new int[26];
        for(int i= 0; i< chars.length; ++i){
            lastIndex[chars[i]- 'a']= i;
        }
        boolean[] isVisit= new boolean[26];
        Deque<Character> stack= new LinkedList<Character>();
        for(int i= 0; i< size; ++i){
            if(isVisit[chars[i]- 'a']){
                continue;
            }
            while(!stack.isEmpty() && (stack.peek()- 'a'> chars[i]- 'a') && (lastIndex[stack.peek()- 'a']> i)){
                int topIndex= stack.pop()- 'a';
                isVisit[topIndex]= false;
            }
            stack.push(chars[i]);
            isVisit[chars[i]- 'a']= true;
        }
        // 注意结果是颠倒的，需要反过来取.
        StringBuilder builder= new StringBuilder();
        while(!stack.isEmpty()){
            builder.append(stack.pollLast());
        }
        return builder.toString();
    }

}
