package com.pablitohaddad.footbalfromscratch.service;

import com.pablitohaddad.footbalfromscratch.entity.Team;
import com.pablitohaddad.footbalfromscratch.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public Team getById(Long id) {
        return teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Id = %s not exist", id))
        );
    }
}
