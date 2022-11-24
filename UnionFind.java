import java.net.Inet4Address;
import java.util.*;
public class UnionFind {

    static int[] table,count;
            //= new int[100001];

    static int root(int a){
        int i =a;
        while(i != table[i]){
            i = table[i];
        }
        return i;
    }
    static void union (int a, int b){
        int rootB = root(b);
        int rootA = root(a);
        if(rootA == rootB) return;
        table[rootA] = rootB;
        count[rootB]+=count[rootA];
    }


    public static List<Integer> getTheGroup(int n,List<String> query, List<Integer>student1, List<Integer> student2) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<query.size();i++){
//            String s= query.get(i);
            if((query.get(i)).equals("Friend")){
                union(student1.get(i),student2.get(i));
//                table[root(student1.get(i))] = root(student2.get(i));
            }
            else{
//                int reqRoot = root(student1.get(i));
//                int count1=0, count2=0;
                int root1 = root(student1.get(i));
                int root2 = root(student2.get(i));
//                for(int j=1;j<=n;j++){
//                    int tempRoot = root(j);
//                    if(tempRoot == root1) count1++;
//                    if(tempRoot == root2) count2++;
//
//                }
                if(root1 == root2) result.add(count[root1]);
                else result.add(count[root1] + count[root2]);
            }
        }
        return result;
    }




    public static void main(String[] args){
        int n, q;
        Scanner sc = new Scanner(System.in);
//        System.out.println(" Enter no. of students");
        n = sc.nextInt();
//        System.out.println(" Enter size of queries");
        q= sc.nextInt();
//        System.out.println("Enter queries");
        List<String> query = new ArrayList<String>();
        for(int i=0;i<q;i++){
            query.add(sc.next());
        }
//        System.out.println("Enter queries");
        List<Integer> student1 = new ArrayList<Integer>();
        List <Integer> student2 = new ArrayList<Integer>();
//        System.out.println("Enter queries");
        for(int i=0;i<q;i++){
            student1.add(sc.nextInt());
        }
        for(int i=0;i<q;i++){
            student2.add(sc.nextInt());
        }
        table = new int[n+1];
        count = new int[n+1];
        for(int i=1;i<=n;i++){
            table[i] = i;
            count[i] = 1;
        }
        List<Integer> ans = new ArrayList<Integer>();
        ans = getTheGroup(n,query, student1, student2);
        System.out.println(ans.toString());
    }
}
