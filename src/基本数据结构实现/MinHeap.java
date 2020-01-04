package 基本数据结构实现;

import java.util.NoSuchElementException;

public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array cannot be null or emoty");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    //!!!!!
    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {  //full tree最后一层有size / 2个node，那么size/2-1是最下面一个有孩子的node
            percolateDown(i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public int peek() {
        if (size == 0) {
            return -1;
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        int res = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return res;
    }

    public void offer(int ele) {
        if (size == array.length) {
            int[] newArray = new int[array.length * 2];
            //copy array to newArray
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array[size] = ele;
            size++;
            percolateUp(size - 1);
        }
    }

    public int update(int idx, int ele) {
        if (idx < 0 || idx > size - 1) {
            throw new ArrayIndexOutOfBoundsException("invalid index range");
        }
        int res = array[idx];
        array[idx] = ele;
        if (res > ele) {
            percolateUp(idx);
        } else {
            percolateDown(idx);
        }
        return res;
    }


    /**helper functin **/
    private void percolateDown(int idx) {
        while (idx < size) {
            int smallestIdx = idx;
            int lcidx = idx * 2 + 1;
            int rcidx = idx * 2 + 2;
            if(lcidx < size && array[lcidx] < array[smallestIdx]) {
                smallestIdx = rcidx;
            }
            if (rcidx < size && array[rcidx] < array[smallestIdx]) {
                smallestIdx = rcidx;
            }
            if (smallestIdx == idx) {
                break;
            }
            int temp = array[idx];
            array[idx] = array[smallestIdx];
            array[smallestIdx] = temp;

            //update idx
            idx = smallestIdx;
        }
    }

    private void percolateUp(int idx) {
        while (idx > 0) {
            int parentidx = (idx - 1) / 2;
            if (array[parentidx] > array[idx]) {
                int temp = array[idx];
                array[idx] = array[parentidx];
                array[parentidx] = temp;
            } else {
                break;
            }
            //update idx
            idx = parentidx;
        }
    }

}
