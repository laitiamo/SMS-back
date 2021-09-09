package com.zahory.studentmgsystem.controller.teacher;

import com.zahory.studentmgsystem.config.themis.annotation.Teacher;
import com.zahory.studentmgsystem.controller.BaseController;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import com.zahory.studentmgsystem.service.teacher.TimetableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/timetable")
@RestController
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
