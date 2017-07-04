import java.util.*;
class ProductCipher
{
public static void main(String args[]){
 char pt[];
  char ct[];
  char dt[];
 char rf[][];
 char drf[];
  Scanner sc=new Scanner(System.in);
System.out.println("Enter plain text:");
String s= sc.nextLine();
int l=s.length();
pt=new char[l];
ct=new char[l];
dt=new char[l];
drf=new char[l];
Random r = new Random();
int n= 1+r.nextInt(10);
System.out.println("Key : "+n);
pt=s.toCharArray();
int j=0;
int i=0,m=0,k=0;

while(i<l)
{
  if(pt[i]==' ')
  {ct[i]=' ';i++; continue;}
  j = ((pt[i]-'a')+n)%26;
  ct[i]=(char)('a'+j);
  i++;
}
System.out.print("First encryption : ");
System.out.println(ct);
if(l%2==0)
{rf=new char[2][l/2];}
else
{rf=new char[2][(l/2)+1];}

for(i=0;i<l;i++)
{
if(i%2==0)
rf[1][m++]=ct[i];
else
rf[0][k++]=ct[i];
}
System.out.print("Cipher text after second encryption:");
for(i=0;i<k;i++)
{
	System.out.print(rf[0][i]);
}
for(i=0;i<m;i++)
{
	System.out.print(rf[1][i]);
}
m=0;
k=0;

for(i=0;i<l;i++)
{
	if(i%2==0)
	{
		drf[i]=rf[1][m++];
	}
	else
	{
		drf[i]=rf[0][k++];
	}
}
System.out.println();
System.out.print("First decryption:");
System.out.println(drf);





i=0;
int e=0;
while(i<l)
{
	if(drf[i]==' ')
	{dt[i]=' ';i++; continue;}
    e = ((drf[i]-'a')-n)%26;
  dt[i]=(char)('a'+e);
  i++;
}
System.out.print("Plain text after second decryption : ");
System.out.println(dt);

}
}


