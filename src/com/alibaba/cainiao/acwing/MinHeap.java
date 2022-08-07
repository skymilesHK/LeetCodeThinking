package com.alibaba.cainiao.acwing;

public class MinHeap {

    private int[] heap;
    private int size = 0;   // 元素存在于PQ[1]~PQ[N]中,pq[0]存放堆中元素数量

    public MinHeap(int capacity) {
        heap = new int[size + 1];
    }

    public int getSize() {
        heap[0] = size;
        return size;
    }

    // 获取最小值
    public int get() {
        heap[0] = size;
        return heap[1];
    }

    public void insert(int x) {
        heap[++size] = x;
        swim(size);
    }

    public int delete() {
        int oldMin = get();             //下标1的节点是最小值
        swap(1, size);                //将第一个元素和最后一个元素交换
        size--;
        sink(1);                     //恢复删除以后堆的有序
        return oldMin;
    }

    // 删除下标k的数
    public int deleteK(int k) {
        int oldK = heap[k];             //下标k的节点是最小值
        swap(k, size);                  //将第k个元素和最后一个元素交换
        size--;
        if (oldK < heap[size]) {
            sink(k);
        } else {
            swim(k);
        }
        return oldK;
    }

    // 修改下标k的数
    public void modifyK(int k, int x) {
        int oldK = heap[k];             //下标k的节点是最小值
        heap[k] = x;
        if (oldK < heap[size]) {
            sink(k);
        } else {
            swim(k);
        }
    }

    private void swim(int k) {
        // index=k/2的元素大于index=k的元素
        // 不停交换index=k/2和index=k的元素
        while (k > 1 && greater(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        // 取得k节点的两个子节点中更大一点的那个节点的下标
        while (2 * k <= size) {
            int idx = 2 * k;
            if (idx < size && greater(idx + 1, idx)) {
                idx--;
            }
            // 交换下沉节点和那个子节点的元素
            swap(k, idx);
            k = idx;
        }
    }

    private void swap(int i, int j) {
        heap[i] ^= heap[j];
        heap[j] ^= heap[i];
        heap[i] ^= heap[j];
    }

    private boolean greater(int i, int j) {
        return heap[i] > heap[j];
    }
}
