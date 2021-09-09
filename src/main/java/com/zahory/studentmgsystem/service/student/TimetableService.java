package com.zahory.studentmgsystem.service.student;

import com.zahory.studentmgsystem.manager.student.TimetableManager;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import com.zahory.studentmgsystem.service.BaseService;
import org.springframework.stereotype.Service;

@Service("student_timetableService")
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer studentId = getUserId();
        return result(manager.listStudentTimetable(studentId));
    }
}
