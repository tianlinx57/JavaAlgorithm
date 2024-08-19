import java.util.HashMap;
import java.util.Map;

public class 环形链表 {
    // public ListNode detectCycle(ListNode head) {
    //     // Step 1: Initialize slow and fast pointers
    //     ListNode slow = head;
    //     ListNode fast = head;
    //
    //     // Step 2: Move the pointers until they meet or there's no cycle
    //     while (fast != null && fast.next != null) {
    //         slow = slow.next;
    //         fast = fast.next.next;
    //
    //         // Check if the pointers meet
    //         if (slow == fast) {
    //             // Step 3: Reset slow pointer to head and move both pointers one step each
    //             slow = head;
    //             while (slow != fast) {
    //                 slow = slow.next;
    //                 fast = fast.next;
    //             }
    //
    //             // Step 4: The meeting point is the entrance to the cycle
    //             return slow;
    //         }
    //     }
    //
    //     // If no cycle found, return null
    //     return null;
    // }
    public ListNode detectCycle(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        ListNode pointer = head;
        int index = 0;
        while (pointer != null){
            if(map.containsKey(pointer)){
                return pointer;
            }
            map.put(pointer,index);
            index++;
            pointer=pointer.next;
        }
        return null;
    }

    // A utility function to create a ListNode from an array and form a cycle
    public static ListNode createLinkedListWithCycle(int[] values, int pos) {
        ListNode head = null;
        ListNode prev = null;
        ListNode cycleNode = null;

        for (int i = 0; i < values.length; i++) {
            ListNode newNode = new ListNode(values[i]);
            if (prev != null) {
                prev.next = newNode;
            } else {
                head = newNode;
            }

            if (i == pos) {
                cycleNode = newNode;
            }

            prev = newNode;
        }

        // Create a cycle if pos >= 0
        if (cycleNode != null && prev != null) {
            prev.next = cycleNode;
        }

        return head;
    }

    public static void main(String[] args) {
        环形链表 solution = new 环形链表();

        // Example 1:
        // Create linked list with values [3, 2, 0, -4] and a cycle at index 1
        int[] values1 = {3, 2, 0, -4};
        int pos1 = 1;
        ListNode head1 = createLinkedListWithCycle(values1, pos1);
        ListNode cycleNode1 = solution.detectCycle(head1);
        if (cycleNode1 != null) {
            System.out.println("Cycle starts at node with value: " + cycleNode1.val);
        } else {
            System.out.println("No cycle detected");
        }

        // Example 2:
        // Create linked list with values [1, 2] and a cycle at index 0
        int[] values2 = {1, 2};
        int pos2 = 0;
        ListNode head2 = createLinkedListWithCycle(values2, pos2);
        ListNode cycleNode2 = solution.detectCycle(head2);
        if (cycleNode2 != null) {
            System.out.println("Cycle starts at node with value: " + cycleNode2.val);
        } else {
            System.out.println("No cycle detected");
        }

        // Example 3:
        // Create linked list with values [1] and no cycle
        int[] values3 = {1};
        int pos3 = -1;
        ListNode head3 = createLinkedListWithCycle(values3, pos3);
        ListNode cycleNode3 = solution.detectCycle(head3);
        if (cycleNode3 != null) {
            System.out.println("Cycle starts at node with value: " + cycleNode3.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}