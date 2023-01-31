package com.company.util;

import com.company.LinkedListQueue;

public class LinkedListQueueUtils {

    public static LinkedListQueue<Integer> intArrayToQueue(int[] array) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int j : array) {
            queue.addElement(j);
        }
        return queue;
    }

    public static int[] intQueueToArray(LinkedListQueue<Integer> queue) throws Exception {
        int[] array = new int[queue.count()];
        for (int i = 0; i < array.length; i++) {
            array[i] = queue.removeElement();
        }
        return array;
    }
}