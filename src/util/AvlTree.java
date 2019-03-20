package util;

//avl树
public class AvlTree {
    private AvlTreeNode root;

    public AvlTree(AvlTreeNode root) {
        this.root = root;
    }

    public AvlTreeNode getRoot() {
        return root;
    }

    public void setRoot(AvlTreeNode root) {
        this.root = root;
    }
    //树的深度
    public static int depth(AvlTreeNode avlTreeNode){
        if (avlTreeNode==null)
            return 0;
        else {
            int left=depth(avlTreeNode.getLeft());
            int right=depth(avlTreeNode.getRight());
            return 1+Math.max(left,right);
        }
    }
    //插入avltree
    public AvlTreeNode insert(int value, AvlTreeNode avlTreeNode,AvlTreeNode avlTreeNodeFather){
        if (avlTreeNode==null)
            return new AvlTreeNode(value,avlTreeNodeFather,null,null);
        else if (value>avlTreeNode.getData()){
            avlTreeNode.setRight(insert(value,avlTreeNode.getRight(),avlTreeNode));
        }
        else if (value<avlTreeNode.getData()){
            avlTreeNode.setLeft(insert(value,avlTreeNode.getLeft(),avlTreeNode));
        }
        else ;
        avlTreeNode.height=depth(avlTreeNode);
        return balance(avlTreeNode);
    }
    //平衡二叉树
    public AvlTreeNode balance(AvlTreeNode avlTreeNode) {
        if (avlTreeNode==null){
            return avlTreeNode;
        }
        if (depth(avlTreeNode.getLeft())-depth(avlTreeNode.getRight())>=2){
            if (depth(avlTreeNode.getLeft().getLeft())>depth(avlTreeNode.getLeft().getRight())){
                rotateWithLeftChild(avlTreeNode);//单旋转
            }
            else
                doubleWithLeftChild(avlTreeNode);//双旋转
        }
        if (depth(avlTreeNode.getRight())-depth(avlTreeNode.getLeft())>=2){
            if (depth(avlTreeNode.getRight().getRight())>depth(avlTreeNode.getRight().getLeft())){
                rotateWithRightChild(avlTreeNode);
            }
            else
                doubleWithRightChild(avlTreeNode);
        }
        return avlTreeNode;
    }
    //右双旋转
    public void doubleWithRightChild(AvlTreeNode avlTreeNode) {
    }

    //右单旋转
    public void rotateWithRightChild(AvlTreeNode avlTreeNode) {
        avlTreeNode.getRight().setFather(avlTreeNode.getFather());
        avlTreeNode.setFather(avlTreeNode.getRight());
    }

    //左双旋转
    public void doubleWithLeftChild(AvlTreeNode avlTreeNode) {
        avlTreeNode.getFather();
        avlTreeNode.getLeft().getRight().setRight(avlTreeNode);
        avlTreeNode.getLeft().getRight().setLeft(avlTreeNode.getLeft());
    }
    //左单旋转
    public void rotateWithLeftChild(AvlTreeNode avlTreeNode) {
        AvlTreeNode avlTreeNode1=avlTreeNode.getLeft();
        avlTreeNode.setLeft(avlTreeNode1.getRight());
        avlTreeNode1.setRight(avlTreeNode);

    }
    //中序遍历
    public void mid(AvlTreeNode avlTreeNode){
        if (avlTreeNode.getLeft()!=null) {
            mid(avlTreeNode.getLeft());
        }
        printNode(avlTreeNode);
        if (avlTreeNode.getRight()!=null){
            mid(avlTreeNode.getRight());
        }
    }
    public void printNode(AvlTreeNode avlTreeNode){
        System.out.println(avlTreeNode.getData());
    }
}
