package test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TestCreateTempFile {

    public void access() {
        File file;
        String resource = "/data/database.accdb";
        URL res = getClass().getResource(resource);
        if (res.toString().startsWith("jar:")) {
            try {
                InputStream input = getClass().getResourceAsStream(resource);
                file = File.createTempFile("fileGiDo", ".accdb");
                
                System.out.println(file.getAbsolutePath());
                
                input.close();
                file.deleteOnExit();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else { 
            file = new File(res.getFile());
            System.out.println("Không phát sinh file jar");
        }
    }
    public static void main(String[] args) {
        new TestCreateTempFile().access();
    }
}
