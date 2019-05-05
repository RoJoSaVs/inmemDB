package Logic.BinaryStringTree;

/**
 * Your comments go here!
 */

public class StringAVLTreeSet extends StringTreeSet {

    protected StringTreeNode add(StringTreeNode node, String value) {
        node = super.add(node, value);
        node = rebalance(node);
        return node;
    }

    // IMPLEMENT THIS!
    protected StringTreeNode remove(StringTreeNode node, String value) {
        return null;
    }

    /**
     * If the BST rooted at the given node does not maintain the AVL tree
     * balance condition, restores the AVL tree property for this BST through
     * rotations.  This method assumes that the node passed in is the deepest
     * node in the BST that may have an imbalance.
     * @param node
     * @return
     */
    protected StringTreeNode rebalance(StringTreeNode node) {
        int bf = balanceFactor(node);
        if (bf < -1) {
            if (balanceFactor(node.left) < 0) {   // case 1 (LL)
                node = rightRotate(node);
            } else {                              // case 2 (LR)
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } else if (bf > 1) {
            // take care of symmetric cases
            //      case 3 (RL)
            //      case 4 (RR)
        }

        return node;
    }

    // IMPLEMENT THIS!
    private StringTreeNode leftRightRotate(StringTreeNode parent) {
        return null;
    }

    // IMPLEMENT THIS!
    private StringTreeNode leftRotate(StringTreeNode parent) {
        return null;
    }

    /**
     * Right rotates the parent, the parent's left child, and the parent's left
     * child's right subtree in order to fix the LL case.
     * @param parent
     * @return
     */
    private StringTreeNode rightRotate(StringTreeNode parent) {
        // 1. detach left child's right subtree
        StringTreeNode leftright = parent.left.right;

        // 2. consider left child to be the new parent
        StringTreeNode newParent = parent.left;

        // 3. attach old parent onto right of new parent
        newParent.right = parent;

        // 4. attach old left child's old right subtree as
        //    left subtree of new right child
        newParent.right.left = leftright;

        parent.height = computeHeight(parent);
        newParent.height = computeHeight(newParent);

        return newParent;
    }

    // IMPLEMENT THIS!
    private StringTreeNode rightLeftRotate(StringTreeNode parent) {
        return null;
    }
}
