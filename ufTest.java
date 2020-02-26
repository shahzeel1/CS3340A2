import java.io.*;
public class ufTest {
	
	public static void main (String args[])
	{
		UnionFind uf = new UnionFind(7);
		boolean pass = true;
		
		for (int i = 1; i<=7; i++)
		{
			uf.make_set(i);
		}
		
		for (int i = 1; i<=7; i++)
		{
			if(uf.find_set(i)!=i)
			{
				pass = false ;
			}
		}
		
		if(pass = false)
		{
			System.out.println("Test 1: Fail");
			pass = true;
		}
		else 
			System.out.println("Test 1: Pass");
		
		uf.union_sets(1, 2);
		uf.union_sets(5, 6);
		
		if(uf.find_set(6)!=5)
		{
			System.out.println("Test 2: Fail"+ uf.find_set(6));
		}
		else 
			System.out.println("Test 2: Pass");
		
		System.out.print(uf.final_sets());
		
	}

}
