package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution200 {

    // 宽度优先搜索.
    public int numIslands_bfs(char[][] grid){
        int rowLen= grid.length;
        int columnLen= grid[0].length;
        int landSize= 0;
        Deque<Integer> deque= new ArrayDeque<Integer>();
        for(int i= 0; i< rowLen; ++i){
            for(int j= 0; j< columnLen; ++j){
                if(grid[i][j]== '1'){
                    landSize++;
                    // 发现陆地，然后以此为起点进行搜索，并把与当前陆地相连陆地全部变成水，进而避免了重复搜索.
                    int value= i* columnLen+ j;
                    deque.offer(value);
                    while(!deque.isEmpty()){
                        Integer tmp= deque.pop();
                        int row= tmp/ columnLen;
                        int column= tmp% columnLen;
                        if(grid[row][column]== '0'){
                            continue;
                        }
                        grid[row][column]= '0';
                        // 提前逐个判断，需要保证基于当前位置递归搜索的下一个位置一定是有效的.
                        if(row- 1>= 0){
                            deque.offer((row- 1)* columnLen+ column);
                        }
                        if(row+ 1< rowLen){
                            deque.offer((row+ 1)* columnLen+ column);
                        }
                        if(column- 1>= 0){
                            deque.offer(row* columnLen+ (column- 1));
                        }
                        if(column+ 1< columnLen){
                            deque.offer(row* columnLen+(column+ 1));
                        }
                    }
                }
            }
        }
        return landSize;
    }

    // 深度优先搜索.
    public int numIslands_dfs(char[][] grid) {
        int rowLen= grid.length;
        if(rowLen== 0){
            return 0;
        }
        int columnLen= grid[0].length;
        int landCount= 0;
        for(int i= 0; i< rowLen; ++i){
            for(int j= 0; j< columnLen; ++j){
                if(grid[i][j]== '1'){
                    landCount= landCount+ 1;
                    // 只要发现陆地，就使用深度搜索将陆地变成水.
                    dfs(grid, i, j, rowLen, columnLen);
                }
            }
        }
        return landCount;
    }

    private void dfs(char[][] grid, int row, int column, final int rowLen, final int columnLen){
        if(row< 0|| row>= rowLen|| column< 0|| column>= columnLen|| grid[row][column]=='0'){
            return;
        }
        // 把陆地变成水
        grid[row][column]= '0';
        dfs(grid, row- 1, column, rowLen, columnLen);
        dfs(grid, row+ 1, column, rowLen, columnLen);
        dfs(grid, row, column- 1, rowLen, columnLen);
        dfs(grid, row, column+ 1, rowLen, columnLen);
    }

}
