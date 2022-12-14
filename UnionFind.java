/*As new students begin to arrive at college, each receives a uniqu number, 1 ton. Initially, the students do not know one another, each has a different circle of friends. As the semester progresse: other groups of friends begin to form randomly.
        There will be three arrays, each aligned by an index. The first arr will contain a query Type which will be either Friend or Total. The two arrays, students 1 and students2, will each contain a student If the query type is Friend, the two students become friends. If th query type is Total, report the sum of the sizes of each group of friends for the two students.
        Example
        n=4
        queryType=['Friend', 'Friend', 'Total'] student1 = [1, 2, 1]
        student2=[2, 3, 4]
        Initial
        Friend 12 & Friend 23
        Total 14
        3-14
        The queries are assembled, aligned by index:
        Index
        1
        queryType
        studentl
        student2
        Friend Friend
        1
        2
        2
        2
        Total
        1
        3
        4
        Students will start as discrete groups (1), (2), (3) and (4). Students and 2 become friends with the first query, as well as students 2 and 3 in the second. The new groups are (1, 2), (2, 3) and (4) which simplifies to {1, 2, 3) and (4). In the third query, the number of friends for student 1 = 3 and student 4 = 1 for a Total = 4. Notice th student is indirectly part of the circle of friends of student 1
*/




import java.util.*;
public class UnionFind {

    static int[] table,count;

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
            if((query.get(i)).equals("Friend")){
                union(student1.get(i),student2.get(i));
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
