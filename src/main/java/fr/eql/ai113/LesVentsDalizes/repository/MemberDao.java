package fr.eql.ai113.LesVentsDalizes.repository;

import fr.eql.ai113.LesVentsDalizes.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, Integer> {

    Member save(Member member);
}
