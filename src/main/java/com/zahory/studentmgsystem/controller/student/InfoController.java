package com.zahory.studentmgsystem.controller.student;

import com.zahory.studentmgsystem.config.themis.annotation.Student;
import com.zahory.studentmgsystem.controller.BaseController;
import com.zahory.studentmgsystem.model.vo.request.StudentInfoFormVO;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import com.zahory.studentmgsystem.service.student.InfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Student
@RequestMapping("/student/info")
@RestController
public class InfoController extends BaseController {
    private final InfoService service;

    public InfoController(InfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResultVO get() {
        return service.get();
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated StudentInfoFormVO formVO) {
        return service.update(formVO);
    }
}
