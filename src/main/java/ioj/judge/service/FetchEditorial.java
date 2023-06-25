package ioj.judge.service;

import java.io.BufferedReader;
import java.io.FileReader;

public class FetchEditorial extends FetchFileService{
    public String fetchEditorialString(String contestId, String problemId) throws Exception{
        try {
            String path = this.getBasePath()+contestId+"/"+problemId+"/problem/editorial.md";
			BufferedReader br = new BufferedReader(new FileReader(path));
			StringBuilder sb = new StringBuilder();
			String s;
			while((s = br.readLine()) != null){
				sb.append(s).append("\n");
			}
			return sb.toString();
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            return null;
        }
    }
}
