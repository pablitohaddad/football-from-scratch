package com.pablitohaddad.footbalfromscratch.team.service;

import com.pablitohaddad.footbalfromscratch.team.dto.TeamCreateDto;
import com.pablitohaddad.footbalfromscratch.team.dto.TeamResponseDto;
import com.pablitohaddad.footbalfromscratch.team.dto.TeamUpdateDto;
import com.pablitohaddad.footbalfromscratch.team.dto.mapper.TeamMapper;
import com.pablitohaddad.footbalfromscratch.team.entity.Team;
import com.pablitohaddad.footbalfromscratch.team.exception.TeamNameUniqueViolationException;
import com.pablitohaddad.footbalfromscratch.team.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;


    @Transactional
    public TeamResponseDto createTeam(TeamCreateDto newTeam) {
        try{
            return TeamMapper.toDto(teamRepository.save(TeamMapper.toTeam(newTeam)));
        }catch (DataIntegrityViolationException ex){
            throw new TeamNameUniqueViolationException(String.format("Product with name %s already exists", newTeam.getName()));
        }
    }
    @Transactional(readOnly = true)
    public TeamResponseDto getById(Long id) {
        return TeamMapper.toDto(teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Team id %d not found", id))
        ));
    }
    @Transactional
    public TeamResponseDto updateTeam(TeamUpdateDto teamUpdate, Long id) {
        Team team = teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Team id %d not found", id))
        );
        Team existing = teamRepository.findByName(teamUpdate.getName());
        if (existing != null && !existing.getId().equals(team.getId()))
            throw new TeamNameUniqueViolationException(
                    String.format("Product with name %s already exists", teamUpdate.getName())
            );
        TeamMapper.updateByDto(teamUpdate, team);
        teamRepository.save(team);
        return TeamMapper.toDto(team);

    }

}
