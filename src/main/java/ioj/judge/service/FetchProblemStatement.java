package ioj.judge.service;

import java.io.File;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

public class FetchProblemStatement extends FetchFileService{
    public File fetchProblemStatement(String contestId, String problemId) throws Exception{
        try {
            String path = this.getBasePath()+contestId+"/"+problemId+"/problem/statement.tex";
            return new File(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
