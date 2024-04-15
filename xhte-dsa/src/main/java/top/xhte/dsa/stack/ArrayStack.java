package top.xhte.dsa.stack;

import java.util.Arrays;

/**
 * 数组模拟栈
 *
 * @author XHTE
 * @create 2024-04-14 22:10
 */
public class ArrayStack {

    /**
     * 栈的最大长度
     */
    private final int MAX_SIZE;

    /**
     * 栈的数组
     */
    private int[] stack;

    /**
     * 栈顶的位置
     */
    private int top;

    public ArrayStack(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        this.stack = new int[MAX_SIZE];
        this.top = -1;
    }

    /**
     * 如果栈顶的索引是数组最大长度 - 1，那么就是满的
     * @return true 栈已满 false 栈未满
     */
    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    /**
     * 如果栈顶的索引是 -1 那么就是空的
     * @return true 栈为空 false 栈非空
     */
    public boolean isEmpty() {
        return top == - 1;
    }

    /**
     * 入栈方法
     * @param item 入栈元素
     */
    public void push(int item) {
        if (isFull()) {
            System.out.println("栈内存已满！");
            return;
        }
        stack[++top] = item;
        list();
    }

    /**
     * 出栈方法
     * @return 出栈元素
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈中无数据！");
            return -1;
        }
        int item = stack[top--];
        list();
        return item;
    }

    /**
     * 打印栈元素
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈中无数据！");
        }
        System.out.println("栈内元素为：" + Arrays.toString(stack));
    }

    public static void main(String[] args) {
        // 创建栈
        ArrayStack arrayStack = new ArrayStack(3);
        // 出栈
        System.out.println("出栈元素为：" + arrayStack.pop());
        // 入栈
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        // 出栈
        System.out.println("出栈元素为：" + arrayStack.pop());
        System.out.println("出栈元素为：" + arrayStack.pop());
        System.out.println("出栈元素为：" + arrayStack.pop());
        System.out.println("出栈元素为：" + arrayStack.pop());
    }

}
