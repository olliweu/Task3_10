package com.company;

import com.company.util.LinkedBlockedQueueUtils;
import com.company.util.LinkedListQueueUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

public class BubbleSortTest {
    @Test
    public void testNormalLinkedListQueue() throws Exception {
        BubbleSort bubbleSort = new BubbleSort();
        int[] queueArr = {3, 8, 4, 2, 0};
        LinkedListQueue<Integer> queue = LinkedListQueueUtils.intArrayToQueue(queueArr);

        bubbleSort.sort(queue);

        int[] queueResultArr = LinkedListQueueUtils.intQueueToArray(queue);
        int[] expectedResult = {0, 2, 3, 4, 8};

        Assert.assertArrayEquals(expectedResult, queueResultArr);
    }

    @Test
    public void testNormalStandardQueue() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] queueArr = {3, 8, 4, 2, 0};
        LinkedBlockingQueue<Integer> queue = LinkedBlockedQueueUtils.intArrayToQueue(queueArr);

        bubbleSort.sort(queue);

        int[] queueResultArr = LinkedBlockedQueueUtils.intQueueToArray(queue);
        int[] expectedResult = {0, 2, 3, 4, 8};

        Assert.assertArrayEquals(expectedResult, queueResultArr);
    }

    @Test
    public void testBigQueue() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] queueArr = {3, 8, 4, 2, 0, 12, 4, 4, 5, 6, 54, 2, 3, 4, 5};
        LinkedBlockingQueue<Integer> queue = LinkedBlockedQueueUtils.intArrayToQueue(queueArr);

        bubbleSort.sort(queue);

        int[] queueResultArr = LinkedBlockedQueueUtils.intQueueToArray(queue);
        int[] expectedResult = {0, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 8, 12, 54};

        Assert.assertArrayEquals(expectedResult, queueResultArr);
    }

    @Test
    public void testBigNumQueue() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] queueArr = {7807, 3784893, 46748, 33678437, 3783};
        LinkedBlockingQueue<Integer> queue = LinkedBlockedQueueUtils.intArrayToQueue(queueArr);

        bubbleSort.sort(queue);

        int[] queueResultArr = LinkedBlockedQueueUtils.intQueueToArray(queue);
        int[] expectedResult = {3783, 7807, 46748, 3784893, 33678437};

        Assert.assertArrayEquals(expectedResult, queueResultArr);
    }

    @Test
    public void testSameNumsQueue() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] queueArr = {3, 3, 3, 3, 0, 0, 0, 0};
        LinkedBlockingQueue<Integer> queue = LinkedBlockedQueueUtils.intArrayToQueue(queueArr);

        bubbleSort.sort(queue);

        int[] queueResultArr = LinkedBlockedQueueUtils.intQueueToArray(queue);
        int[] expectedResult = {0, 0, 0, 0, 3, 3, 3, 3};

        Assert.assertArrayEquals(expectedResult, queueResultArr);
    }
}