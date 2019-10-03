/**
 * Created by Lenovo on 07-07-2017.
 */
import static java.lang.Math.*;
public class segmenttree {

    public static void main(String []args)
    {
        new Thread(null, new Main(), "Check2", 1 << 28).start();
    }
    public void run() {
        long a[]={1,3,5,7,9,11};
        intialisze(a.length);
        create(0,a.length-1,a,1);
        update(0,a.length-1,1,10-a[1],1);

    }
     long x[];
     long merge(long a,long b){
        return min(a,b);
    }
      void intialisze(int n){
        x=new long[4*n+1];
    }
     long create(int l,int r,long a[],int i){                     // segment tree indexed at 1 , i---> 1 else i---> 0;

        if(l>r){
            return Long.MAX_VALUE;
        }
        if(l==r){
            x[i]=a[l];
            return a[l];
        }
        int mid=(l+r)/2;
        x[i]=merge(create(l,mid,a,2*i),create(mid+1,r,a,2*i+1));
        return x[i];
    }
      long get(int l,int r,int lr,int rr,int i){                                    // lr -> lrange,  rr-> rrange
        if(lr<=l&&rr>=r){
            return x[i];
        }
        if(r<lr||l>rr){
            return Long.MAX_VALUE;
        }
        int mid=(l+r)/2;
        long val= merge(get(l,mid,lr,rr,2*i),get(mid+1,r,lr,rr,2*i+1));
        return val;
    }
    long update(int l,int r,int i,long dif,int target){
            if(target<l||target>r){
                return Long.MAX_VALUE;
            }
            if(l==r&&target==l){
                x[i]=dif;
                return x[i];
            }
            int mid=(l+r)/2;
         long a=update(l, mid, 2 * i , dif, target);
         long b=update(mid + 1, r, 2 * i + 1, dif, target);
            x[i]=merge(x[2*i],x[2*i+1]);
            return x[i];
        }
}
