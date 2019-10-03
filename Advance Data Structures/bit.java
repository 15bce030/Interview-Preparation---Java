import  java.util.*;
public class bit {


    static long bit[];
    public static void main(String[] args) {

Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        bit=new long[n+1];
        long a[]=new long[n+1];
        for(int i=1;i<=n;i++){
            a[i]=in.nextInt();
            update(i,a[i]);
        }

        System.out.println(query(5));




    }
    static  void update(int x,long val){
        for(;x<bit.length;x+=x&-x){
            bit[x]+=val;
        }
    }
    static long query(int x){
        long sum=0;
        for(;x>0;x-=x&-x){
            sum=sum+bit[x];
        }
        return sum;
    }






}
