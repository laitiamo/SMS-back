package com.zahory.studentmgsystem.controller.student;

import com.zahory.studentmgsystem.config.themis.annotation.Student;
import com.zahory.studentmgsystem.controller.BaseController;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import com.zahory.studentmgsystem.service.student.TimetableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Student
@RequestMapping("/student/timetable")
@RestController("student_timeTableController")
public class TimetableController extends BaseController {
    private final TimetableService service;

    public TimetableController(TimetableService service) {
        this.service = service;
    }

    @RequestMapping
    public ResultVO get() {
        return service.get();
    }
}
