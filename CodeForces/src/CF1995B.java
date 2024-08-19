import java.util.*;

public class CF1995B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int n=in.nextInt();
			long k=in.nextLong();
			long arr[]= new long[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=in.nextLong();
				
			}
			Arrays.sort(arr);
			long csum=0;
			long max=0;
			int j=0;
			for(int i=0;i<n;i++)
			{ csum=csum+arr[i];
                System.out.println();
			   while(j<arr.length&& arr[i]-arr[j]>1)
			   {
                
                System.out.println(j);
                
				   csum=csum-arr[j];
				   j++;
			   }
               System.out.println();
			   while(j<arr.length && csum>k)
			   {
                System.out.println(j);
				   csum=csum-arr[j];
				   j++;
				   
			   }
               System.out.println();
			   max=Math.max(max, csum);
				
			}
			System.out.println(max);
        }
    }
}
