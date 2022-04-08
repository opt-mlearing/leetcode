package leetcode;

import java.util.Arrays;

/**
 * 车队
 * https://leetcode-cn.com/problems/car-fleet/
 */
public class Solution853 {

    public int carFleet(int target, int[] position, int[] speed) {
        int size = position.length;
        Car[] cars = new Car[size];
        for (int i = 0; i < size; ++i) {
            int pos = position[i];
            int spd = speed[i];
            // 注意这里时间一定要转成double，若否，则部分case错误.
            cars[i] = new Car(pos, spd, ((target - pos) / (double) spd));
        }
        // 按照出发位置降序排列
        Arrays.sort(cars, (car1, car2) -> car2.position - car1.position);
        double preArrive = -1.;
        int res = 0;
        for (int i = 0; i < size; ++i) {
            if (preArrive < cars[i].time) {
                preArrive = cars[i].time;
                res++;
            }
        }
        return res;
    }

    private static class Car {
        private int position;
        private int speed;
        private double time;

        public Car(int position, int speed, double time) {
            this.position = position;
            this.speed = speed;
            this.time = time;
        }
    }

}
