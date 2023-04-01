package fr.eql.ai113.LesVentsDalizes.repository;

import fr.eql.ai113.LesVentsDalizes.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, Integer> {

    Member save(Member member);
}
