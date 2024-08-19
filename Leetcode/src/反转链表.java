import java.util.ArrayDeque;
import java.util.Deque;

public class 反转链表 {


    static class NodeTemp {
        int value;
        NodeTemp next;
        NodeTemp(int value, NodeTemp next){
            this.value = value;
            this.next = next;
        }

        // public void setNext(NodeTemp next) {
        //     this.next = next;
        // }
        //
        // public void setValue(int value) {
        //     this.value = value;
        // }

        static void reverse(NodeTemp node){
            if(node == null || node.next == null){
                return;
            }
            NodeTemp next = node.next;
            reverse(next);
            next.next = node;
            node.next = null;
        }

        static void display(NodeTemp node){
            if(node == null) return;
            System.out.println(node.value);
            if(node.next != null){
                display(node.next);
            }
        }
    }




    public static void main(String[] args) {
        NodeTemp node5 = new NodeTemp(5,null);
        NodeTemp node4 = new NodeTemp(4,node5);
        NodeTemp node3 = new NodeTemp(3,node4);
        NodeTemp node2 = new NodeTemp(2,node3);
        NodeTemp node1 = new NodeTemp(1,node2);
        NodeTemp.display(node1);

        Deque deque = new ArrayDeque();
        deque.removeLast();
        deque.getLast();

        System.out.println();
        NodeTemp.reverse(node1);
        NodeTemp.display(node5);

        //空链表 值有相同的链表 长度5000左右的链表

        // 反转链表 solution = new 反转链表();
    }
}