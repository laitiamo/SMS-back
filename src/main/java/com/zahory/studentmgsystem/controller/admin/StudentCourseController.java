package com.zahory.studentmgsystem.controller.admin;

import com.zahory.studentmgsystem.config.themis.annotation.Admin;
import com.zahory.studentmgsystem.controller.BaseController;
import com.zahory.studentmgsystem.model.entity.StudentCourseEntity;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import com.zahory.studentmgsystem.service.admin.StudentCourseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Admin(Admin.STUDENT_COURSE_MANAGE)
@RequestMapping("/admin/student/course")
@RestController
public class StudentCourseController extends BaseController {
    private final StudentCourseService service;

    public StudentCourseController(StudentCourseService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResultVO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public ResultVO create(@RequestBody @Validated StudentCourseEntity entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated StudentCourseEntity entity) {
        return service.update(entity);
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(String className, String courseName, String studentName) {
        return service.getPageCount(className, courseName, studentName);
    }

    @RequestMapping("/page")
    public ResultVO getPage(String className, String courseName, String studentName) {
        return service.getPage(1, className, courseName, studentName);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index, String className, String courseName, String studentName) {
        return service.getPage(index, className, courseName, studentName);
    }
}
