package ioj.judge.service;

import java.io.File;
import org.springframework.core.io.Resource;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

public class FetchProblemStatement extends FetchFileService{
	
    public File fetchProblemStatement(String contestId, String problemId) throws Exception{
        try {
            String path = this.getBasePath()+contestId+"/"+problemId+"/problem/statement.md";
            System.out.println("FOUND FILE");
            return new File(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    public String fetchProblemStatementString(String contestId, String problemId) throws Exception{
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("pwd");
            Process p = processBuilder.start();

            int wait = p.waitFor();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String temp = br1.readLine();
            br1.close();
            temp = temp +"/data/";
            System.out.println(temp);
            String path = temp+contestId+"/"+problemId+"/problem/statement.md";
			BufferedReader br = new BufferedReader(new FileReader(path));
			StringBuilder sb = new StringBuilder();
			String s;
			while((s = br.readLine()) != null){
				sb.append(s).append("\n");
			}
			return sb.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
