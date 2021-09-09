package com.zahory.studentmgsystem.manager.admin;

import com.zahory.studentmgsystem.dao.ClassDAO;
import com.zahory.studentmgsystem.dao.DepartmentDAO;
import com.zahory.studentmgsystem.dao.MajorDAO;
import com.zahory.studentmgsystem.manager.BaseManager;
import com.zahory.studentmgsystem.model.entity.DepartmentEntity;
import com.zahory.studentmgsystem.model.entity.MajorEntity;
import com.zahory.studentmgsystem.model.vo.response.IdNameVO;
import com.zahory.studentmgsystem.model.vo.response.table.MajorItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MajorManager extends BaseManager {
    private final MajorDAO majorDAO;
    private final DepartmentDAO departmentDAO;
    private final ClassDAO classDAO;

    public MajorManager(MajorDAO majorDAO, DepartmentDAO departmentDAO, ClassDAO classDAO) {
        this.majorDAO = majorDAO;
        this.departmentDAO = departmentDAO;
        this.classDAO = classDAO;
    }

    public Integer getPageCount(String departmentName, String name) {
        int count = majorDAO.count(departmentName, name);
        return calcPageCount(count, MajorDAO.PAGE_SIZE);
    }

    public List<MajorItemVO> getPage(Integer index, String departmentName, String name) {
        return majorDAO.getPage(index, departmentName, name);
    }

    public MajorEntity get(Integer id) {
        return majorDAO.get(id);
    }

    public int create(MajorEntity entity) {
        return majorDAO.insert(entity);
    }

    public int update(MajorEntity entity) {
        return majorDAO.update(entity);
    }

    public int delete(Integer id) {
        return majorDAO.delete(id);
    }

    public boolean hasClass(Integer majorId) {
        return classDAO.countByMajorId(majorId) > 0;
    }

    public DepartmentEntity getDepartmentById(Integer id) {
        return departmentDAO.get(id);
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<MajorEntity> entityList = majorDAO.listName();
        for (MajorEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
