import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
  }

public class Main {
    public static List<List<Integer>> ret = new ArrayList<>();
    public static List<List<Integer>> binaryTreemaxPaths(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        help(root,list);
        return ret;
    }

    public static void help(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            list.add(node.val);
            ret.add(new ArrayList<>(list));
        }
        else{

            List<Integer> list2 = new ArrayList<>(list);
            list2.add(node.val);
            help(node.left,list2);
            help(node.right,list2);


//如下行error的根源所在
//错误原因：help（left）完之后list在原先的基础上加了数，但是因为函数没有递归，所以list不会
//重置为原来的状态，这个时候再去help（right）的话传入的list其实是比本来想传入的list更长
//            list.add(node.val);
//            help(node.left,list);
//            help(node.right,list);
        }
    }


    public static TreeNode build() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = F;
        C.right = G;
        return A;
    }
    public static void main(String[] args) {
        TreeNode root = build();
        binaryTreemaxPaths(root);
        for(int i=0;i<ret.size();i++){
            for(int j=0;j<ret.get(i).size();j++){
                System.out.print(ret.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }


}
