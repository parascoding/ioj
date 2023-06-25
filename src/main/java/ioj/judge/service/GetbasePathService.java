package ioj.judge.service;

import org.springframework.stereotype.Service;

@Service
public class GetbasePathService {
    public String getBasePath(){
        String s = System.getProperty("user.dir");
        return s+"/data/";
    }
}
