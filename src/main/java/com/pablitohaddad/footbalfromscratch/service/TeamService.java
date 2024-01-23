package com.pablitohaddad.footbalfromscratch.service;

import com.pablitohaddad.footbalfromscratch.entity.Team;
import com.pablitohaddad.footbalfromscratch.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team createTeam(Team newTeam) {
        return teamRepository.save(newTeam);
    }
    @Transactional(readOnly = true)
    public Team getById(Long id) {
        return teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Id = %s not exist", id))
        );
    }
    @Transactional
    public void atualizarTrofeus(Long id, Integer newQuantityTrophies) {
        Team team = getById(id);
        team.setQuantityTrophies(newQuantityTrophies);
    }

    @Transactional
    public void atualizarIdade(Long id, Integer age) {
        Team team = getById(id);
        team.setAge(age);

    }
}
