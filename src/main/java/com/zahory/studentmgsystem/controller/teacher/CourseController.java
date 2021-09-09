package com.zahory.studentmgsystem.controller.teacher;

import com.zahory.studentmgsystem.config.themis.annotation.Teacher;
import com.zahory.studentmgsystem.controller.BaseController;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import com.zahory.studentmgsystem.service.teacher.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/course")
@RestController("teacher_courseController")
public class CourseController extends BaseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
}
