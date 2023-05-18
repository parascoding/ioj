package ioj.judge.service;

import java.io.File;
import org.springframework.web.multipart.MultipartFile;

public class AddProblemService {
    private boolean saveFile(MultipartFile fileToSaved, String path, String name) throws Exception{
        try {
            File file = new File(path);
            if(!file.exists())
                file.mkdirs();
            file = new File(path, name);
            fileToSaved.transferTo(file);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean saveProblemStatement(MultipartFile problemStatement, String path) throws Exception{
        try {
            return saveFile(problemStatement, path, "statement.tex");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean saveInputFile(MultipartFile inputFile, String path) throws Exception{
        try {
            return saveFile(inputFile, path, "input.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean saveOutputFile(MultipartFile outputFile, String path) throws Exception{
        try {
            return saveFile(outputFile, path, "output.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
