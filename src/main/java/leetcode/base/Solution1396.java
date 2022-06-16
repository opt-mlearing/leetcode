package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 1396. 设计地铁系统
 * https://leetcode.cn/problems/design-underground-system/
 *
 * @author: caogl
 * @date: 2022/6/17, 0:30
 **/
public class Solution1396 {

    private static class Start {
        private String stationName;
        private int time;

        public Start(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class End {
        private int total;
        private int count;

        public End() {
            this.total = 0;
            this.count = 0;
        }
    }

    private Map<Integer, Start> map1;
    private Map<String, End> map2;

    public Solution1396() {
        this.map1 = new HashMap<Integer, Start>();
        this.map2 = new HashMap<String, End>();
    }

    public void checkIn(int id, String stationName, int t) {
        map1.put(id, new Start(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Start start = map1.get(id);
        String key = start.stationName + "_" + stationName;
        End end = map2.getOrDefault(key, new End());
        end.total = end.total + t - start.time;
        end.count++;
        map2.put(key, end);
    }

    public double getAverageTime(String startStation, String endStation) {
        End end = map2.get(startStation + "_" + endStation);
        if (end != null) {
            return end.total / (double) end.count;
        }
        return -1.0;
    }

}
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
