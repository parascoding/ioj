package ioj.judge.controller.UserController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ioj.judge.payload.ApiResponse;
import ioj.judge.payload.UserPayloads.SeeEditorialPayload;
import ioj.judge.service.FetchEditorial;
import ioj.judge.service.FetchFileService;

@RestController
@RequestMapping("compete/{contestId}/{problemId}/")
@CrossOrigin("*")
public class SeeEditorailController {

    private FetchEditorial fetchFileService;
    public SeeEditorailController(){
        fetchFileService = new FetchEditorial();
    }
    @GetMapping("editorial")
    public ApiResponse viewEditorial(@PathVariable String contestId, @PathVariable String problemId) throws Exception{
        try {
            SeeEditorialPayload seeEditorialPayload = new SeeEditorialPayload();
            StringBuilder markdown = new StringBuilder(fetchFileService.fetchEditorialString(contestId, problemId));
            seeEditorialPayload.setMarkDown(markdown.toString());
            seeEditorialPayload.setIsSuccess(true);
            seeEditorialPayload.setMessage("Editorial Fetched");
            return seeEditorialPayload;
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage());
        }
    }
}
