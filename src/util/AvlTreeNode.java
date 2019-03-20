package util;

public class AvlTreeNode {
    private int data;
    AvlTreeNode father;
    AvlTreeNode left;
    AvlTreeNode right;
    int height;

    public AvlTreeNode getFather() {
        return father;
    }

    public void setFather(AvlTreeNode father) {
        this.father = father;
    }



    public AvlTreeNode(int data, AvlTreeNode father, AvlTreeNode left, AvlTreeNode right) {
        this.data = data;
        this.father = father;
        this.left = left;
        this.right = right;
    }


    public AvlTreeNode(int data) {
        this.data = data;
    }

    public AvlTreeNode(int data, AvlTreeNode left, AvlTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public AvlTreeNode getLeft() {
        return left;
    }

    public void setLeft(AvlTreeNode left) {
        this.left = left;
    }

    public AvlTreeNode getRight() {
        return right;
    }

    public void setRight(AvlTreeNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
