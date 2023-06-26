

package Linkedlist;



public class Add {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next = null;

        }
    }
    public static Node head;
    public static Node tail;

    public static int size;

    public void addFirst(int data){
        //step = create a node 
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step2 :
        newNode.next = head;

        head = newNode;

    }
    public void print(){
        if(head == null){
            System.out.println("empty");
        }

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");

    }
    public void addMiddle(int idx,int data){
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i =0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next=newNode;

    }
    public void addlast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    // remove first
    public int removeFirst(){
        if(size ==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
               
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val; 

    }
    public int removeLast(){
        if(size ==0){
            System.out.println("empty");
            return Integer.MIN_VALUE;

        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size =0;
            return val;
        }
        Node prev = head;
        for(int i =0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val; 
    }

    public int itrSearch(int key){
        Node temp = head;
        int i =0;

        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;

        }
        //key not found
        return -1;
    }
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        head = prev;
    }

    public void deleteNthfromEnd(int n){
        int s = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            s++;
        }

        if(n == s){
            head = head.next;// remove First

        }

        //sz-n

        int i = 1;
        int iToFind = s-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

          
    
         


    }

    //ll is palindrom

    //slow  fast approach....
    public Node findMid(Node head){
        Node slow = head ;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2

        }
        return slow;


    }
    
    public boolean checkpalindrome(){
        if(head == null  || head.next != null){
            return true;
        }
        Node midNode = findMid(head);

        // step 2 - reverse @nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;    
        }

        Node right = prev; // right head
        Node left = head;

        // to check left half & right half

        while(right != null){
            if(left.data != right.data){
                return false;

            }
            left = left.next; 
            right = right.next;
        }
        return true;



    }
    public static boolean isCycle(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }

        }
        return false;
    }
    public static void removecycle(){
        //detect
        Node fast = head;
        Node slow = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }


        //find meeting point
        slow = head;
        Node prev = null;

        while(slow != fast){

            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle 
        prev.next =null;
    }


     

    public static void main(String [] args){
        head = new Node(1);
        
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;        
        System.out.println(isCycle());
        removecycle();
        System.out.println(isCycle());
    }
}