package com.pablitohaddad.footbalfromscratch.team.controller;

import com.pablitohaddad.footbalfromscratch.team.dto.TeamUpdateDto;
import com.pablitohaddad.footbalfromscratch.team.entity.Team;
import com.pablitohaddad.footbalfromscratch.team.service.TeamService;

import com.pablitohaddad.footbalfromscratch.team.dto.TeamCreateDto;
import com.pablitohaddad.footbalfromscratch.team.dto.TeamResponseDto;
import com.pablitohaddad.footbalfromscratch.team.dto.mapper.TeamMapper;
import com.pablitohaddad.footbalfromscratch.handler.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
@Tag(name="Teams", description = "Contains all operations related to the features for registering, editing, and reading a football team")
public class TeamController {

    private final TeamService teamService;


    @Operation(summary = "Create a new team", description = "Creates a new football team with the provided information",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TeamResponseDto.class))),
                    @ApiResponse(responseCode = "409", description = "Recurso criado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "422", description = "Recurso criado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @PostMapping
    public ResponseEntity<TeamResponseDto> createTeam(@Valid @RequestBody TeamCreateDto dto) {
        TeamResponseDto team = teamService.createTeam(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(team);
    }

    @Operation(summary = "Get a existing team by ID",
            description = "Descriptions of a football team based on their ID")
    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDto> getById(@PathVariable Long id){
        TeamResponseDto team = teamService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(team);
    }
    @Operation(summary = "Get all teams",
            description = "You will see all the teams in our database here.")
    @GetMapping
    public ResponseEntity<List<TeamResponseDto>> getAll(){
        List<TeamResponseDto> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }
    @Operation(summary = "Update the team's datas",
            description = "Got it! If any team wins a championship, please provide the details, and I'll update accordingly.")
    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDto> updateTeam(@PathVariable("id") Long id, @Valid @RequestBody TeamUpdateDto teamDto) {
        TeamResponseDto team = teamService.updateTeam(teamDto, id);
        return ResponseEntity.ok(team);
    }
}
