package hello;

public class codelab3 {
	public ListNode oddEvenList(ListNode head) {
        if(head==null)return null;
        ListNode temp=head;
        ListNode even=head.next;

        ListNode pre=even;
        
        while(even!=null&&even.next!=null){
            temp.next=even.next;
            temp=temp.next;
            even.next=temp.next;
            even=even.next;
        }
        //even.next=null;
        temp.next=pre;
        return head;
    }
	//-----------------------------------------------------
	 public ListNode deleteNodes(ListNode head, int m, int n) {
	        ListNode cur = head, pre = null;    
	        while (cur != null) {
	            int i = m, j = n;
	            
	         
	            while (cur != null && i-- > 0) {
	                pre = cur;
	                cur = cur.next;
	            }
	            
	            while (cur != null && j-- > 0) {
	                cur = cur.next;
	            }
	            pre.next = cur;     
	        }
	        return head;
	        
	    }
//-----------------------------------------------------------------------
	  public void deleteNode(ListNode node) {
          node.val = node.next.val;
   node.next = node.next.next;
       
       
   }
	  //----------------------------------------------------------------
	  public ListNode[] splitListToParts(ListNode root, int k) {
	        ListNode cur = root;
	        int N =0;
	        while(cur!=null){
	            cur = cur.next;
	            N++;
	            
	        }
	        int width = N/k,rem=N%k;
	        ListNode[] ans = new ListNode[k];
	        cur=root;
	        for(int i=0;i<k;i++){
	            ListNode head =cur;
	            for(int j=0;j<width+(i<rem?1:0)-1;j++){
	                if(cur!=null)cur=cur.next;
	            }
	            if(cur!=null){
	                ListNode pre=cur;
	                cur=cur.next;
	                pre.next=null;
	            }
	            ans[i]=head;
	        }
	        return ans;
	        
	    }
	  //////////////////////////////////////////////////////////////////////
	  public ListNode deleteDuplicates(ListNode head) {
	        ListNode cur = head;
	        ListNode cur1 = new ListNode(0);
	        cur1.next=head;
	        ListNode cur2 = head, pre = cur1;
	        Set<Integer> con = new HashSet<>();
	        while(cur!=null&&cur.next!=null){
	            if(cur.val==cur.next.val){
	                con.add(cur.val);
	                cur.next=cur.next.next;
	            }else
	                cur = cur.next;
	        }
	        while(cur2!=null){
	            if(con.contains(cur2.val)){
	                pre.next=cur2.next;
	            }else{
	                pre=pre.next;
	            }
	            cur2=cur2.next;
	        }
	        return cur1.next;
	    }
	  //////////////////////////////////////////////////////////////
	  public ListNode reverseLinkedList(ListNode head, int k) {
	        
	      
	        ListNode new_head = null;
	        ListNode ptr = head;
	        
	        while (k > 0) {
	            
	       
	            ListNode next_node = ptr.next;
	            
	          
	            ptr.next = new_head;
	            new_head = ptr;
	            
	            
	            ptr = next_node;
	            
	            
	            k--;
	        }
	            
	            
	        
	        return new_head;
	    
	    }
	            
