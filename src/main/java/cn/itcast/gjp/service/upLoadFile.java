package cn.itcast.gjp.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class upLoadFile {
    public void saveFileToServer(MultipartFile file,String filePath){
        File file1 = new File(filePath,file.getOriginalFilename());
        try {
            boolean newFile = file1.createNewFile();
            FileOutputStream fops = new FileOutputStream(file1);
            fops.write(file.getBytes());
            fops.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFileInServerByFilePath(String filePath){
        File file = new File(filePath);
        if(file.exists()){
            file.delete();
        }else {
            System.out.println("文件不存在");
        }

    }

}
