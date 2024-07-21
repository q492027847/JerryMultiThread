package com.jerry.study.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class 二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        return travers(root, val);
    }

    TreeNode travers(TreeNode root, int cnt) {
        if (root == null) {
            return null;
        }
        if (root.val == cnt) {
            return root;
        }
        if (root.val < cnt) {
            return travers(root.right, cnt);
        } else {
            return travers(root.left, cnt);
        }
    }


}


class 二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }

    TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insert(root.left, val);
        }
        if (root.val < val) {
            root.right = insert(root.right, val);
        }
        return root;
    }
}

class 删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }


    TreeNode delete(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.val == key) {
            // 这里做删除操作
            // 1,如果左右都null 这直接删除
            if (root.left == null && root.right == null){
                return null;
            }
            // 2 如果只有一个自己节点，那么用他的子节点代替他自己
            if (root.left != null && root.right == null){
                return root.left;
            }
            if (root.right != null && root.left == null){
                return root.right;
            }
            // 3 如果两个节点都不为null 情况比较复杂
              // 找到最小的右子树节点
            if (root.right != null && root.left != null){
                TreeNode minNode = getMinNode(root.right);
                // 替换
                root.val = minNode.val;
                // 删除最小节点
                root.right = delete(root.right, minNode.val);
            }
        }
        if (root.val < key) {
            root.right = delete(root.right, key);
        }
        if (root.val > key) {
            root.left = delete(root.left, key);
        }
        return root;
    }

    TreeNode getMinNode(TreeNode root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }


}


class 不同的二叉搜索树{
    public int numTrees(int n) {
        int count = count(1, n);
        return count;
    }

    int count(int low, int hi){
        if (low > hi){
            return 1;
        }
        int res = 0;
        for (int i = low; i <= hi; i++) {
            int left = count(low,i-1);
            int right = count(i+1,hi);
            res  += left * right;
        }
        return res;
    }
}

class 不同的二叉搜索树II{
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<>();
        }
        return build(0, 1);
    }

    List<TreeNode> build(int low, int hi){
        List<TreeNode> res = new LinkedList<>();
        if (low > hi){
            res.add(null);
            return res;
        }
        for (int i = low; i <= hi; i++) {
            List<TreeNode> left = build(low,i-1);
            List<TreeNode> right = build(i+1,hi);
            for (TreeNode treeNode : left) {
                for (TreeNode node : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = treeNode;
                    root.right = node;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
