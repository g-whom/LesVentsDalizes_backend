package fr.eql.ai113.LesVentsDalizes.repository;

import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;
@Repository
public interface RequestPerformDao extends JpaRepository<RequestPerform, Long> {


    RequestPerform save(RequestPerform requestPerform);
}
