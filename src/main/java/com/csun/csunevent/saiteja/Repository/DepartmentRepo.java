package com.csun.csunevent.saiteja.Repository;

import com.csun.csunevent.saiteja.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    public Department findByDepartmentName(String u);
    //public List<Department>
}
