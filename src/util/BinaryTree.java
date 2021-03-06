package util;

import java.util.Stack;

public class BinaryTree {
    //
    private Binarynode root;

    public BinaryTree() {
    }

    public BinaryTree(Binarynode root) {
        this.root = root;
    }

    public Binarynode getRoot() {
        return root;
    }

    public void setRoot(Binarynode root) {
        this.root = root;
    }


    //初始化树
    public Binarynode init(){
        Binarynode j=new Binarynode(2);
        Binarynode i=new Binarynode(7);
        Binarynode h=new Binarynode(8);
        Binarynode g=new Binarynode(4);
        Binarynode f=new Binarynode(9,j);
        Binarynode e=new Binarynode(6,i);
        Binarynode d=new Binarynode(5,g,h);
        Binarynode c=new Binarynode(17,null,f);
        Binarynode b=new Binarynode(19,d,e);
        Binarynode a=new Binarynode(21,b,c);
        return a;
    }
    //打印root值
    public void printroot(Binarynode binarynode){
        System.out.println(binarynode.getRoot());
    }

    //先序遍历
    public void preorder(Binarynode binarynode){
       printroot(binarynode);
       if (binarynode.getLeft()!=null){
           preorder(binarynode.getLeft());
       }
       if (binarynode.getRight()!=null){
           preorder(binarynode.getRight());
       }

    }
    public void theFirstTraversal_Stack(Binarynode binarynode) {  //先序遍历
        Stack<Binarynode> stack = new Stack<Binarynode>();
        Binarynode b = binarynode;
        while (b != null || stack.size() > 0) {  //将所有左孩子压栈
            if (b != null) {   //压栈之前先访问
                printroot(b);
                stack.push(b);
                b = b.getLeft();
            } else {
                b = stack.pop();
                b = b.getRight();
            }
        }
    }
    //中序遍历
    public void midorder(Binarynode binarynode){
        if (binarynode.getLeft()!=null){
            midorder(binarynode.getLeft());
        }
        printroot(binarynode);
        if (binarynode.getRight()!=null){
            midorder(binarynode.getRight());
        }

    }

    //插入(选择指定节点插入到左子树)
    public void insertLeft(Binarynode insertnode,Binarynode value){
        value.setLeft(insertnode.getLeft());
        insertnode.setLeft(value);
    }
    //右边
    public void insertRight(Binarynode insertnode,Binarynode value){
        value.setRight(insertnode.getRight());
        insertnode.setRight(value);
    }

    /**
     * 查询某数是否在树中
     * @param param
     * @param binarynode(从这个节点开始)
     * @return
     */
    public boolean querynode(int param,Binarynode binarynode){
        int flag=-1;
        if (binarynode==null)
            return false;
        if (binarynode.getRoot()==param){
            flag=1;
        }
        if (flag!=1){
            return querynode(param,binarynode.getLeft());

        }if (flag!=1){
            return querynode(param,binarynode.getRight());
        }
        else
            return true;
    }

    //按照二叉查找树进行插入
    public Binarynode insert(int insertvalue,Binarynode rootnode){
        if (rootnode==null){
            return new Binarynode(insertvalue,null,null);
        }
        if (insertvalue<rootnode.getRoot()){

            rootnode.setLeft(insert(insertvalue,rootnode.getLeft()));
        }
        else if (insertvalue>rootnode.getRoot()){

            rootnode.setRight(insert(insertvalue,rootnode.getRight()) );
        }
        else ;//等于的情况
        return rootnode;
    }
    //查找最小值
    public Binarynode findMin(Binarynode binarynode){
        if (binarynode==null)
            return null;

        while (binarynode.getLeft()!=null){
            binarynode=binarynode.getLeft();
        }
        return binarynode;
    }

    //删除最小值（未完成）
    public Binarynode removeMin(Binarynode binarynode){
        if (binarynode==null)
            return new Binarynode(-1,null,null);
        binarynode.setLeft(removeMin(binarynode.getLeft()));
        return binarynode;

    }
    //二叉树中删除
    public Binarynode del(int value,Binarynode binarynode){
        if (binarynode==null)
            return binarynode;
        if (value<binarynode.getRoot()){
            binarynode.setLeft(del(value,binarynode.getLeft()));
        }
        else if (value>binarynode.getRoot()){
            binarynode.setRight(del(value,binarynode.getRight()));
        }
        else if (binarynode.getRight()!=null&&binarynode.getLeft()!=null){//有双节点
            binarynode.setRoot(findMin(binarynode.getRight()).getRoot());//替换
            binarynode.setRight(del(binarynode.getRoot(),binarynode.getRight()));//移除
        }
        else {
            if (binarynode.getLeft()!=null)
                binarynode=binarynode.getLeft();
            else
                binarynode=binarynode.getRight();
        }
        return balance(binarynode);

    }
    //求深度
    public int depth(Binarynode binarynode){
        if (binarynode==null)
            return 0;
        else {
            int left=depth(binarynode.getLeft());
            int right=depth(binarynode.getRight());
            return 1+Math.max(left,right);
        }
    }

