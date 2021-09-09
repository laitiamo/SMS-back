package com.zahory.studentmgsystem.manager.admin;

import com.zahory.studentmgsystem.dao.AdminDAO;
import com.zahory.studentmgsystem.manager.BaseManager;
import com.zahory.studentmgsystem.model.entity.AdminEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminManager extends BaseManager {
    private final AdminDAO adminDAO;

    public AdminManager(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public AdminEntity get(Integer id) {
        return adminDAO.get(id);
    }

    public int create(AdminEntity entity) {
        return adminDAO.insert(entity);
    }

    public int update(AdminEntity entity) {
        return adminDAO.update(entity);
    }

    public int delete(Integer id) {
        return adminDAO.delete(id);
    }

    public List<AdminEntity> list() {
        return adminDAO.list();
    }
}
