import java.io.*;
class BullyAlgo
{
int cood,ch,crash;
int prc[];
public void election(intn)throwsIOException
{
BufferedReader br=new BufferedReader(newInputStreamReader(System.in));
System.out.println("\nTheCoordinatorHasCrashed!");
int flag=1;
while(flag==1)
{
crash=0;
for(int i1=0;i1<n;i1++)
if(prc[i1]==0)
crash++;
if(crash==n)
{
System.out.println("\n***AllProcessesAreCrashed***");
break;
}
else
{
System.out.println("\nEnterTheInititor");
int init=Integer.parseInt(br.readLine());
if((init<1)||(init>n)||(prc[init-1]==0))
{
System.out.println("\nInvalidInitiator");
continue;
}
for(int i1=init-1;i1<n;i1++)
System.out.println("Process"+(i1+1)+"CalledForElection");
System.out.println("");
for(int i1=init-1;i1<n;i1++)
{
if(prc[i1]==0)
{
System.out.println("Process"+(i1+1)+"IsDead");
}
else
System.out.println("Process"+(i1+1)+"IsIn");
} 
for(int i1=n-1;i1>=0;i1--)
if(prc[i1]==1)
{
cood=(i1+1);
System.out.println("\n***NewCoordinatorIs"+(cood)+"***");
flag=0;
break;
}
}
}//endofwhile
}//endofelection()method
public void Bully()throwsIOException
{
BufferedReader br=new BufferedReader(newInputStreamReader(System.in));
System.out.println("EnterTheNumberofProcesses:");
int n=Integer.parseInt(br.readLine());
prc=new int[n];
crash=0;
for(int i=0;i<n;i++)
prc[i]=1;
cood=n;
do
{
System.out.println("\n\t1.CrashAProcess");
System.out.println("\t2.RecoverAProcess");
System.out.println("\t3.DisplayNewCoordinator");
System.out.println("\t4.Exit");
ch=Integer.parseInt(br.readLine());
switch(ch)
{
case1:System.out.println("\nEnterAProcessToCrash");
int cp=Integer.parseInt(br.readLine());
if((cp>n)||(cp<1))
{
System.out.println("InvalidProcess!EnterAValidProcess");
}
else if((prc[cp-1]==1)&&(cood!=cp))
{
prc[cp-1]=0;
System.out.println("\nProcess"+cp+"HasBeenCrashed");
}
else if((prc[cp-1]==1)&&(cood==cp))
{
prc[cp-1]=0;
election(n);
}
else
System.out.println("\nProcess"+cp+"IsAlreadyCrashed");
break;
case2:System.out.println("\nCrashedProcessesAre:\n");
for(int i=0;i<n;i++)
{
if(prc[i]==0)
System.out.println(i+1);
crash++;
}
System.out.println("EnterTheProcessYouWantToRecover");
int rp=Integer.parseInt(br.readLine());
if((rp<1)||(rp>n))
System.out.println("\nInvalidProcess.EnterAValidID");
else if((prc[rp1]==0)&&(rp>cood))
{
prc[rp-1]=1;
System.out.println("\nProcess"+rp+"HasRecovered");
cood=rp;
System.out.println("\nProcess"+rp+"IsTheNewCoordinator");
}
else if(crash==n)
{
prc[rp-1]=1;
cood=rp;
System.out.println("\nProcess"+rp+"IsTheNewCoordinator");
crash;
}
else if((prc[rp-1]==0)&&(rp<cood))
{
prc[rp-1]=1;
System.out.println("\nProcess"+rp+"HasRecovered");
}
else
System.out.println("\nProcess"+rp+"IsNotACrashedProcess");
break;
case3:
System.out.println("\nCurrentCoordinatorIs"+cood);
break;
case4:
System.exit(0);
break;
default:
System.out.println("\nInvalidEntry!");
break;
}//endswitch
}while(ch!=4);
}//endofBully()
public static void main(Stringargs[])throwsIOException
{
BullyAlgoo b=new BullyAlgo();
ob.Bully();
}
}
