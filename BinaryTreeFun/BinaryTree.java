import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }


    public List<Integer> inorderIterative() {
        // homework
        List<Integer> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(!stack.isEmpty() || node !=null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode a = stack.pop();//go back to the last node found
                result.add(a.val);
                node = a.right;
            }
        }
        return result; // place holder
    }


    public Integer LCA(int v1, int v2) {
        // homework
        return LCA(root,v1,v2);
    }
    private Integer LCA(TreeNode node, int v1, int v2) {//https://java2blog.com/lowest-common-ancestor-of-binary-tree/
        //this website really helped me
        if (node == null) {
            return null;
        }
        if (node.val==v1 || node.val==v2) {
            return node.val;
        }

        Integer left = LCA(node.left, v1, v2);
        Integer right = LCA(node.right, v1, v2);

        if (left!=null && right!=null) {
            return node.val;
        }
        if(left==null) {
            return right;
        }else {
            return left;
        }
    }

    public List<List<Integer>> levelOrderTraversal() {
        // homework
        // to be done iteratively

        //https://www.geeksforgeeks.org/print-level-order-traversal-line-line/
        //this website helped me a ton
        List<List<Integer>>  list = new ArrayList<List<Integer>>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        int i = 0;
        stack.push(root);

        while (true) {
            int count = stack.size();
            if(count==0) {
                break;
            }
            list.add(new ArrayList<Integer>());
            while (count>0) {
                TreeNode node = stack.firstElement();
                list.get(i).add(node.val);
                stack.remove(0);

                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                count--;
            }
            i++;
        }
        return list; // place holder
    }
    public void lOTPop(List<List<Integer>>  list, TreeNode node ) {

    }

    public Integer nthSmallestInBST(int n) {
        // homework
        return nthSmallestInBST(n,root);
    }

    private Integer nthSmallestInBST(int n, TreeNode node) {

        if (node==null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || node !=null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode a = stack.pop();//go back to the last node found
                result.add(a.val);
                node = a.right;
            }

        }
        return result.get(n-1);
    }

    private void preorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorderRecursive(node.left, result);
        preorderRecursive(node.right, result);
    }

    public List<Integer> preorderRecursive() {
        List<Integer> result = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        preorderRecursive(root, result);
        System.out.println(result.equals(d));
        return result;
    }

    public List<Integer> preorderIterative() {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int height() {
        return height(root);
    }

    private Integer LCA_BST(TreeNode node, int v1, int v2) {
        if (node == null) {
            return null;
        }

        int min = Math.min(v1, v2);
        int max = Math.max(v1, v2);

        if (node.val >= min && node.val <= max) {
            return node.val;
        }

        if (node.val < min) {
            return LCA_BST(node.right, v1, v2);
        }

        return LCA_BST(node.left, v1, v2);
    }

    public int LCA_BST(int v1, int v2) {
        return LCA_BST(root, v1, v2);
    }

    private void postorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        postorderRecursive(node.left, result);
        postorderRecursive(node.right, result);
        result.add(node.val);
    }

    List<Integer> postorderRecursive() {
        List<Integer> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }

    private void inorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderRecursive(node.left, result);
        result.add(node.val);
        inorderRecursive(node.right, result);
    }

    public List<Integer> inorderRecursive() {
        List<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }
}