	package ioj.judge.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import ioj.judge.payload.SubmissionPayload;

public class SaveToFileService {
    private String basePath;
    
    public boolean saveToFile(SubmissionPayload submissionPayload) throws Exception{
        try {
            if(basePath == null || basePath.length() == 0)
                basePath = new GetbasePathService().getBasePath();
            // System.out.println("BASE PATH: "+basePath);
            File file = new File(basePath+
                                submissionPayload.getContestId() + "/" +
                                submissionPayload.getProblemId() + "/" +
                                submissionPayload.getUserId() + "/");
            if(!file.exists())
                file.mkdirs();
            // System.out.println(21);
            file = new File(basePath+
                            submissionPayload.getContestId() + "/" +
                            submissionPayload.getProblemId() + "/" +
                            submissionPayload.getUserId() + "/" +
                            "Main" + 
                            "."+
                            submissionPayload.getLanguage());
            // System.out.println(29);
            submissionPayload.setFilePath(basePath+
                                        submissionPayload.getContestId() + "/" +
                                        submissionPayload.getProblemId() + "/" +
                                        submissionPayload.getUserId() + "/" +
                                        "Main");
            submissionPayload.setBasePath(basePath +
                                        submissionPayload.getContestId() + "/" +
                                        submissionPayload.getProblemId() + "/");
            file.createNewFile();
            // System.out.println(38);
            PrintWriter ot = new PrintWriter(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(submissionPayload.getSourceCode().getInputStream()));
            String s;// = new String(submissionPayload.getSourceCode());
            while((s = br.readLine()) != null)
                ot.println(s);
            ot.close();
            br.close();
            return true;
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
        
    }
}
