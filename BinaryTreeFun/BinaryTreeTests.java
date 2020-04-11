import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTests {
    @Test
    public void inorderTraversal() {
        List<BinaryTree> trees = getRegularTreeTestCases();
        int[][] expected = {
                {},
                {1},
                {2, 1},
                {4, 2, 5, 1, 3, 6},
                {3, 2, 1},
                {1, 2, 3},
                {9, 7, 4, 2, 8, 5, 1, 3, 6}
        };

        for (int i = 0; i < expected.length; i++) {


            List<Integer> actual = trees.get(i).inorderRecursive();
            assertEquals(getListFromArray(expected[i]), actual);

            actual = trees.get(i).inorderIterative();
            assertEquals(getListFromArray(expected[i]), actual);
        }
    }

    @Test
    public void LCA() {
        // homework
        // get test cases from getRegularTreeTestCases()
        List<BinaryTree> trees = getRegularTreeTestCases();
        int [] expected = {2,1,1,1,1,1,2};

        for(int i = 1; i<expected.length;i++) {
            int lca = trees.get(i).LCA(1,2);
            if (i==3) {
                lca= trees.get(i).LCA(6,4);
            }else if(i == 6){
                lca = trees.get(i).LCA(9,8);
            }
            assertEquals(expected[i],lca);
        }
    }

    @Test
    public void levelOrderTraversal() {
        // homework
        List<List<List<Integer>>> list = new ArrayList<List<List<Integer>>>();

        List<List<Integer>> expected0 = new ArrayList<List<Integer>>();
        list.add(expected0);

        List<List<Integer>> expected1 = new ArrayList<List<Integer>>();
        expected1.add(new ArrayList<>(Arrays.asList(1)));
        list.add(expected1);

        List<List<Integer>> expected2 = new ArrayList<List<Integer>>();
        expected2.add(new ArrayList<>(Arrays.asList(1)));
        expected2.add(new ArrayList<>(Arrays.asList(2)));
        list.add(expected2);

        List<List<Integer>> expected3 = new ArrayList<List<Integer>>();
        expected3.add(new ArrayList<>(Arrays.asList(1)));
        expected3.add(new ArrayList<>(Arrays.asList(2,3)));
        expected3.add(new ArrayList<>(Arrays.asList(4,5,6)));
        list.add(expected3);

        List<List<Integer>> expected4 = new ArrayList<List<Integer>>();
        expected4.add(new ArrayList<>(Arrays.asList(1)));
        expected4.add(new ArrayList<>(Arrays.asList(2)));
        expected4.add(new ArrayList<>(Arrays.asList(3)));
        list.add(expected4);

        List<List<Integer>> expected5 = new ArrayList<List<Integer>>();
        expected5.add(new ArrayList<>(Arrays.asList(1)));
        expected5.add(new ArrayList<>(Arrays.asList(2)));
        expected5.add(new ArrayList<>(Arrays.asList(3)));
        list.add(expected5);

        List<List<Integer>> expected6 = new ArrayList<List<Integer>>();
        expected6.add(new ArrayList<>(Arrays.asList(1)));
        expected6.add(new ArrayList<>(Arrays.asList(2,3)));
        expected6.add(new ArrayList<>(Arrays.asList(4,5,6)));
        expected6.add(new ArrayList<>(Arrays.asList(7,8)));
        expected6.add(new ArrayList<>(Arrays.asList(9)));
        list.add(expected6);

        List<BinaryTree> trees = getRegularTreeTestCases();

        for (int i=0;i<trees.size();i++) {
            assertEquals(list.get(i),trees.get(i).levelOrderTraversal());
        }

    }

    @Test
    public void nthSmallestInBST() {
        // homework
        // extra credit
        // get test cases from getBSTTestCases()
        Integer [] expected = {null,1,1,4,1,1,2};
        List<BinaryTree> trees = getBSTTestCases();
        for (int i = 0; i<expected.length;i++) {
            assertEquals(expected[i],trees.get(i).nthSmallestInBST(1));
        }
    }

    @Test
    public void preorderTraversal() {
        List<BinaryTree> trees = getRegularTreeTestCases();
        int[][] expected = {
                {},
                {1},
                {1, 2},
                {1, 2, 4, 5, 3, 6},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 4, 7, 9, 5, 8, 3, 6}
        };

        for (int i = 0; i < expected.length; i++) {
            List<Integer> actual = trees.get(i).preorderRecursive();
            assertEquals(getListFromArray(expected[i]), actual);

            actual = trees.get(i).preorderIterative();
            assertEquals(getListFromArray(expected[i]), actual);
        }
    }

    @Test
    public void postOrderTraversal() {
        List<BinaryTree> trees = getRegularTreeTestCases();
        int[][] expected = {
                {},
                {1},
                {2, 1},
                {4, 5, 2, 6, 3, 1},
                {3, 2, 1},
                {3, 2, 1},
                {9, 7, 4, 8, 5, 2, 6, 3, 1}
        };

        for (int i = 0; i < expected.length; i++) {
            List<Integer> actual = trees.get(i).postorderRecursive();
            assertEquals(getListFromArray(expected[i]), actual);
        }
    }

    @Test
    public void height() {
        List<BinaryTree> trees = getRegularTreeTestCases();
        int[] expected = {0, 1, 2, 3, 3, 3, 5};

        for (int i = 0; i < expected.length; i++) {
            int actual = trees.get(i).height();
            assertEquals(expected[i], actual);
        }
    }

    @Test
    public void LCA_BST() {
        List<BinaryTree> trees = getBSTTestCases();
        int[][] expects = {
                {5, 7, 7},
                {7, 5, 7},
                {7, 8, 7},
                {8, 7, 7},
                {4, 6, 5},
                {6, 4, 5},
                {4, 8, 7},
                {8, 4, 7},
                {5, 9, 7},
                {9, 5, 7},
        };

        for (int i = 0; i < expects.length; i++) {
            BinaryTree tree = trees.get(3);
            assertEquals(expects[i][2],
                    tree.LCA_BST(expects[i][0],
                            expects[i][1]));
        }
    }

    private List<BinaryTree> getRegularTreeTestCases() {
        List<BinaryTree> trees = new ArrayList<>();

        // empty (root==null) tree
        trees.add(new BinaryTree());

        //      1
        //     / \
        //    N   N
        TreeNode root = new TreeNode(1);
        trees.add(new BinaryTree(root));

        //      1
        //     / \
        //    2   N
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        trees.add(new BinaryTree(root));

        //      1
        //     /  \
        //    2    3
        //   / \    \
        //  4   5    6
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        trees.add(new BinaryTree(root));

        //          1
        //         /
        //        2
        //       /
        //      3
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        trees.add(new BinaryTree(root));

        //          1
        //           \
        //            2
        //             \
        //              3
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        trees.add(new BinaryTree(root));

        //             1
        //            /  \
        //           2    3
        //          /  \    \
        //         4    5    6
        //        /    /
        //       7    8
        //      /
        //     9
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        trees.add(new BinaryTree(root));

        return trees;
    }

    private List<BinaryTree> getBSTTestCases() {
        List<BinaryTree> trees = new ArrayList<>();

        // empty (root==null) tree
        trees.add(new BinaryTree());

        //      1
        //     / \
        //    N   N
        TreeNode root = new TreeNode(1);
        trees.add(new BinaryTree(root));

        //      2
        //     / \
        //    1   N
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        trees.add(new BinaryTree(root));

        //      7
        //     /  \
        //    5    8
        //   / \    \
        //  4   6    9
        root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
        trees.add(new BinaryTree(root));

        //          3
        //         /
        //        2
        //       /
        //      1
        root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        trees.add(new BinaryTree(root));

        //          1
        //           \
        //            2
        //             \
        //              3
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        trees.add(new BinaryTree(root));

        //             9
        //            /  \
        //           5    11
        //          /  \    \
        //         4    8    13
        //        /    /    /  \
        //       3    6    12   18
        //      /
        //     2
        root = new TreeNode(9);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(3);
        root.left.left.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(11);
        root.right.right = new TreeNode(13);
        root.right.right.left = new TreeNode(12);
        root.right.right.right = new TreeNode(18);
        trees.add(new BinaryTree(root));
        return trees;
    }

    private List<Integer> getListFromArray(int[] data) {
        return Arrays.stream(data).boxed().collect(Collectors.toList());
    }
}