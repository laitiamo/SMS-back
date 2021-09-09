package com.zahory.studentmgsystem.manager.teacher;

import com.zahory.studentmgsystem.dao.TeacherDAO;
import com.zahory.studentmgsystem.manager.BaseManager;
import com.zahory.studentmgsystem.model.vo.response.table.TimetableItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimetableManager extends BaseManager {
    private final TeacherDAO teacherDAO;

    public TimetableManager(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public List<TimetableItemVO> listTeacherTimetable(Integer teacherId) {
        return teacherDAO.listTeacherTimetable(teacherId);
    }
}