	    public ListNode reverseKGroup(ListNode head, int k) {
	        
	        int count = 0;
	        ListNode ptr = head;
	        
	    
	        while (count < k && ptr != null) {
	            ptr = ptr.next;
	            count++;
	        }
	            
	        
	        if (count == k) {
	            
	            
	            ListNode reversedHead = this.reverseLinkedList(head, k);
	            
	          
	            head.next = reverseKGroup(ptr, k);
	            return reversedHead;
	        }
	            
	        return head;
	}
	    ////////////////////////////////////////////////////////
	    public void reorderList(ListNode head) {
	           if (head == null) return;

	    
	    ListNode slow = head, fast = head;
	    while (fast != null && fast.next != null) {
	      slow = slow.next;
	      fast = fast.next.next;
	    }

	   
	    ListNode prev = null, curr = slow, tmp;
	    while (curr != null) {
	      tmp = curr.next;

	      curr.next = prev;
	      prev = curr;
	      curr = tmp;
	    }

	 
	    ListNode first = head, second = prev;
	    while (second.next != null) {
	      tmp = first.next;
	      first.next = second;
	      first = tmp;

	      tmp = second.next;
	      second.next = first;
	      second = tmp;
	    }
	    }
	    ////////////////////////////////////////////////////
	    public int[] nextLargerNodes(ListNode head) {
	    	   ArrayList<Integer> A = new ArrayList<>();
	    	        for (ListNode node = head; node != null; node = node.next)
	    	            A.add(node.val);
	    	        int[] res = new int[A.size()];
	    	        Stack<Integer> stack = new Stack<>();
	    	        for (int i = 0; i < A.size(); ++i) {
	    	            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
	    	                res[stack.pop()] = A.get(i);
	    	            stack.push(i);
	    	        }
	    	        return res;
	    	    }
	    /////////////////////////////////////////////////////////////
	    static int k=2;
	    public ListNode swapPairs(ListNode head) {
	             int count = 0;
	        ListNode ptr = head;
	       // int k=2;       
	    
	        while (count < k && ptr != null) {
	            ptr = ptr.next;
	            count++;
	        }
	            
	        
	        if (count == k) {
	            
	            
	            ListNode reversedHead = this.reverseLinkedList(head, k);
	            
	          
	            head.next = swapPairs(ptr);
	            return reversedHead;
	        }
	            
	        return head;
	}
	        
	       public ListNode reverseLinkedList(ListNode head, int k) {
	        
	      
	        ListNode new_head = null;
	        ListNode ptr = head;
	        
	        while (k > 0) {
	            
	       
	            ListNode next_node = ptr.next;
	            
	          
	            ptr.next = new_head;
	            new_head = ptr;
	            
	            
	            ptr = next_node;
	            
	            
	            k--;
	        }
	            
	            
	        
	        return new_head;
	    
	    }
	       /////////////////////////////////////////////////
	       public ListNode removeElements(ListNode head, int val) {
	           ListNode fakeHead = new ListNode(-1);
	           fakeHead.next = head;
	           ListNode curr = head, prev = fakeHead;
	           while (curr != null) {
	               if (curr.val == val) {
	                   prev.next = curr.next;
	               } else {
	                   prev = prev.next;
	               }
	               curr = curr.next;
	           }
	           return fakeHead.next;
	   }
	       /////////////////////////////////////////////////////
	       public boolean isValid(String s) {
	           Stack<Character> temp = new Stack<>();
	        for(char c:s.toCharArray()){
	            if(c=='('){
	                temp.push(')');
	            }else if(c=='{'){
	                temp.push('}');
	            }else if(c=='['){
	                temp.push(']');
	            }else if(temp.isEmpty()||temp.pop()!=c)
	                return false;
	        }
	        return temp.isEmpty();
	    }
	       ///////////////////////////////////////////////
	       public String simplifyPath(String path) {
	    	    Deque<String> stack = new LinkedList<>();
	    	    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
	    	    for (String dir : path.split("/")) {
	    	        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
	    	        else if (!skip.contains(dir)) stack.push(dir);
	    	    }
	    	    String res = "";
	    	    for (String dir : stack) res = "/" + dir + res;
	    	    return res.isEmpty() ? "/" : res;
	    	    }
	       //////////////////////////////////////////////////
	       private Stack<int[]> stack = new Stack<>();
	       
