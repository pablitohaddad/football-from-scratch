package com.pablitohaddad.footbalfromscratch.web.controller;

import com.pablitohaddad.footbalfromscratch.entity.Team;
import com.pablitohaddad.footbalfromscratch.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@Valid @RequestBody Team newTeam){
        Team team = teamService.createTeam(newTeam);
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }
    
}
