package code.practice;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllFilesInAFolder {

    public static void main(String[] args) throws IOException {
        File filePath = new File("C:\\UPMC");
        FileFilter fileFilter = new FileFilter() {
            
            @Override
            public boolean accept(File filePath) {
                if(filePath.getName().matches("prx.xml.+")) return true;
                return false;
            }
        };
        
        //list files
        List<File> fileNames = Arrays.asList(filePath.listFiles(fileFilter));
        List<String> fileNamesString = new ArrayList<String>();
        Path filePathToWriteCommand = Paths.get("C:\\UPMC\\command.txt");
        Files.write(filePathToWriteCommand,"java -cp genesis-instrument-matisse-3.1.3.jar com.cerner.system.instrument.picasso.analyzer.PRX2HTMLReport ".getBytes());
        for (File fileName : fileNames) {
            System.out.println(fileName.getName());
            fileNamesString.add("C:/UPMC/"+fileName.getName());
            Files.write(filePathToWriteCommand, (fileName.getName() +" ").getBytes(), StandardOpenOption.APPEND);
        }
        System.out.println(fileNamesString);
    }
    

}
