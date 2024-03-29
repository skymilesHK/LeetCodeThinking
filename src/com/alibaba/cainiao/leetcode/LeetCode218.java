package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 218. The Skyline Problem
 * Hard
 *
 * 2388
 *
 * 128
 *
 * Add to List
 *
 * Share
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
 *
 * Buildings Skyline Contour
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 *
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 *
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 *
 * Notes:
 *
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 */
public class LeetCode218 {

    // https://www.bilibili.com/video/av65110529?from=search&seid=15209648612334036618
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();

        for (int[] building : buildings) {
            // 左顶点存为负数
            points.add(new int[] {building[0], -building[2]});
            // 右顶点存为正数
            points.add(new int[] {building[1], building[2]});
        }

        // 根据横坐标对列表排序，相同横坐标的点纵坐标小的排在前面
        Collections.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        // 构建堆，按照纵坐标来判断大小
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int preHeight = 0;
        for (int[] point : points) {
            // 将左顶点加入堆中,将右顶点对应的左顶点移去
            if (point[1] < 0) {
                pq.offer(-point[1]);
            } else {
                pq.remove(point[1]);
            }

            Integer curMaxHeight = pq.peek();
            if (curMaxHeight != preHeight) {
                res.add(Arrays.asList(point[0], curMaxHeight));
                preHeight = curMaxHeight;
            }
        }
        return res;
    }
}
