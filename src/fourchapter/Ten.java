package fourchapter;

import java.io.File;

/**
 * 列举目录下的文件和大小
 */
public class Ten {
    public void output(String filename){
        File file=new File(filename);
        if (file.exists()){
            File files[]=file.listFiles();
            if (files.length==0){
                System.out.println("改文件为空");
                return;
            }
            for (File file1:files
                 ) {
                if (file1.isDirectory()){
                    output(file1.getAbsolutePath());
                }
                System.out.println("文件名为："+file1.getName()+"  大小为"+file1.length());
            }
        }
        else
            System.out.println("文件不存在");
    }
}
