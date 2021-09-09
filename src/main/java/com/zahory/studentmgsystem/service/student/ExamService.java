package com.zahory.studentmgsystem.service.student;

import com.zahory.studentmgsystem.manager.student.ExamManager;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import com.zahory.studentmgsystem.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ExamService extends BaseService {
    private final ExamManager manager;

    public ExamService(ExamManager manager) {
        this.manager = manager;
    }

    public ResultVO list() {
        return result(manager.listStudentExam(getUserId()));
    }
}
