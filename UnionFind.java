/**
 * @author Zeel Shah
 * @date Feb 26 2020
 * @Student No. 250970094
 */
import java.io.*;
import java.util.*;

public class UnionFind {
	
	private int[] set; 
	private boolean finalSet = false;
	
	// construct an union - find data type with n elements 
	public UnionFind(int n)
	{
		set = new int [n];
		
	}
	
	//creates a new set whose only member is i
	public void make_set(int i)
	{
		
		if(finalSet==false)
			set[i-1]=i;
		else 
			System.out.println("Set is final, changes cannot be made");
	}
	
	//unites the dynamic sets that contains i and j, respectively into a 
	//new set that is the union of these 2 sets 
	public void union_sets(int i, int j)
	{
		if(set[i-1]==0 ||set[j-1]==0 )
			System.out.println("this set does not exist");
		
		else if(finalSet==false)
		{
			
			set[j-1] = set[i-1];
			
			
		}
			
		else
			System.out.println("Set is final, changes cannot be made");
		
	}
	
	//returns the representative of the set containing i
	public int find_set(int i)
	{
		if(set[i-1]==0)
		{
			System.out.println("this set does not exist");
			return 0;
	}
		else 
			return set[i-1];
	}
	
	//returns the total number of current sets and finalizes the current sets
	public int final_sets()
	{
		int count =0;
		int length = set.length;
		int[] hash = new int[length];
		
		for (int i =0; i<length; i++)
		{
				
			if(set[i]!=0 && hash[set[i]-1]==0)
			{
				count++;
				hash[set[i]-1]=1;
			}
		}
		
		
		for (int i=0; i<count; i++)
		{
			set[i]=i+1;
		}
		
		for (int i = count; i<length; i++)
		{
			set[i]=0;
		}
		
		return count;
		
		
	}
	
	

}
