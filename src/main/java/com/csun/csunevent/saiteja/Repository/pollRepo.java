package com.csun.csunevent.saiteja.Repository;

import com.csun.csunevent.saiteja.models.poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
@Repository
@Service
public interface pollRepo extends JpaRepository<poll,Integer> {

}
