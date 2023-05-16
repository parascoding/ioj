package ioj.judge.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import ioj.judge.payload.SubmissionPayload;

public class SaveToFileService {
    private String basePath = "/mnt/32b6b06a-25ad-4911-90a2-9c68b656b0e3/Personal/Spring/judge/data/";
    public boolean saveToFile(SubmissionPayload submissionPayload) throws Exception{
        try {
            File file = new File(basePath+
                                submissionPayload.getContestId() + "/" +
                                submissionPayload.getProblemId() + "/" +
                                submissionPayload.getUserId() + "/");
            if(!file.exists())
                file.mkdirs();
            file = new File(basePath+
                            submissionPayload.getContestId() + "/" +
                            submissionPayload.getProblemId() + "/" +
                            submissionPayload.getUserId() + "/" +
                            "Main" + 
                            "."+
                            submissionPayload.getLanguage());
            submissionPayload.setFilePath(basePath+
                                        submissionPayload.getContestId() + "/" +
                                        submissionPayload.getProblemId() + "/" +
                                        submissionPayload.getUserId() + "/" +
                                        "Main");
            submissionPayload.setBasePath(basePath +
                                        submissionPayload.getContestId() + "/" +
                                        submissionPayload.getProblemId() + "/");
            PrintWriter ot = new PrintWriter(file);
            BufferedReader br = new BufferedReader(new FileReader(submissionPayload.getSourceCode()));
            String s;
            while((s = br.readLine()) != null)
                ot.println(s);
            ot.close();
            br.close();
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }
}
