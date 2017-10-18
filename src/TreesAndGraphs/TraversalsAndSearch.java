package TreesAndGraphs;

import Helpers.TreeNode;

import java.util.Stack;

/**
 * Created by Darien on 5/1/2016.
 */
public class TraversalsAndSearch {

    public static void main(String[] args) {

    }

    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.getLeft());
            root.setVisited(true);
            inorderTraversal(root.getRight());
        };
    }

    public void depthFirstSearchStructured(TreeNode root){
        if(root != null){
            Stack<TreeNode> dfsStack = new Stack<TreeNode>();
            dfsStack.push(root);
            while(!dfsStack.isEmpty()){
                TreeNode node = dfsStack.pop();
                node.setVisited(true);
                dfsStack.push(node.getRight());
                dfsStack.push(node.getLeft());
            }
        }
    }

    public void depthFirstSearchRecursive(TreeNode root){ //same Preorder Traversal
        if(root != null){
            root.setVisited(true);
            depthFirstSearchStructured(root.getLeft());
            depthFirstSearchStructured(root.getRight());
        }
    }
}
