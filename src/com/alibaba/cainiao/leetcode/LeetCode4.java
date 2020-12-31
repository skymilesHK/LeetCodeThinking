package com.alibaba.cainiao.leetcode;

/**
 * 4. Median of Two Sorted Arrays
 * Hard
 *
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class LeetCode4 {

    // https://www.acwing.com/video/1320/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 == 0) {
            // 偶数
            return (findKNumber(nums1, 0, m - 1, nums2, 0, n - 1, total / 2)
                    + findKNumber(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1)) / 2.0;
        } else {
            // 奇数
            return findKNumber(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);
        }
    }

    // k不表示计算机下标，表示人类下标
    private double findKNumber(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
        int m = aEnd - aStart + 1;
        int n = bEnd - bStart + 1;
        //1. 统一将长度短的放置于find函数参数的前面项
        if (m > n) {
            return findKNumber(B, bStart, bEnd, A, aStart, aEnd, k);
        }

        //2. 长度短的数组为空，则答案等同于求另外一个数组的中位数
        if (m == 0) {
            return B[k - 1];
        }

        //3. 递归到终点,都剩下了一个元素，两个数组的aStart和bStart已经到了中位数的位置 (k＝1表示就是取这两个顺序数组的第一个数)
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        //4. 没有递归到终点。那此时A班派出第x矮的同学，B班派出第y矮的同学来比较（注意：此时x+y<=k）只要（x+y)<=k的情况，x与y只要是为非负的，那都可以。只是为了效率，一般去x=y=(k/2)。A班派出第k/2矮的同学,B班派出第k/2矮的同学
        int pa = Math.min(k / 2, m);    // 比如A=[1] , B=[3, 5, 7, 9, 11, 12]。这时候k/2＝2，但是A只有一个所以派不出2个。只能派出aEnd=1个
        int pb = k - pa;                // B派出k - pa个

        // pa, pb都和k一样，表示人类下标
        if (A[aStart + pa - 1] < B[bStart + pb - 1]) {
            // 去掉A的左半边
            return findKNumber(A, aStart + pa, aEnd, B, bStart, bEnd, k - pa);
        } else if (A[aStart + pa - 1] > B[bStart + pb - 1]) {
            // 去掉B的左半边
            return findKNumber(A, aStart, aEnd, B, bStart + pb, bEnd, k - pb);
        } else {
            return A[aStart + pa - 1];
        }
    }
}
