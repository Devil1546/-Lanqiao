package com.ljp.leecode_cn.DFS;

import com.ljp.leecode_cn.other.data_structure.TreeNode;

/**

 617. 合并二叉树
 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

 示例 1:

 输入:
 Tree 1                     Tree 2
 1                         2
 / \                       / \
 3   2                     1   3
 /                           \   \
 5                             4   7
 输出:
 合并后的树:
 3
 / \
 4   5
 / \   \
 5   4   7
 */
public class _简单_617_合并二叉树 {
    //错误方法
    /*public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }else if(t1 == null){
            t2.left = mergeTrees(t2.left, null);
            t2.right = mergeTrees(t2.right, null);
            return t2;
        }else if(t2 == null){
            mergeTrees(t1.left, null);
            mergeTrees(t1.right, null);
            return t1;
        }else{
            t1.val += t2.val;
            mergeTrees(t1.left, t2.left);
            mergeTrees(t1.right, t2.right);
            return t1;
        }
    }*/

    /**
     * 官方题解
     * @param t1
     * @param t2
     * @return
    执行用时：
    1 ms, 在所有 Java 提交中击败了63.86%的用户
    内存消耗：
    39.2 MB, 在所有 Java 提交中击败了8.38%的用户
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode merge = new TreeNode(t1.val + t2.val);
        merge.left = mergeTrees(t1.left, t2.left);
        merge.right = mergeTrees(t1.right, t2.right);
        return merge;
    }
}
