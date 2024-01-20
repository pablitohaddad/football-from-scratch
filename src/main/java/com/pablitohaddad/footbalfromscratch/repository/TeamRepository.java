package com.pablitohaddad.footbalfromscratch.repository;

import com.pablitohaddad.footbalfromscratch.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
