/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.right==null && pNode.next==null){
            return null;
        }
        if(pNode.right==null && pNode.next!=null ){
            TreeLinkNode cur = pNode.next;
            while(cur.next!=null && cur.left!=pNode){
                pNode = cur;
                cur=cur.next;
            }
            if(cur.right==pNode){
                return null;
            }
            else{
                return cur;
            }
        }
        if(pNode.right!=null){
            pNode=pNode.right;
            while(pNode.left!=null){
                pNode = pNode.left;
            }

        }
        return pNode;

    }
}