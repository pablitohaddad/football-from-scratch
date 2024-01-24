package com.pablitohaddad.footbalfromscratch.web.controller;

import com.pablitohaddad.footbalfromscratch.entity.Team;
import com.pablitohaddad.footbalfromscratch.service.TeamService;

import com.pablitohaddad.footbalfromscratch.web.dto.TeamCreateDto;
import com.pablitohaddad.footbalfromscratch.web.dto.TeamResponseDto;
import com.pablitohaddad.footbalfromscratch.web.dto.mapper.TeamMapper;
import com.pablitohaddad.footbalfromscratch.web.exception.ErrorMessage;
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

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
@Tag(name="Teams", description = "Contains all operations related to the features for registering, editing, and reading a football team")
public class TeamController {

    private final TeamService teamService;
    private final TeamMapper teamMapper;

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
        Team team = teamMapper.toDto(dto);
        Team createdTeam = teamService.createTeam(team);
        TeamResponseDto teamResponseDto = teamMapper.covertToResponseDto(createdTeam);
        return new ResponseEntity<>(teamResponseDto, HttpStatus.CREATED);
    }


    @Operation(summary = "Get a existing team by ID",
            description = "Descriptions of a football team based on their ID")
    @GetMapping("/{id}")
    public ResponseEntity<Team> getById(@PathVariable Long id){
        Team team = teamService.getById(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
    @Operation(summary = "Update the team's trophies by id",
            description = "Got it! If any team wins a championship, please provide the details, and I'll update accordingly.")
    @PatchMapping("/trophies/{id}")
    public ResponseEntity<Void> updateTrophiesById(@PathVariable Long id, @RequestBody Team team) {
        teamService.atualizarTrofeus(id, team.getQuantityTrophies());
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Update the team's age by ID",
            description = "Congratulations to the anniversary club. Update it here!")
    @PatchMapping("/age/{id}")
    public ResponseEntity<Void> updateAgeById(@PathVariable Long id, @RequestBody Team team){
        teamService.atualizarIdade(id, team.getAge());
        return ResponseEntity.noContent().build();
    }
}
