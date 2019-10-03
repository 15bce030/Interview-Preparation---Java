import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Lenovo on 10-07-2017.
 */
public class lru {

    static class node{

        int val;
        int key=0;
        node prv;
        node next;

        public node(int a){
            val=a;
            prv=null;
            next=null;

        }

    }
    static node head=null;
    static  node end=null;
    static int k=0;
static HashMap <Integer,node> map=new HashMap<>();
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int cap=in.nextInt();
        k=cap;
        set(1,10);
        set(5,12);
        System.out.println(get(5));
        System.out.println(get(1));
       set(6,14);
        System.out.println(get(5));





    }

    static  int get(int key){

        if(map.containsKey(key)){
            node n=map.get(key);

            int p=n.val;
            remove(n);
            add(n);
            return p;


        }
        return -1;

    }
    static void set(int key,int val){

        if(map.containsKey(key)){

            node n=map.get(key);
            n.val=val;
            n.key=key;
            remove(n);
            add(n);
        }
        else{

            if(map.size()>=k){
                int po=end.key;
                remove(end);
          //    System.out.println(key+" "+val+" "+end.key+" "+end.val);
                map.remove(po);
                node n=new node(val);
                map.put(key,n);
                n.key=key;
                add(n);
            }
            else{
                node n=new node(val);
                n.key=key;
                map.put(key,n);
                add(n);
            }

        }





    }

    static  void remove(node n){

        if(n.prv!=null){
            n.prv.next=n.next;
        }
        else{
            head=n.next;
        }

        if(n.next!=null){
            n.next.prv=n.prv;
        }
        else{
            end=n.prv;
        }

    }
    static  void add(node n){
if(head!=null)
       // System.out.println(head.val+" "+n.val);
        n.next=head;
        n.prv=null;
        if(head!=null){
            head.prv=n;
        }
        head=n;

    }














}
