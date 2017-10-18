package Helpers;

/**
 * Created by Darien on 5/1/2016.
 */
public class TreeNode<E extends Comparable<E>> {
    private E data;
    private TreeNode<E> left;
    private TreeNode<E> right;
    private TreeNode<E> parent;
    private boolean visited = false;

    ///////////////////////////
    public TreeNode(E newData) {
        this.data = newData;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    public TreeNode(E data, TreeNode<E> parent) {
        super();
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
    public E getData() {
        return data;
    }
    public void setData(E data) {
        this.data = data;
    }
    public TreeNode<E> getLeft() {
        return left;
    }
    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }
    public TreeNode<E> getRight() {
        return right;
    }
    public void setRight(TreeNode<E> right) {
        this.right = right;
    }
    public TreeNode<E> getParent() {
        return parent;
    }
    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    // /////////////////////////////////////////
    public String showData() {
        if (this == null)
            return "null";
        return "\nData: " + data
                + "\tLeft: " + getValue(left)
                + "\tRight: " + getValue(right)
                + "\tParent: " + getValue(parent);
    }
    public E getValue(TreeNode<E> node){
        if (node == null)
            return null;
        else
            return node.getData();
    }
    // /////////////////////////////////////////
    public int compareTo(TreeNode<E> otherTreeNode) {
        return this.getData().compareTo(otherTreeNode.getData());
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
