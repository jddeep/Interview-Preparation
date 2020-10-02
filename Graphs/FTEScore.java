/*
General score of a employee based based on adding scores of subemployees. An employee with no subemployees,
has a score of 1. We use DFS here.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    static HashMap<String, Integer> cache;
    static List<String> recursionStack;
    
    static int dfs(HashMap<String, List<String>> hm, String uid){
        
        if(cache.containsKey(uid)) return cache.get(uid);
        if(recursionStack.contains(uid)) return -1; //if cycle exists return -1;
        
        int ans = 0;
        List<String> subEmployees = hm.get(uid);
        if(subEmployees.size() == 0) return 1;
        recursionStack.add(uid);
        for(String subId: subEmployees){
            ans = dfs(hm, subId);
            if(ans != -1) {
                ans = 1+ans;
            cache.put(subId, ans+1);
            }
        }
        recursionStack.remove(recursionStack.indexOf(uid));
        return ans;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>(){{
		    put("456",Arrays.asList("123", "111"));
		    put("123",Arrays.asList("745", "298"));
		    put("745",new ArrayList<>());
		    put("298",Arrays.asList("333", "111"));
		    put("333",new ArrayList<>());
		    put("111",new ArrayList<>());
		 }};
		  cache = new HashMap<>();
		  recursionStack = new ArrayList<>();
		 int score = dfs(hm, "456"); //returns 4;
		System.out.println(score);
		
	}
}
