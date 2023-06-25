package ioj.judge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import ioj.judge.controller.SubmissionController;
import ioj.judge.controller.AdminController.AddProblemController;
import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.SubmissionPayload;
import ioj.judge.payload.SubmissionResultPayload;

@SpringBootApplication
@CrossOrigin("*")
public class IiitdmOnlineJudgeApplication{

	private SubmissionPayload submissionPayload;
	private SubmissionController submissionController;
	public static void main(String[] args) {
		SpringApplication.run(IiitdmOnlineJudgeApplication.class, args);
	}
	// private void addProblem() throws Exception{
	// 	String basePath = "/mnt/32b6b06a-25ad-4911-90a2-9c68b656b0e3/Personal/Spring/judge/temp/";
	// 	File file = new File(basePath+"Main.java");
	// 	FileInputStream fileInputStream = new FileInputStream(file);
	// 	MultipartFile multipartFile1 = new MockMultiPartFile("statement.tex", fileInputStream);
	// 	file = new File(basePath+"Main.cpp");
	// 	fileInputStream = new FileInputStream(file);
	// 	MultipartFile multipartFile2 = new MockMultiPartFile("statement.tex", fileInputStream);
	// 	file = new File(basePath+"Main.cpp");
	// 	fileInputStream = new FileInputStream(file);
	// 	MultipartFile multipartFile3 = new MockMultiPartFile("statement.tex", fileInputStream);
	// 	AddProblemController addProblemController = new AddProblemController();
	// 	addProblemController.addProblem(file, multipartFile2, multipartFile3, "1234", "1234");
	// }
	private void doSub() throws Exception{
		try {
			// String basePath = "/mnt/32b6b06a-25ad-4911-90a2-9c68b656b0e3/Personal/Spring/judge/temp/";
			// submissionPayload = new SubmissionPayload("123", "123", "paras", "tthis is a code", "java", "", new File(basePath+"Main.java"), "");
			// submissionController = new SubmissionController();
			// SubmissionResultPayload submissionResultPayload = submissionController.submission(submissionPayload);
			// // System.out.println(submissionResultPayload);
			// // System.out.println("\n\n!!!!!!! SUCESS !!!!!!!!!!!!!\n\n");
			// String basePath = "/mnt/32b6b06a-25ad-4911-90a2-9c68b656b0e3/Personal/Spring/judge/temp/";
			// submissionPayload = new SubmissionPayload("123", "123", "paras", "tthis is a code", "cpp", "", new File(basePath+"Main.cpp"), "");
			// submissionController = new SubmissionController();
			// ApiResponse apiResponse = submissionController.submission(submissionPayload);
			// // System.out.println(apiResponse);
			// // System.out.println("\n\n!!!!!!! SUCESS !!!!!!!!!!!!!\n\n");

		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
	}

}