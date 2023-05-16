package ioj.judge;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ioj.judge.controller.SubmissionController;
import ioj.judge.payload.SubmissionPayload;
import ioj.judge.payload.SubmissionResultPayload;

@SpringBootApplication
public class IiitdmOnlineJudgeApplication implements CommandLineRunner{

	private SubmissionPayload submissionPayload;
	private SubmissionController submissionController;
	public static void main(String[] args) {
		SpringApplication.run(IiitdmOnlineJudgeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				System.out.println("enter");
				if(br.readLine().equals("a"))
					doSub();
				else
					continue;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private void doSub() throws Exception{
		try {
			// String basePath = "/mnt/32b6b06a-25ad-4911-90a2-9c68b656b0e3/Personal/Spring/judge/temp/";
			// submissionPayload = new SubmissionPayload("123", "123", "paras", "tthis is a code", "java", "", new File(basePath+"Main.java"), "");
			// submissionController = new SubmissionController();
			// SubmissionResultPayload submissionResultPayload = submissionController.submission(submissionPayload);
			// System.out.println(submissionResultPayload);
			// System.out.println("\n\n!!!!!!! SUCESS !!!!!!!!!!!!!\n\n");
			String basePath = "/mnt/32b6b06a-25ad-4911-90a2-9c68b656b0e3/Personal/Spring/judge/temp/";
			submissionPayload = new SubmissionPayload("123", "123", "paras", "tthis is a code", "cpp", "", new File(basePath+"Main.cpp"), "");
			submissionController = new SubmissionController();
			SubmissionResultPayload submissionResultPayload = submissionController.submission(submissionPayload);
			System.out.println(submissionResultPayload);
			System.out.println("\n\n!!!!!!! SUCESS !!!!!!!!!!!!!\n\n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}