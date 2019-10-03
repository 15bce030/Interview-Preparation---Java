public class lazy_propogation implements Runnable {

    public static void main(String[] args) {
        new Thread(null, new lazy_propogation(), "Check2", 1 << 28).start();
    }
    public void run(){

        intialize(5);
        updateRange(1,1,5,2,4,2);
        updateRange(1,1,5,3,4,3);
        System.out.println(queryRange(1,1,5,2,4));
        System.out.println("kk");

    }
    long lazy[],x[];
    void intialize(int n){
        lazy=new long[4*n+1];
        x=new long[4*n+1];
    }
    long merge(long a,long b){return a+b;}
    void updateRange(int i,int start,int end,int l,int r,long val){

        if(lazy[i]!=0){                                      // not lazy, then update..
            x[i]+=(long)(end-start+1)*(lazy[i]);
              if(start!=end) {
                 lazy[2*i]+=lazy[i];
                lazy[2*i+1]+=lazy[i];
              }
            lazy[i]=0;
        }
        if(start>end||(end<l)||(start>r))return;                // out range...

        if(start>=l&&end<=r){                                   // complete in range...
            x[i]+=(long)(end-start+1)*(val);
            if(start!=end){
                lazy[2*i]+=val;
                lazy[2*i+1]+=val;
            }
           return;
        }
        int mid=(start+end)/2;
        updateRange(2*i,start,mid,l,r,val);
        updateRange(2*i+1,mid+1,end,l,r,val);
        x[i]=merge(x[2*i],x[2*i+1]);
    }
    long queryRange(int i,int start,int end,int l,int r){
        if(start>end||(end<l)||(start>r))return 0;                // out range...

        if(lazy[i]!=0){                                      // not lazy, then update..
            x[i]+=(long)(end-start+1)*(lazy[i]);
            if(start!=end) {
                lazy[2*i]+=lazy[i];
                lazy[2*i+1]+=lazy[i];
            }
            lazy[i]=0;
        }
        if(start>=l&&end<=r){
            return x[i];
        }
        int mid=(start+end)/2;
        long p1=queryRange(2*i,start,mid,l,r);
        long p2=queryRange(2*i+1,mid+1,end,l,r);
        return merge(p1,p2);
    }

}
