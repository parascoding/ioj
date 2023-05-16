package ioj.judge.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MatcherService {
    public boolean matchOutput(File f1, File f2) throws Exception{
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(f1));
            BufferedReader br2 = new BufferedReader(new FileReader(f2));
            String x = "b", y = "a";
            while(true){
                x = br1.readLine();
                y = br2.readLine();
                if(x == null && y == null){
                    break;
                }
                if(x == null || y == null)
                    return false;
                
                if(!x.equals(y))
                    return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
