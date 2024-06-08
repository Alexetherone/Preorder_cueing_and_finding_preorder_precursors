public class Main {

    static class TreeNode {
        int val;
        TreeNode left, right, parent;

        TreeNode(int val) {
            this.val = val;
            left = right = parent = null;
        }
    }

    static class PreorderPredecessor {

        public static TreeNode preorderPredecessor(TreeNode node) {
            if (node == null || node.parent == null) {
                return null;
            }

            TreeNode parent = node.parent;

            // Case 2: If node is left child of its parent, the predecessor is the parent
            if (parent.left == node) {
                return parent;
            }

            // Case 3: If node is right child, the predecessor is the deepest right child in the left subtree of its parent
            if (parent.right == node) {
                TreeNode leftChild = parent.left;
                if (leftChild != null) {
                    return findDeepestRight(leftChild);
                }
                return parent;
            }

            return null;
        }

        private static TreeNode findDeepestRight(TreeNode node) {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        // Create a sample tree
        TreeNode root = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        TreeNode node25 = new TreeNode(25);
        TreeNode node35 = new TreeNode(35);

        // Set up relationships
        root.left = node10;
        root.right = node30;
        node10.parent = root;
        node30.parent = root;
        node10.left = node5;
        node10.right = node15;
        node5.parent = node10;
        node15.parent = node10;
        node30.left = node25;
        node30.right = node35;
        node25.parent = node30;
        node35.parent = node30;

        // Find preorder predecessor
        TreeNode predecessor = PreorderPredecessor.preorderPredecessor(node15);
        if (predecessor != null) {
            System.out.println("Preorder predecessor of " + node15.val + " is " + predecessor.val);
        } else {
            System.out.println("Preorder predecessor of " + node15.val + " does not exist");
        }
    }
}
