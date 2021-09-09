package com.zahory.studentmgsystem.service.teacher;

import com.zahory.studentmgsystem.manager.teacher.TimetableManager;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import com.zahory.studentmgsystem.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer teacherId = getUserId();
        return result(manager.listTeacherTimetable(teacherId));
    }
}
