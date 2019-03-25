package util;

public class Main4 {
    public static void main(String[] args) {
        Binarynode a=new Binarynode(15);
        Binarynode b=new Binarynode(14);
        Binarynode c=new Binarynode(16);
        Binarynode d=new Binarynode(13);
        Binarynode e=new Binarynode(18);
        Binarynode f=new Binarynode(25);
        Binarynode g=new Binarynode(24);
        Binarynode h=new Binarynode(26);
        Binarynode i=new Binarynode(12);
        a.setLeft(d);
        a.setRight(c);
        d.setRight(b);
        e.setLeft(a);
        e.setRight(f);
        f.setLeft(g);
        f.setRight(h);
        d.setLeft(i);

        BinaryTree binaryTree=new BinaryTree(a);
//        a.setHeight(binaryTree.depth(a));
//        b.setHeight(binaryTree.depth(b));
//        c.setHeight(binaryTree.depth(c));
//        d.setHeight(binaryTree.depth(d));
//        e.setHeight(binaryTree.depth(e));
//        f.setHeight(binaryTree.depth(f));
//        g.setHeight(binaryTree.depth(g));
//        h.setHeight(binaryTree.depth(h));
//        i.setHeight(binaryTree.depth(i));

        //        binaryTree.midorder(a);
//        binaryTree.insert(11,a);
        /*binaryTree.midorder(e);
        System.out.println("=================");
        binaryTree.preorder(e);*/
        binaryTree.insert2(11,e);
//
        binaryTree.insert2(10,e);
        binaryTree.insert2(29,e);
        binaryTree.insert2(32,e);
        binaryTree.insert2(7,e);
        binaryTree.insert2(8,e);
        binaryTree.midorder(e);
        System.out.println("=================");
        binaryTree.preorder(e);
        System.out.println("=================下面是删除===============");
        binaryTree.del(32,e);
        binaryTree.del(26,e);
        binaryTree.midorder(d);
        System.out.println(binaryTree.depth(d));
        System.out.println("=================下面是删除根节点===============");
        binaryTree.del(13,d);
        binaryTree.midorder(d);
//        System.out.println(binaryTree.depth(e));
       /* System.out.println(binaryTree.depth(e));
        System.out.println(binaryTree.depth(i));
//        System.out.println(a.getHeight());
        binaryTree.preorder(e);
        System.out.println("======================");
        binaryTree.midorder(d);
        binaryTree.midorder(i);
        System.out.println("====================");
        binaryTree.preorder(i);
        System.out.println(binaryTree.depth(i));
        binaryTree.midorder(b);
        System.out.println(binaryTree.depth(b));
        binaryTree.preorder(b);
        System.out.println("====================");
        System.out.println(binaryTree.depth(e));*/

    }
}