    private int height(Binarynode t){
        if (t==null)
            return 0;
        return t.getHeight();
    }
    //平衡的方式插入二叉树
    public Binarynode insert2(int value, Binarynode binarynode){
        if (binarynode==null)
            return new Binarynode(value,null,null);
        else if (value>binarynode.getRoot()){
            binarynode.setRight(insert2(value,binarynode.getRight()));
        }
        else if (value<binarynode.getRoot()){
            binarynode.setLeft(insert2(value,binarynode.getLeft()));
        }
        else ;

        return balance(binarynode);//设置的下一个，每个都要设置，所以不用关心父节点
    }
    //平衡二叉树
    public Binarynode balance(Binarynode avlTreeNode) {
        if (avlTreeNode==null){
            return avlTreeNode;
        }
        if (depth(avlTreeNode.getLeft())-depth(avlTreeNode.getRight())>=2){
            if (depth(avlTreeNode.getLeft().getLeft())>depth(avlTreeNode.getLeft().getRight())){
                avlTreeNode=rotateWithLeftChild(avlTreeNode);//单旋转
            }
            else
                avlTreeNode=doubleWithLeftChild(avlTreeNode);//双旋转
        }
        if (depth(avlTreeNode.getRight())-depth(avlTreeNode.getLeft())>=2){
            if (depth(avlTreeNode.getRight().getRight())>depth(avlTreeNode.getRight().getLeft())){
                avlTreeNode=rotateWithRightChild(avlTreeNode);
            }
            else
                avlTreeNode=doubleWithRightChild(avlTreeNode);
        }
//        avlTreeNode.setHeight(Math.max(height(avlTreeNode.getLeft()),height(avlTreeNode.getRight()))+1);
        return avlTreeNode;
    }
    //右双旋转
    public Binarynode doubleWithRightChild(Binarynode avlTreeNode) {
        avlTreeNode.setRight(rotateWithLeftChild(avlTreeNode.getRight()));
        return rotateWithRightChild(avlTreeNode);
    }

    //右单旋转
    public Binarynode rotateWithRightChild(Binarynode avlTreeNode) {
       /* System.out.println("进入了右-右旋转");
        System.out.println("出现旋转的点"+avlTreeNode.getRoot());*/
        Binarynode binarynode1=avlTreeNode.getRight();
        avlTreeNode.setRight(binarynode1.getLeft());
        binarynode1.setLeft(avlTreeNode);
        return binarynode1;
    }

    //左双旋转
    public Binarynode doubleWithLeftChild(Binarynode avlTreeNode) {
       /* System.out.println("使用了左-右双旋转");
        System.out.println("出现旋转的点"+avlTreeNode.getRoot());*/
        avlTreeNode.setLeft(rotateWithRightChild(avlTreeNode.getLeft()));
//        System.out.println("此时旋转之后的左边为"+avlTreeNode.getLeft().getRoot());
        return rotateWithLeftChild(avlTreeNode);
    }
    //左单旋转
    public Binarynode rotateWithLeftChild(Binarynode avlTreeNode) {
      /*  System.out.println("进入了左-左旋转");
        System.out.println("出现旋转的点"+avlTreeNode.getRoot());*/

        Binarynode avlTreeNode1=avlTreeNode.getLeft();
        avlTreeNode.setLeft(avlTreeNode1.getRight());
        avlTreeNode1.setRight(avlTreeNode);

//        avlTreeNode.setHeight(Math.max(height(avlTreeNode.getLeft()),height(avlTreeNode.getRight()))+1);
//        avlTreeNode1.setHeight(Math.max(height(avlTreeNode1.getLeft()),avlTreeNode.getHeight())+1);
        return avlTreeNode1;
    }
    //插入的非递归方法
    public void insert3(int value,Binarynode binarynode){
        if (binarynode==null){
            new Binarynode(value,null,null);
        }
        else {
            Binarynode temp=null;
            int flag=0;
            while (binarynode==null){
                if (value>binarynode.getRoot()){
                    temp=binarynode;
                    binarynode=binarynode.getRight();
                    flag=1;
                }
                else if (value<binarynode.getRoot()){
                    temp=binarynode;
                    binarynode=binarynode.getLeft();
                    flag=2;
                }
                else ;
            }
            if (flag==1){
                temp.setRight(new Binarynode(value,null,null));
            }
            else if (flag==2){
                temp.setLeft(new Binarynode(value,null,null));
            }
            else ;
        }
    }
}
