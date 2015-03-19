import java.util.Random;



public class Simulator {

	public static void main(String[] args) {
		
		int n=9;
		int f1[]= new int[n];
		int f2[]= new int[n];
		int t1[]= new int[n-1]; //variable for time values taken to switch between stations
		int t2[]= new int[n-1]; 
		int a1[]= new int[n]; //variable for time taken at each station
		int a2[]= new int[n];
		int l1[]= new int[n];
		int l2[]= new int[n];
		int x1= 7;
		int x2= 12;
		int e1= 18; //exit time value variable
		int e2= 12;
		int f,l;
		
		Random rand= new Random();
		
		for(int i=0; i<n;i++)
		{
			a1[i]=rand.nextInt(10);
			a2[i]=rand.nextInt(10);
		}
		
		for(int i=0; i<n-1;i++)
		{
			t1[i]=rand.nextInt(10);
			t2[i]=rand.nextInt(10);
		}
		
		f1[1] = e1 + a1[1];
		f2[1] = e2 + a2[1];
		
		for (int j=1; j<n ;j++)
		{
			if (f1[j-1] + a1[j] <= f2[j-1] + t2[j-1] + a1[j])
			{
				f1[j] = f1[j-1]+a1[j];
				l1[j] = 1;
			}
			
		else 
			{
				f1[j] = f2[j-1] + t2[j-1] + a1[j];
				l1[j] = 2;
			}
			
		if (f2[j-1] + a2[j] <= f1[j-1] + t1[j-1] + a2[j])
				{
					f2[j] = f2[j-1]+a2[j];
					l2[j] = 2;
				}
		
		else 
			{
				f2[j] = f1[j-1] + t1[j-1] + a2[j];
				l2[j] = 1;
			}
		}
		
		if (f1[n-1] + x1 <= f2[n-1] + x2)
			{
				f = f1[n-1] + x1;
				l = 1;
			}
			else 
			{
				f = f2[n-1] + x2;
				l = 2;
			}
		System.out.println(" : "+ f);		
		
		System.out.println("Time at line 1 stations: ");
		
		for(int i=0; i<n; i++)
		{
			System.out.println(" "+a1[i]);
		}
		
		System.out.println("Time at line 2 stations: ");
		
		for(int i=0; i<n; i++)
		{
			System.out.println(" "+a2[i]);
		}
		
		for(int i=n-1; i>=1; i--)
        {
            
            
        if(l==1)
        {

        	System.out.println("Station "+i+ ", at line "+l1[i]);
        }
        else
        {
        	
        	System.out.println("Station "+i+ ", at line "+l2[i]);
        }

        }

		
	}
	
	
	
	
	}


