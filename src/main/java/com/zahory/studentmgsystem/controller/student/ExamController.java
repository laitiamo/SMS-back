package com.zahory.studentmgsystem.controller.student;

import com.zahory.studentmgsystem.config.themis.annotation.Student;
import com.zahory.studentmgsystem.controller.BaseController;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import com.zahory.studentmgsystem.service.student.ExamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Student
@RequestMapping("/student/exam")
@RestController
public class ExamController extends BaseController {
    private final ExamService service;

    public ExamController(ExamService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
}
