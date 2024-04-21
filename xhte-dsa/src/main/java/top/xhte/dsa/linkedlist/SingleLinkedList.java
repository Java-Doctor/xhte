package top.xhte.dsa.linkedlist;

import cn.hutool.core.util.ObjectUtil;

/**
 * 使用 Node 模拟单向链表
 *
 * @author XHTE
 * @create 2024/4/10
 */
public class SingleLinkedList {

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
            if (curNode.next != null) {
                // 如果下一个节点不为空的话，那么指针往后移
                curNode = curNode.next;
            } else {
                // 如果下一个节点是空，那就把当前节点的下一个节点设置成要新增的节点
                curNode.next = node;
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
                    curNode.next = node;
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
                    curNode.next = curNode.next.next;
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

    /**
     * 获取列表的有效节点个数
     */
    public int count() {
        int count = 0;
        Node curNode = headNode;
        while (true) {
            if (ObjectUtil.isEmpty(curNode.next)) {
                // 如果指针指向的节点下一个节点是空的，那么结束
                break;
            } else {
                // 如果指针指向的下一个节点的地址不为空 那么指针往后移
                count++;
                curNode = curNode.next;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node1 = new Node(1, "胡桐", 25);
        Node node2 = new Node(2, "小王", 18);
        Node node3 = new Node(3, "小王", 18);
        Node node4 = new Node(4, "迪迪", 30);
        Node node5 = new Node(5, "未知", 22);
        Node node6 = new Node(1, "小胡", 18);
        System.out.println("====================> 初始数据");

        // 默认添加数据到结尾
        // singleLinkedList.add(node1);
        // singleLinkedList.add(node2);
        // singleLinkedList.add(node3);
        // singleLinkedList.add(node4);

        // 按序添加数据
        singleLinkedList.addIntroduction(node1);
        singleLinkedList.addIntroduction(node4);
        singleLinkedList.addIntroduction(node2);
        singleLinkedList.addIntroduction(node3);

        singleLinkedList.list();

        System.out.println("====================> 删除后的数据");

        singleLinkedList.remove(node3);
        singleLinkedList.remove(node4);
        singleLinkedList.remove(node2);
        singleLinkedList.remove(node5);
        singleLinkedList.list();
        System.out.println("====================> 修改后的数据");
        singleLinkedList.update(node6);
        singleLinkedList.list();

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