	       public MinStack() { }
	       
	       
	       public void push(int x) {
	           
	           
	           if (stack.isEmpty()) {
	               stack.push(new int[]{x, x});
	               return;
	           }
	           
	           int currentMin = stack.peek()[1];
	           stack.push(new int[]{x, Math.min(x, currentMin)});
	       }
	       
	       
	       public void pop() {
	           stack.pop();
	       }
	       
	       
	       public int top() {
	           return stack.peek()[0];
	       }
	       
	       
	       public int getMin() {
	           return stack.peek()[1];
	       }
	       //////////////////////////////////////////////////
	       public int calculate(String s) {
	           Stack<Integer> con =new Stack<>();
	           int result=0;
	           int ope=0;
	           int sign=1;
	           for(int i=0;i<s.length();i++){
	               char temp=s.charAt(i);
	               if(Character.isDigit(temp)){
	                   ope=10*ope+(int)(temp-'0');
	               }else if(temp=='+'){
	                   result+=sign*ope;
	                   sign=1;
	                   ope=0;
	                   
	               }else if(temp=='-'){
	                   result+=sign*ope;
	                   sign=-1;
	                   ope=0;
	               }else if(temp=='('){
	                   con.push(result);
	                   con.push(sign);
	                   sign=1;
	                   result=0;
	               }else if(temp==')'){
	                   result+=sign*ope;
	                   result*=con.pop();
	                   result+=con.pop();
	                   ope=0;
	               }
	           }
	           return result+(sign*ope);
	           
	       }
	       ////////////////////////////////////////////////
	       public String removeDuplicateLetters(String s) {
	           Stack<Character> stack=new Stack<>();
	           Set<Character>seen = new HashSet<>();
	           HashMap<Character,Integer> last=new HashMap<>();
	           for(int i=0;i<s.length();i++)last.put(s.charAt(i),i);
	           for(int i=0;i<s.length();i++){
	               char c=s.charAt(i);
	               if(!seen.contains(c)){
	                   while(!stack.isEmpty()&&c<stack.peek()&&last.get(stack.peek())>i){
	                       seen.remove(stack.pop());
	                   }
	                   seen.add(c);
	                   stack.push(c);
	               }
	           }
	           StringBuilder sb = new StringBuilder(stack.size());
	       for (Character c : stack) sb.append(c.charValue());
	       return sb.toString();
	       }
	       ////////////////////////////////////////////////////
	       public NestedInteger deserialize(String s) {
	           if (s.isEmpty())
	           return null;
	       if (s.charAt(0) != '[') 
	           return new NestedInteger(Integer.valueOf(s));
	           
	       Stack<NestedInteger> stack = new Stack<>();
	       NestedInteger curr = null;
	       int l = 0; // l shall point to the start of a number substring; 
	                  // r shall point to the end+1 of a number substring
	       for (int r = 0; r < s.length(); r++) {
	           char ch = s.charAt(r);
	           if (ch == '[') {
	               if (curr != null) {
	                   stack.push(curr);
	               }
	               curr = new NestedInteger();
	               l = r+1;
	           } else if (ch == ']') {
	               String num = s.substring(l, r);
	               if (!num.isEmpty())
	                   curr.add(new NestedInteger(Integer.valueOf(num)));
	               if (!stack.isEmpty()) {
	                   NestedInteger pop = stack.pop();
	                   pop.add(curr);
	                   curr = pop;
	               }
	               l = r+1;
	           } else if (ch == ',') {
	               if (s.charAt(r-1) != ']') {
	                   String num = s.substring(l, r);
	                   curr.add(new NestedInteger(Integer.valueOf(num)));
	               }
	               l = r+1;
	           }
	       }
	       
	       return curr;
	       }
	       //////////////////////////////////////////////////
	       public String decodeString(String s) {
	           if(s.length()==0)return null;
	           StringBuilder x=new StringBuilder();
	           Stack<Character> stack = new stack<>();
	           for(int i=0;i<s.length();i++){
	               if(s.charAt(i)==']'){
	                   List<Character> deco=new ArrayList<>();
	                   while(stack.peek()!='['){
	                       deco.add(stack.pop());
	                   }
	                   stack.pop();
	                   int base=1;
	                   int k=0;
	                   while(!stack.isEmpty()&&Character.isDigit(stack.peek())){
	                       k=k+(stack.pop()-'0')*base;
	                       base*=10;
	                   }
	                   while(k!=0){
	                       for(int j=deco.size()-1;j>=0;j--){
	                           stack.push(deco.get(j));
	                       }
	                       k--;
	                   }
	                   
	               }else
	                   stack.push(s.charAt(i));
	           }
	       }
	           char[] result = new char[stack.size()];
	           for (int i = result.length - 1; i >= 0; i--) {
	               result[i] = stack.pop();
	           }
	           return new String(result);
	        /////////////////////////////////////////////////////
	           public String removeKdigits(String num, int k) {
	               Stack<Character> stack=new Stack<>();
	               for(char d:num.toCharArray()){
	                   while(stack.size()>0&&k>0&&stack.peek()>d){
	                       stack.pop();
	                       k-=1;
	                   }
	                   stack.push(d);
	               }
	               for(int i=0;i<k;i++){
	                   stack.pop();
	               }
	               StringBuilder res=new StringBuilder();
	               boolean lead=true;
	               for(char x:stack){
	                   if(lead&&x=='0')continue;
	                   lead=false;
	                   res.append(x);
	               }
	               if(res.length()==0)return "0";
	               return res.toString();
	          
	               
	           }
	           //////////////////////////////////////
	           public boolean find132pattern(int[] nums) {
	               if (nums.length < 3)
	                 return false;
	             Stack < Integer > stack = new Stack < > ();
	             int[] min = new int[nums.length];
	             min[0] = nums[0];
	             for (int i = 1; i < nums.length; i++)
	                 min[i] = Math.min(min[i - 1], nums[i]);
	             for (int j = nums.length - 1; j >= 0; j--) {
	                 if (nums[j] > min[j]) {
	                     while (!stack.isEmpty() && stack.peek() <= min[j])
	                         stack.pop();
	                     if (!stack.isEmpty() && stack.peek() < nums[j])
	                         return true;
	                     stack.push(nums[j]);
	                 }
	             }
	             return false;
	             
	         }
	           /////////////////////////////////////////////
	           if(nums1.length==0)return new int[0];
	           int[] x=new int[nums1.length];
	           int temp=Integer.MAX_VALUE;
	           for(int i=0;i<nums1.length;i++){
	               for(int j=0;j<nums2.length;j++){
	                   if(nums1[i]==nums2[j]){
	                       temp=nums1[i];
	                   }
	                   if(nums2[j]>temp){
	                       x[i]=nums2[j];
	                       temp=Integer.MAX_VALUE;
	                       break;
	                   }
	               }
	               if(x[i]==0){
	                   x[i]=-1;
	                   temp=Integer.MAX_VALUE;}
	           }
	           return x;
	           /////////////////////////////////////////////////
	           public int[] nextGreaterElements(int[] nums) {
	               int[] res = new int[nums.length];
	               Stack<Integer> stack = new Stack<>();
	               for (int i = 2 * nums.length - 1; i >= 0; --i) {
	                   while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
	                       stack.pop();
	                   }
	                   res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
	                   stack.push(i % nums.length);
	               }
	               return res;
	           }
	           //////////////////////////////////////////////////
	           public String countOfAtoms(String formula) {
	               Stack<Map<String,Integer>> stack= new Stack<>();
	               Map<String,Integer> map= new HashMap<>();
	               int i=0,n=formula.length();
	               while(i<n){
	                   char c=formula.charAt(i);i++;
	                   if(c=='('){
	                       stack.push(map);
	                       map=new HashMap<>();
	                   }
	                   else if(c==')'){
	                       int val=0;
	                       while(i<n && Character.isDigit(formula.charAt(i)))
	                           val=val*10+formula.charAt(i++)-'0';

	                       if(val==0) val=1;
	                       if(!stack.isEmpty()){
	                       Map<String,Integer> temp= map;
	                       map=stack.pop();
	                           for(String key: temp.keySet())
	                               map.put(key,map.getOrDefault(key,0)+temp.get(key)*val);
	                       }
	                   }
	                   else{
	                       int start=i-1;
	                       while(i<n && Character.isLowerCase(formula.charAt(i))){
	                        i++;
	                       }
	                       String s= formula.substring(start,i);
	                       int val=0;
	                       while(i<n && Character.isDigit(formula.charAt(i))) val=val*10+ formula.charAt(i++)-'0';
	                       if(val==0) val=1;
	                       map.put(s,map.getOrDefault(s,0)+val);
	                   }
	               }
	               StringBuilder sb= new StringBuilder();
	               List<String> list= new ArrayList<>(map.keySet());
	               Collections.sort(list);
	               for(String key: list){ 
	                   sb.append(key);
	                 if(map.get(key)>1) sb.append(map.get(key));
	                                           }
	               return sb.toString();
	           }
	           ///////////////////////////////////////////////////
	           public int[] asteroidCollision(int[] asteroids) {
	               Stack<Integer> stack = new Stack();
	               for (int ast: asteroids) {
	                   collision: {
	                       while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
	                           if (stack.peek() < -ast) {
	                               stack.pop();
	                               continue;
	                           } else if (stack.peek() == -ast) {
	                               stack.pop();
	                           }
	                           break collision;
	                       }
	                       stack.push(ast);
	                   }
	               }

	               int[] ans = new int[stack.size()];
	               for (int t = ans.length - 1; t >= 0; --t) {
	                   ans[t] = stack.pop();
	               }
	               return ans;
	           }
	           /////////////////////////////////////////////////////
	           public int[] dailyTemperatures(int[] T) {
	               int[]res =new int[T.length];
	               //res[res.length-1]=0;
	               for(int i=0;i<res.length-1;i++){
	                   for(int j=i+1;j<res.length;j++){
	                       if(T[i]<T[j]){
	                           res[i]=j-i;
	                           break;
	                       }
	                   }
	                   
	               }
	               return res;
	               
	           }
	           /////////////////////////////////////////////////
	           public boolean backspaceCompare(String S, String T) {
	               Stack<Character> con1=new Stack<>();
	               Stack<Character> con2=new Stack<>();
	               for(int i=0;i<S.length();i++){
	                   if(!con1.isEmpty()&&S.charAt(i)=='#'){
	                       con1.pop();
	                       
	                   }else if(S.charAt(i)!='#'){con1.push(S.charAt(i));}
	               }
	                 for(int i=0;i<T.length();i++){
	                   if(!con2.isEmpty()&&T.charAt(i)=='#'){
	                       con2.pop();
	                       
	                   }else if(T.charAt(i)!='#') con2.push(T.charAt(i));
	               }
	               if(con1.toString().equals(con2.toString())||con1.isEmpty()&&con2.isEmpty()){
	                   return true;
	               }else
	                   return false;
	           }
	           ////////////////////////////////////////////////////
	           public int scoreOfParentheses(String S) {
	               Stack<Integer> stack = new Stack();
	        stack.push(0); // The score of the current frame

	        for (char c: S.toCharArray()) {
	            if (c == '(')
	                stack.push(0);
	            else {
	                int v = stack.pop();
	                int w = stack.pop();
	                stack.push(w + Math.max(2 * v, 1));
	            }
	        }

	        return stack.pop();
	            
	            
	        }
	           ////////////////////////////////////////////
	           public String decodeAtIndex(String S, int K) {
	               //Stack<Character> con=new Stack<>();
	             int len = S.length();
	               long decodedLen = 0;
	               for(int i = 0; i<len; i++)
	                   if(Character.isDigit(S.charAt(i)))
	                       decodedLen *= S.charAt(i)-'0';
	                   else
	                       decodedLen++;
	               for(int i = len-1; i>=0; i--){
	                   if(Character.isDigit(S.charAt(i))){
	                       decodedLen /= S.charAt(i)-'0';
	                       continue;
	                   }
	                   if(K>decodedLen)
	                       K = (int)(K % decodedLen);
	                   if( K == decodedLen || K == 0 )
	                       return ""+S.charAt(i);
	                   decodedLen--;
	               }
	               return null; 
	           }
	           /////////////////////////////////////////////
	           Map<Integer, Integer> freq;
	           Map<Integer, Stack<Integer>> group;
	           int maxfreq;

	           public FreqStack() {
	               freq = new HashMap();
	               group = new HashMap();
	               maxfreq = 0;
	           }

	           public void push(int x) {
	               int f = freq.getOrDefault(x, 0) + 1;
	               freq.put(x, f);
	               if (f > maxfreq)
	                   maxfreq = f;

	               group.computeIfAbsent(f, z-> new Stack()).push(x);
	           }

	           public int pop() {
	               int x = group.get(maxfreq).pop();
	               freq.put(x, freq.get(x) - 1);
	               if (group.get(maxfreq).size() == 0)
	                   maxfreq--;
	               return x;
	           }
	           //////////////////////////////////////
	           public int minAddToMakeValid(String S) {
	               Stack<Character> con=new Stack<>();
	               int count=0;
	               for(int i=0;i<S.length();i++){
	                   if(S.charAt(i)==')'){
	                       if(!con.isEmpty()){
	                           con.pop();
	                       }else
	                           count++;
	                   }else{
	                       con.push(S.charAt(i));
	                   }
	               }
	               return count+con.size();
	               
	           }
	           //////////////////////////////////////
	           public String removeOuterParentheses(String S) {
	               StringBuilder s = new StringBuilder();
	               int opened = 0;
	               for (char c : S.toCharArray()) {
	                   if (c == '(' && opened++ > 0) s.append(c);
	                   if (c == ')' && opened-- > 1) s.append(c);
	               }
	               return s.toString();
	           }

}
