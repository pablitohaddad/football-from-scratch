package com.pablitohaddad.footbalfromscratch.service;

import com.pablitohaddad.footbalfromscratch.entity.Team;
import com.pablitohaddad.footbalfromscratch.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team createTeam(Team newTeam) {
        return teamRepository.save(newTeam);
    }
}
