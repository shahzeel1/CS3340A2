import java.io.*;
public class UnionFindMain {

static int[][] linearr_One = new int[71][71]; // 2d array to store the image
	static int[][] linearr_Two = new int[71][71]; 
	static int[] drow = {-1,0,1,0};
	static int[] dcol = {0,1,0,-1};
	static UnionFind uf = new UnionFind(5041);
	static int[] compSizeArr = new int[26];
	static char[] compNameArr = new char [26];
	static int compCount = 1;
	public static void main(String args[]) throws Exception
	{
		// open the file 
		File file = new File (args[0]);
		FileReader br = new FileReader(file);
		
		int c;
			
		
		//1. The input binary image is outputed 
		int row = 71, col =71, count = 1;

		
		for (int i=0; i<row; i++)
		{
			for (int j=0; j<col; j++)
			{
				c=br.read();
				if(c=='+')
				{
					System.out.print(1);
					linearr_One[i][j] = 1;
					
					uf.make_set((i*71+(j)+1));
				}
				else if (c==' ')
				{
					System.out.print(0);
					linearr_One[i][j] = 0;
				}
				
			}
			if(i!=70)
			{
			c= br.read();
			System.out.print((char) c);
			c= br.read();
			System.out.print((char) c);
			}
		}
		
		System.out.println(" ");
		System.out.println(" ");
		
		// create union find data type
		
		
		//2. the connected component image
				//where each component is labeled with a unique character
				
		for (int i=0; i< row; i++)
			for (int j=0; j<col; j++)
				
				if(linearr_One[i][j] ==1 & linearr_Two[i][j]==0)
				{
					System.out.println(" ");
					dfs(i,j,count++);
					compSizeArr[count-1]= compCount;
					compCount=1;
				}
		
		for(int i=0; i<row;i++){
	        for(int j=0; j<col;j++)
	        {
	            if (linearr_Two[i][j]==0)
	            	System.out.print(" ");
	            else
	            {
	            	System.out.print((char) (linearr_Two[i][j] + 96) );
	            }
	        }
	        System.out.println("");
	    }
		
		// 3. a list sorted by component size, where each line of the list contains the size and the
		//label of a component,
		
		
		
		for (int i=0; i<26; i++)
		{
			compNameArr[i] = (char)(i+96);
		}
		
		quickSort(0,25);
		
		int i=0;
		
	
		while(i<26)
		{
			if(compSizeArr[i]!=0)
			{
				System.out.println(compNameArr[i] +": "+ compSizeArr[i]);
			}
			i++;
			
		}
				
		
		br.close();
		
		
		
		
		
		
		
		
		
	}
	
	private static void dfs (int row, int col, int val)
	{
		linearr_Two[row][col]=val;
		
		
		for (int i=0; i<4; i++)
		{
			int newRow = row + drow[i];
			int newCol = col + dcol[i];
			
			if(newCol>=0 && newCol<71 && newRow >= 0 && newRow < 71 )
				{
				if(linearr_One[newRow][newCol] == 1 & linearr_Two[newRow][newCol] == 0) 
					{
						uf.union_sets(((row)*71+(col)+1), ((newRow)*71+(newCol)+1));
						compCount++;
						dfs(newRow,newCol,val);
					}
				}
					
		}
	}
	
	private static void quickSort(int left, int right)
	{
	
	
		if(left<right)
		{
		int mid = midCalc (left,right);
		
		quickSort(left,mid-1);
		quickSort(mid+1, right);
		}
		
	}
	
	private static int midCalc(int left, int right)
	{
		int piv = compSizeArr[right];
		int low = left-1 ;
		
		for (int j = left; j<  right; j++)
		{
			
			if(compSizeArr[j]<= piv)
			{
				low++;
				swap (low,j);
			}
		}
		swap (low+1,right);
		
		return (low+1);
		
		
	}
	
	private static void swap(int i,int j)
	{
		int tempI;
		char tempC;
		
		tempI = compSizeArr[i];
		tempC = compNameArr[i];
		compSizeArr[i] = compSizeArr[j];
		compNameArr[i] = compNameArr[j];
		compNameArr[j]=tempC;
		compSizeArr[j]=tempI;
				
	}
	
	
}
