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
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
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
        binaryTree.insert2(11,e);

        binaryTree.midorder(e);
//        System.out.println(binaryTree.depth(e));
//        System.out.println(d.getHeight());
//        System.out.println(a.getHeight());
    }
}
