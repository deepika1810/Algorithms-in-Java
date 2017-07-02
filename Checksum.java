import java.util.*;
class CMain{
   public static void main(String args[])
   {
    Checksum c=new Checksum();
	c.read();
	c.findcs();
	c.evaluatecs();
	c.output();
   }   }
class Checksum
{
     Scanner s=new Scanner(System.in);
	 int m[][]=new int[2][16];
	 int sum1[]=new int[16];
	 int sum2[]=new int[16];
	 int i,n,c,count;
	 boolean flag;
      public void read()   //reads sender side message words
	 {
	   System.out.println("Enter the message size: ");
	   n=s.nextInt();
	   System.out.print("Enter message word 1 : ");
	   for(i=0;i<n;i++)
	      m[0][i]=s.nextInt();	
	   System.out.print("Enter message word 2 : ");
	   for(i=0;i<n;i++)
	      m[1][i]=s.nextInt();
	   c=0;  count=n;
	 }
	
     public void findcs()      //calculating checksum for given message
    {
	 i=n-1; //i tracks bit position in operands
               while(count!=0)
               {
                 if(c==0)			//if carry absent
	  {
	  if(m[0][i]==0&&m[1][i]==0)
	    {sum1[i--]=0; c=0;}
	  else if((m[0][i]==1&&m[1][i]==0)||(m[0][i]==0&&m[1][i]==1))
	     {sum1[i--]=1; c=0;}
	  else
	     {sum1[i--]=0; c=1;}
	  }
            else				//if carry present
            {
              if(m[0][i]==0&&m[1][i]==0)
	    {sum1[i--]=1; c=0;}
	  else if((m[0][i]==1&&m[1][i]==0)||(m[0][i]==0&&m[1][i]==1))
	     {sum1[i--]=0; c=1;}
	  else
	     {sum1[i--]=1; c=1;}
             }
              count--;
         }
              //managing extra carry
         if(c==1)
          {
	  i=n-1;
	  while(c!=0)
	  {
	    if(sum1[i]==0)   {sum1[i]=1; c=0;}
		else            {sum1[i]=0;}
	  }
	}
	for(i=0;i<n;i++)      //takiing 1's complement of sum1
	   if(sum1[i]==0) sum1[i]=1;
	   else          sum1[i]=0;
	System.out.print("Checksum : ");   //displaying output
	for(i=0;i<n;i++)
	   System.out.print(sum1[i]);
     }
	
     public void evaluatecs()        //recalculating checksum on receiver side
      { 
	int j;
	int r[][]= new int[3][16];
	System.out.println();
	System.out.println("Enter the received message:");
	for(i=0;i<3;i++)
	   for(j=0;j<n;j++)
	       r[i][j]=s.nextInt();
	int s;
	c=0;  count=n;
	i=n-1; //i tracks bit position in operands
            while(count!=0)
             {
	    s=r[0][i]+r[1][i]+r[2][i]+c;
                  switch(s)
		{
		 case 0:sum2[i]=0;  c=0; break;
		 case 1:sum2[i]=1; c=0;  break;
		 case 2:sum2[i]=0;  c=1; break;
		 case 3:sum2[i]=1;  c=1;  break;
		}
                    count--;  i--;
            }
	//managing extra carry
           if(c==1)
           {
	  i=n-1;
	  while(c!=0)
	  {
	    if(sum2[i]==0)   {sum2[i]=1; c=0;}
		else            {sum2[i]=0;}
	  }
	}
	for(i=0;i<n;i++)   	//taking 1's complement of sum
	   if(sum2[i]==0) sum2[i]=1;
	   else          sum2[i]=0;
     }  
	
       public void output()     //displaying result
      {
	 flag=true;   //assuming no error
   	 for(i=0;i<n;i++)
	      if(sum2[i]!=0)
		      flag=false;
	if(flag)
	    System.out.println("No error");
	else
	    System.out.println("Erroneous message");
       }
}
