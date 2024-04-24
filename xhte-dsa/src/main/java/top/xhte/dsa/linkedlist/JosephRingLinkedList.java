package top.xhte.dsa.linkedlist;

/**
 * 约瑟夫问题
 * 使用单向链表解决
 * 设编号为1、2、……n 的 n 个人围坐一圈，约定编号为 k(1<=k<=n) 的人从 1 开始报数
 * 数到 m 的那个人出列，它的下一位又从 1 开始报数，数到 m 的那个人又出列，依次类推
 * 直到所有人出列为止，由此产生一个出队编号的序列
 *
 * @author XHTE
 * @create 2024-04-19
 */
public class JosephRingLinkedList {

    /**
     * 初始化第一个节点 不是头节点
     */
    private Node firstNode;

    /**
     * 环内人数
     */
    private int count;

    /**
     * 初始化约瑟夫环
     *
     * @param personNum 人数
     */
    public void initJosephRing(int personNum) {
        if (personNum < 1) {
            System.out.println("人数必须大于 1！");
            return;
        }
        // 当前节点为 null
        Node curNode = null;
        for (int i = 1; i < personNum + 1; i++) {
            Node node = new Node(i);
            if (i == 1) {
                // 如果是第一个，当前节点设置为第一个节点
                firstNode = node;
                firstNode.next = firstNode;
                curNode = firstNode;
            } else if (i == personNum) {
                // 如果是最后一个，最后一个节点指向第一个节点
                curNode.next = node;
                node.next = firstNode;
            } else {
                // 其他情况就是当前节点的下一个节点指向循环中的节点
                curNode.next = node;
                // 然后当前节点指向循环中的节点
                curNode = node;
            }
            count++;
        }
    }

    /**
     * 打印约瑟夫环
     */
    public void printJosephRing() {
        if (firstNode == null) {
            System.out.println("约瑟夫环为空！");
        }
        // 设置当前节点等于第一个节点
        Node curNode = firstNode;
        // 如果当前节点的下一个节点是第一个节点
        // 说明环中只有一个节点
        // 那么直接打印当前节点即可
        if (curNode.next == curNode) {
            System.out.println(curNode);
            return;
        }
        do {
            // 除了第一个节点后的节点
            // 先打印，然后节点往后移动
            System.out.println(curNode);
            curNode = curNode.next;
            // 当节点移动到第一个节点的时候结束循环
        } while (curNode != firstNode);
    }

    /**
     * 人员按照传入参数出列
     *
     * @param personNo    人员编号
     * @param intervalNum 报数间隔数
     */
    public void personExitQueue(int personNo, int intervalNum) {
        if (intervalNum < 1) {
            System.out.println("约瑟夫环报数间隔人数不能少于 1！");
            return;
        }
        if (personNo > count || personNo < 1) {
            System.out.println("约瑟夫环开始人员编号不能小于 1 且不能大于 总人数！");
            return;
        }
        if (firstNode == null) {
            System.out.println("请先生成约瑟夫环！");
            return;
        }
        // 假设头节点是第一个节点
        Node headNode = firstNode;
        // 假设当前节点为 null
        Node curNode = null;

        // 头节点是会一直变动
        // 如果头节点的下一个节点的编号和开始人员编号相等
        // 那么就从头节点开始报数，只有第一次进来需要
        while (headNode.next.no != personNo) {
            // 先找到开始的前一个人员的编号，目的是方便修改前一个人员的 next
            headNode = headNode.next;
        }

        while (true) {
            // 首先当前节点指向头节点
            curNode = headNode;
            if (curNode.next != curNode) {
                // 如果当前节点的下一个节点不等于当前节点
                // 找到编号前一个之后，从编号前一个的人开始报数
                for (int i = 1; i < intervalNum; i++) {
                    curNode = curNode.next;
                }
                System.out.println("报数的人员编号为：" + curNode.next.no);
                // 头节点变成当前节点
                headNode = curNode;
                // 当前节点的下一个节点设置成当前节点的下下个节点
                curNode.next = curNode.next.next;
            } else {
                // 如果当前节点的下一个节点等于当前节点，直接出列并且结束
                System.out.println("报数的人员编号为：" + curNode.no);
                break;
            }

        }
    }

    public static void main(String[] args) {
        // 创建约瑟夫环链表
        JosephRingLinkedList josephRingLinkedList = new JosephRingLinkedList();
        // 生成约瑟夫环
        josephRingLinkedList.initJosephRing(100);
        // 打印约瑟夫环
        josephRingLinkedList.printJosephRing();
        // 开始报数并打印出列人员
        josephRingLinkedList.personExitQueue(2, 5);
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
        private final int no;

        /**
         * 下一个节点的地址信息
         */
        private Node next;

        public Node(int no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "人员编号：" + no;
        }
    }

}
