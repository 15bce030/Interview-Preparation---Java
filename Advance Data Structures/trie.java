import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Lenovo on 07-07-2017.
 */
public class trie {

    public static void main(String[] args) {


        node root=new node();
        ArrayList <String> list=new ArrayList<>();

        list.add("abcd");
        list.add("abgl");
        list.add("gt");
        list.add("lnm");

        for(int i=0;i<list.size();i++){
            insert(root,list.get(i));
        }

        System.out.println(wsearch(root,"abcd"));
        System.out.println(wsearch(root,"abc"));
        System.out.println(presearch(root,"abc"));
        System.out.println(wsearch(root,"cd"));
        System.out.println(wsearch(root,"abgl"));
        System.out.println(wsearch(root,"gt"));
        System.out.println(wsearch(root,"lnm"));
        System.out.println(wsearch(root,"ln"));
        System.out.println(wsearch(root,"fdjfk"));

    }
    static class  node{

        HashMap<Character,node> map;
        boolean l;

        node(){
            map=new HashMap<>();
            l=false;
        }

    }

static  void insert(node root,String s){

       char c[]=s.toCharArray();
       node temp=root;
       for(int i=0;i<c.length;i++)
       {
           node r=temp.map.get(c[i]);
           if(r==null){
               r=new node();
               temp.map.put(c[i],r);
           }
           temp=r;
       }
       temp.l=true;
}

static  boolean wsearch(node root,String s){
    char c[]=s.toCharArray();
    node temp=root;
    for(int i=0;i<c.length;i++)
    {
        node r=temp.map.get(c[i]);
        if(r==null){
            return false;
        }
        temp=r;
    }
    return temp.l;
}
static  boolean presearch(node root,String s){
    node temp=root;
    char c[]=s.toCharArray();
    for(int i=0;i<c.length;i++){
        node r=temp.map.get(c[i]);
        if(r==null){
            return false;
        }

        temp=r;
    }
    return true;

}

}
