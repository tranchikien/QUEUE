/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QUEUE;

/**
 *
 * @author CHI KIEN
 */
public class Queue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;
    private int currentSize;

    public Queue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public void enqueue(int element) {
        if (currentSize == maxSize) {
            System.out.println("Queue is full. Cannot enqueue " + element);
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = element;
        currentSize++;
    }

    public int dequeue() {
        if (currentSize == 0) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int element = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return element;
    }

    public int peek() {
        if (currentSize == 0) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
