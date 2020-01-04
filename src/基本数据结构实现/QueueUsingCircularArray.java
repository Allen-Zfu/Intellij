package 基本数据结构实现;

public class QueueUsingCircularArray {
    int head;
    int tail;
    int size;
    Integer[] array;
    public QueueUsingCircularArray(int capacity) {
        array = new Integer[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    //insert at tail
    public boolean offer(Integer ele) {
        //case 1
        if (size == array.length) {    //reach capacity
            return false;
        }
        //case 2 : insert at tail
        array[tail] = ele;
        tail = tail + 1 == array.length ? 0 : tail + 1;  //超过capacity，重头开始
        size++;
        return true;
    }

    //peek at head
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer res = array[head];
        head = head + 1 == array.length ? 0 : head + 1;
        size--;
        return res;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
