package fr.eql.ai113.LesVentsDalizes.repository;

import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.logging.Logger;

public interface RequestPerformDao extends JpaRepository<RequestPerform, Long> {


    RequestPerform save(RequestPerform requestPerform);
}
