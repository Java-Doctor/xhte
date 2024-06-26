package top.xhte.dsa.linkedlist;

import cn.hutool.core.util.ObjectUtil;

/**
 * 使用 Node 模拟双向链表
 *
 * @author XHTE
 * @create 2024/4/12
 */
public class DoubleLinkedList {

    /**
     * 初始化头节点 可以不需要头节点
     */
    private final Node headNode = new Node(0, "", 0);

    /**
     * 添加节点 默认往最后面添加
     *
     * @param node 添加的节点
     */
    public void add(Node node) {
        // 指针指向头节点
        Node curNode = headNode;

        while (true) {
            if (ObjectUtil.isNotEmpty(curNode.next)) {
                // 如果下一个节点不为空的话，那么指针往后移
                curNode = curNode.next;
            } else {
                // 如果下一个节点是空，那就把当前节点的下一个节点设置成要新增的节点
                // 要新增节点的上一个节点设置成当前节点
                curNode.next = node;
                node.pre = curNode;
                break;
            }
        }
    }

    /**
     * 添加节点 按照 no 顺序
     * 要拿到前一个节点 去比后一个节点
     * 不然没有前一个节点 就断掉了
     *
     * @param node 添加的节点
     */
    public void addIntroduction(Node node) {
        // 指针指向头节点
        Node curNode = headNode;

        while (true) {
            if (ObjectUtil.isNotEmpty(curNode.next)) {
                if (curNode.next.no > node.no) {
                    // 如果下一个节点的 no 大于 要新增节点的 no，
                    // 那么将新增节点的下一个节点设置成当前节点的下一个节点
                    // 当前节点的下一个节点设置成要新增的节点
                    node.next = curNode.next;
                    node.pre = curNode;
                    curNode.next = node;
                    curNode.next.pre = node;
                    break;
                } else if (curNode.next.no == node.no) {
                    // 如果编号相同 那么不允许重复添加
                    System.out.println(node.no + "编号已存在");
                    break;
                } else {
                    // 如果下个节点的 no 小于要添加节点的 no，那么指针往后移
                    curNode = curNode.next;
                }
            } else {
                // 如果下一个节点为空，那么直接把要新增的节点设置成当前节点的下一个节点
                curNode.next = node;
                node.pre = curNode;
                break;
            }
        }
    }

    /**
     * 删除节点
     */
    public void remove(Node node) {
        Node curNode = headNode;
        while (true) {
            if (ObjectUtil.isEmpty(curNode.next)) {
                // 如果指针指向的节点下一个节点是空的，那么结束
                System.out.println("未找到需要删除的节点：" + "「" + node + "」");
                break;
            } else {
                if (curNode.next.no == node.no) {
                    // 如果下一个节点的编号等于要删除节点的编号 那么将当前节点的下一个节点设置成下一个节点的下一个节点
                    Node temp = curNode.next;
                    curNode.next = temp.next;
                    if (ObjectUtil.isNotEmpty(temp.next)) {
                        temp.next.pre = curNode;
                    }
                    break;
                } else {
                    // 如果不相等，那么指针往后移
                    curNode = curNode.next;
                }
            }
        }
    }

    /**
     * 修改节点
     */
    public void update(Node node) {
        Node curNode = headNode;
        while (true) {
            if (ObjectUtil.isEmpty(curNode.next)) {
                // 如果指针指向的节点下一个节点是空的，那么结束
                System.out.println("未找到需要修改的节点：" + "「" + node + "」");
                break;
            } else {
                if (curNode.next.no == node.no) {
                    // 如果指针指向的下一个节点的地址不为空 那么删除下一个节点
                    curNode.next.name = node.name;
                    curNode.next.age = node.age;
                    break;
                } else {
                    // 下一个节点不等于当前节点，那么指针往后移
                    curNode = curNode.next;
                }
            }
        }
    }

    /**
     * 打印列表
     */
    public void list() {
        Node curNode = headNode;
        while (true) {
            if (ObjectUtil.isEmpty(curNode.next)) {
                // 如果指针指向的节点下一个节点是空的，那么结束
                break;
            } else {
                // 如果指针指向的下一个节点的地址不为空 那么指针往后移
                curNode = curNode.next;
                System.out.println(curNode);
            }
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleLinkedList.Node node1 = new DoubleLinkedList.Node(1, "胡桐", 25);
        DoubleLinkedList.Node node2 = new DoubleLinkedList.Node(2, "小王", 18);
        DoubleLinkedList.Node node3 = new DoubleLinkedList.Node(3, "小王", 18);
        DoubleLinkedList.Node node4 = new DoubleLinkedList.Node(4, "迪迪", 30);
        DoubleLinkedList.Node node5 = new DoubleLinkedList.Node(5, "未知", 22);
        DoubleLinkedList.Node node6 = new DoubleLinkedList.Node(1, "小胡", 18);
        System.out.println("====================> 初始数据");

        // 默认添加数据到结尾
        // doubleLinkedList.add(node1);
        // doubleLinkedList.add(node2);
        // doubleLinkedList.add(node3);
        // doubleLinkedList.add(node4);

        // 按序添加数据
        doubleLinkedList.addIntroduction(node1);
        doubleLinkedList.addIntroduction(node4);
        doubleLinkedList.addIntroduction(node2);
        doubleLinkedList.addIntroduction(node3);

        doubleLinkedList.list();

        System.out.println("====================> 删除后的数据");

        doubleLinkedList.remove(node3);
        doubleLinkedList.remove(node4);
        doubleLinkedList.remove(node2);
        doubleLinkedList.remove(node5);
        doubleLinkedList.list();
        System.out.println("====================> 修改后的数据");
        doubleLinkedList.update(node6);
        doubleLinkedList.list();


    }

    /**
     * 模拟链表的节点
     *
     * @author XHTE
     * @create 2024/4/10
     */
    public static class Node {

        /**
         * 编号
         */
        private int no;
        /**
         * 名称
         */
        private String name;
        /**
         * 年龄
         */
        private int age;
        /**
         * 上一个节点的地址信息
         */
        private Node pre;
        /**
         * 下一个节点的地址信息
         */
        private Node next;

        public Node(int no, String name, int age) {
            this.no = no;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

