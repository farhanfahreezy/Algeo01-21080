package lib.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
    public static File[] getDir(String dir){
        File curDir = new File(dir);
        File[] listFiles = curDir.listFiles();
        return listFiles;
    }
    public static void printListDir(String dir){
        File[] listFiles = getDir(dir);
        for(int i = 0; i < listFiles.length; i++){
          System.out.println(String.format("%d. %s", i+1, listFiles[i].getName()));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String currentDirectory = System.getProperty("user.dir");
        IO.printListDir(br);
    //   System.out.println("The current working directory is " + currentDirectory);
    }
}


