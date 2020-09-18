package hello;
import java.util.*;

 
public class codeLab2 {
	
	public ListNode removeNth(ListNode head,int n) {
		//we first create a pre node which points to head;
	    ListNode pre = new ListNode(0);
	    pre.next = head;
	    ListNode first = pre;
	    ListNode second = pre;
	    //then we put the first node nth nodes apart from the second.
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return pre.next;
		
	}
	//------------------------------------------------------------------------------------
	public ListNode removeDu(ListNode head) {
	     ListNode cur = head;
	        while(cur!=null&&cur.next!=null){
	            if(cur.val==cur.next.val){
	                cur.next=cur.next.next;
	            }else
	                cur = cur.next;
	        }
	        return head;
	}
	//---------------------------------------------------------------------------------------
	   public ListNode partition(ListNode head, int x) {
	        if(head==null)return null;
	        if(head.next==null)return head;
	        //i created two queue to contain the elements that greater or less than x;
	        ArrayDeque<ListNode> con1 = new ArrayDeque<>();
	        ArrayDeque<ListNode> con2 = new ArrayDeque<>();
	        
	        while(head!=null){
	            if(head.val<x){
	                con1.add(head);
	            }else{
	                con2.add(head);
	            }
	                
	            head=head.next;
	        }
	        //then i construct the list with the two queue in order to meet the requirements;
	        ListNode n = new ListNode(0);
	        ListNode n1 = n;
	        while(!con1.isEmpty()||!con2.isEmpty()){
	            if(!con1.isEmpty()){
	                n.next=con1.poll();
	                n=n.next;
	            
	            }else{
	                n.next=con2.poll();
	                n=n.next;
	            }
	        }
	        n.next=null;
	        return n1.next;
	    }
	   //----------------------------------------------------------------------------------------
		public Node insert(Node start, int x) {
			if(start == null) {
	            Node cur = new Node(x);
	            cur.next = cur;
	            return cur;
	        }
	        Node cur = start.next;
	        Node prev = start;
	        boolean find = false;
	        while(cur != start) {
	            int next = cur.val;
	            int pre = prev.val;
	            if(x == pre || x <= next && x > pre || next < pre && x > pre || next < pre && x < next) {
	                find = true;
	                Node node = new Node(x);
	                prev.next = node;
	                node.next = cur;
	                break;
	            }
	            prev = cur;
	            cur = cur.next;
	        }
	        if(!find) {
	            Node node = new Node(x);
	            prev.next = node;
	            node.next = cur;
	        }
	        return start;
	    }
		/////////////////////////////////////////////////////////////////////
	    public int getDecimalValue(ListNode head) {
	    	 int res = 0;
	    	        while (head != null) {
	    	            res *= 2;
	    	            res += head.val;
	    	            head = head.next;
	    	        }
	    	        return res;
	    	    }
}
