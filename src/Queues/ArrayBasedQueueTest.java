package queues;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayBasedQueueTest {

    @Test
    public void enqueueDeque() throws Exception {
        // println added only for demonstration
        ArrayBasedQueue<Integer> queue = new ArrayBasedQueue(5);
        queue.enqueue(1);
        assertEquals(new Integer(1), queue.getFirst());

        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(new Integer(1), queue.dequeue());

        System.out.println(queue); //Notice the first element of the array is null
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue); //Notice the first element is at position 1 and the last at 0

        assertEquals(new Integer(2), queue.dequeue());
        assertEquals(new Integer(3), queue.dequeue());
        assertEquals(new Integer(4), queue.dequeue());
        assertEquals(new Integer(5), queue.dequeue());
        assertEquals(new Integer(6), queue.dequeue());
        assertNull(queue.dequeue());
        assertTrue(queue.isEmpty());
    }


//    @Test(expected = QueueIsFullException.class)
//    public void enqueueBeyondMaxSize() throws Exception {
//        ArrayBasedQueue<Integer> queue = new ArrayBasedQueue(3);
//        queue.enqueue(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//        queue.enqueue(4);
//    }

    @Test(expected = NullPointerException.class)
    public void enqueueNullElement() throws Exception {
        ArrayBasedQueue<Integer> queue = new ArrayBasedQueue();
        queue.enqueue(null);
    }

    @Test
    public void size() throws Exception {
        ArrayBasedQueue<Integer> queue = new ArrayBasedQueue(5);
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());

        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        assertEquals(2, queue.size());

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        assertEquals(5, queue.size());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertEquals(1, queue.size());

        queue.dequeue();
        assertEquals(0, queue.size());
    }

}

