package com.pablitohaddad.footbalfromscratch.team.repository;

import com.pablitohaddad.footbalfromscratch.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByName(String name);
}
