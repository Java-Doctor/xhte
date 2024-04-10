package top.xhte.dsa.linked.list.single;

import cn.hutool.core.util.ObjectUtil;

/**
 * 使用 Node 模拟单向链表
 *
 * @author XHTE
 * @create 2024/4/10
 */
public class SingleLinkedList {

    /**
     * 初始化头节点
     */
    private final Node headNode = new Node(1, "", 0, null);

    /**
     * 添加数据
     *
     * @param node 添加的节点
     */
    public void add(Node node) {
        // 指针指向头节点
        Node tempNode = headNode;
        while (true) {
            if (ObjectUtil.isEmpty(tempNode.getNextNode())) {
                // 如果指针指向的节点下一个节点是空的，那么该指针的下一个节点地址就是新增的节点
                tempNode.setNextNode(node);
                break;
            } else {
                // 如果指针指向的下一个节点的地址不为空 那么继续向后移动指针
                tempNode = tempNode.getNextNode();
            }
        }
    }

    /**
     * 打印列表
     */
    public void list() {
        Node tempNode = headNode;
        while (true) {
            if (ObjectUtil.isEmpty(tempNode.getNextNode())) {
                // 如果指针指向的节点下一个节点是空的，那么结束
                break;
            } else {
                // 如果指针指向的下一个节点的地址不为空 那么继续向后移动指针
                tempNode = tempNode.getNextNode();
                System.out.println(tempNode);
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node1 = new Node(2, "胡桐", 25, null);
        Node node2 = new Node(3, "小王", 18, null);
        Node node3 = new Node(4, "迪迪", 30, null);
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.list();
    }

}
