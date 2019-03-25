package util;

import java.util.Set;
import java.util.TreeSet;

public class Main5 {
    public static void main(String[] args) {
        Set<String> s=new TreeSet<>();
        s.add( "my");
        s.add("world");
        s.add("my");
        System.out.println(s.size());
    }
}
