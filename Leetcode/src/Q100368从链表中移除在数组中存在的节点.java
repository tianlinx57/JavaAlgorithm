import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q100368从链表中移除在数组中存在的节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i:nums){
            hashSet.add(i);
        }
        if (head == null) return null;

        ListNode pointer = head.next;
        ListNode before = head;

        while (pointer!=null){
            if (!hashSet.contains(pointer.val)){
                before.next = pointer;
                before = before.next;
            }
            pointer = pointer.next;
        }
        before.next = null;
        if(hashSet.contains(head.val)){
            head = head.next;
        }
        return head;
    }


    public static void main(String[] args) {
        Q100368从链表中移除在数组中存在的节点 solution = new Q100368从链表中移除在数组中存在的节点();
        // System.out.println(solution.numberOfSubmatrices(new char[][]{{'X','Y','.'},{'Y','.','.'}}));
        System.out.println(solution.modifiedList(new int[]{1,2,3},null));
    }
}