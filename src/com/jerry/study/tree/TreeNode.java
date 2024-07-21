package com.jerry.study.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

class 二叉树的最大深度 {
    int res = 0;
    int dept = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMath = maxDepth(root.left);
        int tightMath = maxDepth(root.right);
        return Math.max(leftMath, tightMath) + 1;
    }

    public int maxDepth1(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode node) {
        if (node == null) {
            res = Math.max(res, dept);
            return;
        }
        dept++;
        traverse(node.left);
        traverse(node.right);
        dept--;
    }
}


class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        traverse(node.left);
        traverse(node.right);
    }
}

class 填充每个节点的下一个右侧节点指针 {
    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return root;
        }
        traverse(root.left, root.right);
        return root;
    }

    void traverse(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        // 连接当前层级两个节点
        node1.next = node2;
        // 连接相同父子节点的两个节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // 连接不同父子节点的两个节点
        traverse(node1.right, node2.left);
    }
}

class 二叉树展开为链表 {


    void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}

class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int low, int hi) {
        if (low > hi) {
            return null;
        }
        int maxNum = Integer.MIN_VALUE;
        int index = -1;
        for (int i = low; i <= hi; i++) {
            maxNum = Math.max(maxNum, nums[i]);
            if (maxNum == nums[i]) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxNum);
        root.left = build(nums, low, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }
}

class 从前序与中序遍历序列构造二叉树 {
    Integer index = 0;
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        TreeNode build = build(preorder, inorder, 0, inorder.length - 1);
        return build;
    }


    TreeNode build(int[] preorder, int[] inorder, int low, int hi) {
        if (low > hi) {
            index--;
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int i = valToIndex.get(root.val);
        index++;
        root.left = build(preorder, inorder, low, i - 1);
        index++;
        root.right = build(preorder, inorder, i + 1, hi);
        return root;
    }
}

class 从中序与后序遍历序列构造二叉树 {
    Integer index = 0;
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length - 1;
        for (int i = inorder.length - 1; i >= 0; i--) {
            valToIndex.put(inorder[i], i);
        }
        TreeNode build = build(inorder, postorder, 0, inorder.length - 1);
        return build;
    }


    TreeNode build(int[] inorder, int[] postorder, int low, int hi) {
        if (low > hi) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int i = valToIndex.get(root.val);
        index--;
        root.right = build(inorder, postorder, i + 1, hi);
        index--;
        root.left = build(inorder, postorder, low, i - 1);


        return root;
    }


}

class 根据前序和后序遍历构造二叉树 {
    Map<Integer, Integer> valToIndexvalToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndexvalToIndex.put(postorder[i], i);
        }
        return bulid(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode bulid(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        int leftVal = preorder[preStart + 1];
        int index = valToIndexvalToIndex.get(leftVal);
        int leftSize = index - postStart + 1;

        // 构建root
        TreeNode root = new TreeNode(rootVal);
        root.left = bulid(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
        root.right = bulid(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);
        return root;
    }


    class 二叉搜索树中第K小的元素 {
        int req = 0;
        int num = 0;
        public int kthSmallest(TreeNode root, int k) {
            traverse(root,k);
            return req;
        }

        void traverse(TreeNode root, int k){
            if (root == null){
                return;
            }
            traverse(root.left,k);
            num++;
            if (num == k){
                req = root.val;
                return;
            }
            traverse(root.right,k);
        }


    }

    public static void main(String[] args) {
        根据前序和后序遍历构造二叉树 a = new 根据前序和后序遍历构造二叉树();
        a.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
    }

    class 把二叉搜索树转换为累加树 {

        public TreeNode bstToGst(TreeNode root) {
            traverse(root);
            return root;
        }

        int num = 0;

        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            traverse(root.right);
            num = num + root.val;
            root.val = num;
            traverse(root.left);
        }
    }


    class 验证二叉搜索树{
        public boolean isValidBST(TreeNode root) {
            return traverse(root,null,null);
        }


        boolean traverse(TreeNode root,TreeNode min,TreeNode max){
            if (root == null){
                return true;
            }
            if (min != null && root.val <= min.val){
                return false;
            }
            if (max != null && root.val >= max.val){
                return false;
            }
            return traverse(root.left,min,root) && traverse(root.right,root,max);

        }
    }
}

