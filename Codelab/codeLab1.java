package hello;
import java.util.*;
public class codeLab1 {
	public String sumOfTwo(String x,String y) {
		if(x==null||y==null) return null;
		StringBuilder sb = new StringBuilder();
		int record=0;
		int length1=x.length()-1;
		int length2=y.length()-1;
		
		while(length1>=0||length2>=0) {
			int n1;
			int n2;
			if(length1>=0) {
				n1=x.charAt(length1)-'0';
			}else
				n1=0;
			if(length2>=0) {
				n2=y.charAt(length2)-'0';
				
			}else
				n2=0;
			int temp=n1+n2+record;
			if(temp>9) {
				record=1;
			}else {
				record=0;}
			sb.insert(0, temp%10);
			length1--;
			length2--;
		}
		if(record==1)sb.insert(0, 1);
		return sb.toString();
	}
	//-------------------------------------------------------------------------
	   public int[] twoSum(int[] nums, int target) {
	        int[] res = new int[2];
	        Map<Integer,Integer> con = new HashMap<>();
	        for(int i =0;i<nums.length;i++){
	            if(con.containsKey(target-nums[i])){
	                res[0]=i;
	                res[1]=con.get(target-nums[i]);
	                return res;
	            }else
	                con.put(nums[i],i);
	        }
	        return res;
	    }
	   //-----------------------------------------------------------------------------
	    public void rotateArray(int[] nums, int k) {
	        int x,y;
	        for(int i =0;i<k;i++){
	            x = nums[nums.length-1];
	            for(int j =0;j<nums.length;j++){
	                y=nums[j];
	                nums[j]=x;
	                x=y;
	            }
	        }
	        
	    }
	    //--------------------------------------------------------------------------------
	    public boolean isUnique(String x) {
	    	Set<Character> con = new HashSet<>();
	    	for(int i=0;i<x.length();i++) {
	    		if(!con.contains(x.charAt(i))) {
	    			con.add(x.charAt(i));
	    		}else {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	    //------------------------------------------------------------------
	    public boolean isPer(String x,String y) {
	    	Map<Character,Integer> con = new HashMap<>();
	    	for(int i=0;i<x.length();i++) {
	    		
	    		con.put(x.charAt(i), con.getOrDefault(x.charAt(i), 0)+1);
	    		
	    	}
	    	for(int j=0;j<y.length();j++) {
	    		if(con.containsKey(y.charAt(j))) {
	    			if(con.get(y.charAt(j))==0) {
	    				return false;
	    			}else {
	    				con.put(y.charAt(j), con.get(y.charAt(j))-1);
	    			}
	    			if(!con.containsKey(y.charAt(j)))
	    				return false;
	    			
	    		}
	    	}
	    	return true;
	    }

}
