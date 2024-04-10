package top.xhte.dsa.linked.list.single;

/**
 * 模拟链表的节点
 *
 * @author XHTE
 * @create 2024/4/10
 */

import lombok.Data;

@Data
public class Node {

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
    private Node nextNode;

    public Node(int no, String name, int age, Node nextNode) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.nextNode = nextNode;
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
