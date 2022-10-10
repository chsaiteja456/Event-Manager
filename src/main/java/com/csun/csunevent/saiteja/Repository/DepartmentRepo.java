package com.csun.csunevent.saiteja.Repository;

import com.csun.csunevent.saiteja.models.Department;
import com.csun.csunevent.saiteja.models.User;
import com.csun.csunevent.saiteja.models.event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    public Department findByDepartmentName(String u);
    //public List<Department>
}
