package com.zahory.studentmgsystem.service.teacher;

import com.zahory.studentmgsystem.manager.teacher.CourseManager;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import com.zahory.studentmgsystem.model.vo.response.table.TeacherCourseItemVO;
import com.zahory.studentmgsystem.service.BaseService;
import com.zahory.studentmgsystem.util.LessonTimeConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacher_courseService")
public class CourseService extends BaseService {
    private final CourseManager manager;
    private final LessonTimeConverter lessonTimeConverter;

    public CourseService(CourseManager manager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO list() {
        Integer teacherId = getUserId();

        List<TeacherCourseItemVO> list = manager.listTeacherCourse(teacherId);
        for (TeacherCourseItemVO vo : list) {
            vo.setTime(lessonTimeConverter.covertTimePart(vo.getTime()));
        }

        return result(list);
    }
}
