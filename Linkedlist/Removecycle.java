public class Removecycle {
    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;

            }
        }
        if(cycle == false) return;

        // find meeting point
        slow = head;
        mode prev = null;

        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast= fast.next;

        }
        prev.next = null;

        

    }
    
}
