import java.util.*;
class Hammingcode
{
  public static void main(String args[])
  {
   Scanner s=new Scanner(System.in);
   int h[]= new int[12];
   int rh[]= new int[12];
   int d[]=new int[7];
   int e[]= new int[4];
    int i,j,k,pos,apos=12,r;
   System.out.println("Enter the data word (7-bits):");
   for(i=0;i<7;i++)
       d[i]=s.nextInt();
	//setting data bits in code word
	h[9]=d[6];  h[7]=d[5];  h[6]=d[4];  h[5]=d[3]; h[3]=d[2]; h[2]=d[1];  h[1]=d[0];
 
	//calculating parity bits
	pos=1; r=0;
	while(pos<=8)
	{
	  j=pos;
	  switch(pos)
	  {
	    case 1:for(j=3;j<=11;j+=pos)
		            if(h[apos-j++]==1) r++;
			   break;
	   case 2:if(h[apos-(++j)]==1) r++;
		       for(j=6;j<=11;j+=pos)
		           { if(h[apos-j++]==1) r++;
			         if(h[apos-j++]==1)  r++;
	                           }
			   break;
	   case 4:j=5;
			   if(h[apos-j]==1)  r++;
			   if(h[apos-j-1]==1)   r++;
			   if(h[apos-j-2]==1)   r++;
			   break;
			   
                 case 8:j=9;
			   if(h[apos-j]==1)  r++;
			   if(h[apos-j-1]==1)   r++;
			   if(h[apos-j-2]==1)   r++;
			   break;
	   }
	  
	  if(r%2==0)  h[apos-pos]=0;
	  else        h[apos-pos]=1;
	  
	  pos*=2;  r=0;
	}
	
	//displaying output
	System.out.println("The hamming code is: ");
	for(i=1;i<=11;i++)
	   System.out.print(h[i]);
	System.out.println();
	   
	//checking at receiver end
	System.out.println("Enter the received code word:");
	for(i=1;i<12;i++)
	    rh[i]=s.nextInt();
	int t=0,index=3;
	pos=1;
	while(pos<=8)
	{
                 t=0; j=12-pos;
	  switch(pos)
	  {
	    case 1: for(j=11;j>0;j-=2)
		           t+=rh[j];       break;
		case 2: for(j=10;j>0;j-=4)
		           t+=rh[j]+rh[j-1];       break;
		case 4: for(j=8;j>4;j--)
		            t+=rh[j];        break;
		case 8: for(j=4;j>0;j--)
		            t+=rh[j];      break;
	  }
	 if(t%2==0) e[index--]=0;
	    else    e[index--]=1;
	pos*=2;
             }
	//finding error location
	if(e[0]==0&&e[1]==0&&e[2]==0&&e[3]==0) 
	    System.out.println("No error");
	else
	  {
	    if(e[0]==0)
		{
		  if(e[1]==0)
		  {
		    if(e[2]==0)
			{ System.out.println("Error at location 1.");}
		    else
		   {
		     if(e[3]==0)  System.out.println("Error at location 2.");
			  else    System.out.println("Error at location 3.");
		   }
		}
		else
		{
		   if(e[2]==0)
			{ 
			  if(e[3]==0)  System.out.println("Error at location 4.");
			  else   System.out.println("Error at location 5.");
			 }
		    else
		   {
		     if(e[3]==0)  System.out.println("Error at location 6.");
			  else    System.out.println("Error at location 7.");
		   }
		}
	  }
	  else
	  {
	    if(e[2]==0)
			{ 
			  if(e[3]==0)  System.out.println("Error at location 8.");
			  else   System.out.println("Error at location 9.");
			 }
		    else
		   {
		     if(e[3]==0)  System.out.println("Error at location 10.");
			  else    System.out.println("Error at location 11.");
		   }
	  }
    }
  }
  }
