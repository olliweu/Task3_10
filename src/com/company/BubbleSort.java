package com.company;

import java.util.concurrent.LinkedBlockingQueue;

public class BubbleSort {
    public void sort(LinkedBlockingQueue<Integer> queue) {
        for (int j = 0; j < queue.size() - 1; j++) {
            int tmp = queue.remove();

            for (int i = 0; i < queue.size() - j; i++) {
                int currElement = queue.remove();

                if (currElement > tmp) {
                    queue.add(tmp);
                    tmp = currElement;
                } else {
                    queue.add(currElement);
                }
            }

            queue.add(tmp);

            for (int k = 0; k < j; k++) {
                queue.add(queue.remove());
            }
        }
    }

    public void sort(LinkedListQueue<Integer> queue) throws Exception {
        for (int j = 0; j < queue.count() - 1; j++) {
            int tmp = queue.removeElement();

            for (int i = 0; i < queue.count() - j; i++) {
                int currElement = queue.removeElement();

                if (currElement > tmp) {
                    queue.addElement(tmp);
                    tmp = currElement;
                } else {
                    queue.addElement(currElement);
                }
            }

            queue.addElement(tmp);

            for (int k = 0; k < j; k++) {
                queue.addElement(queue.removeElement());
            }
        }
    }
}
