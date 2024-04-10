package top.xhte.dsa.queue;

import cn.hutool.json.JSONUtil;

import java.util.Scanner;

/**
 * 一个环形数组模拟的队列，环形就是相当于数组的首尾相连接，能够无限添加和获取数据
 *
 * @author XHTE
 * @create 2024/4/10
 */
public class ArrayQueue {

    /**
     * 队列最大长度
     */
    private final int maxSize;
    /**
     * 头指针
     */
    private int front;
    /**
     * 尾指针
     */
    private int rear;
    /**
     * 队列存放的容器：数据
     */
    private int[] arr;

    /**
     * 初始化
     *
     * @param maxSize 队列最大长度
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 如果 尾指针 = (队列最大长度 - 1)，那么就判定为队列已满
     *
     * @return true 队列已满 false 队列未满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 如果 头指针 = 尾指针，那么就判定为队列为空
     *
     * @return true 队列为空 false 队列非空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加元素操作 数组已满则不能添加
     * 未满可以在当前尾指针位置添加元素，
     * 然后 尾指针 + 1
     */
    public void addQueue(int item) {
        if (isFull()) {
            System.out.println("数组已满！");
            return;
        }
        arr[rear] = item;
        rear++;
    }

    /**
     * 获取元素操作 数组为空则不能获取
     * 非空可以在当前头指针位置获取元素，
     * 然后 头指针 + 1
     */
    public void decreaseQueue() {
        if (isEmpty()) {
            System.out.println("数组是空的！");
            return;
        }
        System.out.println("拿到了队列数据：" + arr[front]);
        arr[front] = 0;
        front++;
    }

    /**
     * 获取队列信息，直接打印
     */
    public void getQueue() {
        System.out.println(JSONUtil.toJsonStr(arr));
        System.out.println("front：" + "「" + front + "」");
        System.out.println("rear：" + "「" + rear + "」");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayQueue arrayQueue = new ArrayQueue(3);

        while (true) {
            System.out.println("「a」入队");
            System.out.println("「d」出队");
            System.out.println("「g」查看所有队列元素");
            System.out.println("「e」退出");
            String next = scanner.next();
            switch (next) {
                case "a":
                    int element = scanner.nextInt();
                    arrayQueue.addQueue(element);
                    break;
                case "d":
                    arrayQueue.decreaseQueue();
                    break;
                case "g":
                    arrayQueue.getQueue();
                    break;
                case "e":
                    arrayQueue.arr = new int[arrayQueue.maxSize];
                    break;
                default:
                    System.out.println("指令不存在！");
            }
        }
    }
}