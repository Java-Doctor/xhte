package top.xhte.dsa.linkedlist;

/**
 * 约瑟夫问题
 * 使用单向链表解决
 * 一个圆圈周围有 n 个小屁孩，并且围绕圆圈每隔 m 个小屁孩进行一次处决，直到没有小屁孩在 n 次迭代中幸存下来
 *
 * @author XHTE
 * @create 2024-04-19
 */
public class JosephRingLinkedList {

    /**
     * 初始化第一个节点
     */
    private Node firstNode;

    /**
     * 初始化约瑟夫环
     * @param personNum 人数
     */
    public void initJosephRing(int personNum) {
        if (personNum < 1) {
            System.out.println("人数必须大于 1！");
            return;
        }
        Node curNode = null;
        for (int i = 1; i < personNum + 1; i++) {
            Node node = new Node(i);
            if (i == 1) {
                firstNode = node;
                firstNode.next = firstNode;
                curNode = firstNode;
            } else if (i == personNum) {
                curNode.next = node;
                node.next = firstNode;
            } else {
                curNode.next = node;
                curNode = node;
            }
        }
    }

    /**
     * 打印约瑟夫环
     */
    public void printJosephRing() {
        if (firstNode == null) {
            System.out.println("约瑟夫环为空！");
        }
        Node curNode = firstNode;
        if (curNode.next == curNode) {
            System.out.println(curNode);
            return;
        }
        while (true) {
            System.out.println(curNode);
            curNode = curNode.next;
            if (curNode == firstNode) {
                break;
            }
        }
    }

    /**
     * 对每次间隔的人进行枪决
     */
    public void executionByGunshot(int personNo, int intervalNum) {
        if (intervalNum < 1) {
            System.out.println("约瑟夫环枪决间隔人数不能少于 1！");
            return;
        }
        if (firstNode == null) {
            System.out.println("请先生成约瑟夫环！");
            return;
        }
        Node headNode = firstNode;
        Node curNode = null;
        while(headNode.next.no != personNo) {
            // 先找到开始的前一个小屁孩的编号
            headNode = headNode.next;
        }

        while (true) {

            curNode = headNode;
            if (curNode.next != curNode) {
                // 找到编号前一个之后 从编号前一个的人开始报数
                for (int i = 1; i < intervalNum; i++) {
                    curNode = curNode.next;
                }
                System.out.println("被枪毙的小屁孩编号为：" + curNode.next.no);
                headNode = curNode;
                curNode.next = curNode.next.next;

            } else {
                System.out.println("被枪毙的小屁孩编号为：" + curNode.no);
                break;
            }

        }
    }

    public static void main(String[] args) {
        JosephRingLinkedList josephRingLinkedList = new JosephRingLinkedList();
        josephRingLinkedList.initJosephRing(100);
        josephRingLinkedList.printJosephRing();
        josephRingLinkedList.executionByGunshot(2, 5);
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
            return "小屁孩：" + no;
        }
    }

}
