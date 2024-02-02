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
                    @ApiResponse(responseCode = "201", description = "Resource created successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TeamResponseDto.class))),
                    @ApiResponse(responseCode = "409", description = "Team already registered in the system",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "422", description = "Resource not processed due to invalid input data",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @PostMapping
    public ResponseEntity<TeamResponseDto> createTeam(@Valid @RequestBody TeamCreateDto dto) {
        TeamResponseDto team = teamService.createTeam(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(team);
    }

    @Operation(summary = "Get a existing team by ID", description = "Descriptions of a football team based on their ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Resource is ok",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TeamResponseDto.class))),
                    @ApiResponse(responseCode = "404", description = "Team not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "400", description = "Resource not processed due to invalid input data",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDto> getById(@PathVariable Long id){
        TeamResponseDto team = teamService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(team);
    }
    @Operation(summary = "Get all teams", description = "You will see all the teams in our database here.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Resource is ok",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TeamResponseDto.class))),
                    @ApiResponse(responseCode = "404", description = "Team not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "400", description = "Resource not processed due to invalid input data",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @GetMapping
    public ResponseEntity<List<TeamResponseDto>> getAll(){
        List<TeamResponseDto> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }
    @Operation(summary = "Update the team's datas", description = "Got it! If any team wins a championship, please provide the details, and I'll update accordingly.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "The resource worked successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TeamResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "Resource not processed due to invalid input data",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDto> updateTeam(@PathVariable("id") Long id, @Valid @RequestBody TeamUpdateDto teamDto) {
        TeamResponseDto team = teamService.updateTeam(teamDto, id);
        return ResponseEntity.ok(team);
    }
    @Operation(summary = "Delete team by id", description = "You will be able to remove a team from our database.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "The resource worked successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TeamResponseDto.class))),
                    @ApiResponse(responseCode = "404", description = "Team not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @DeleteMapping("/{id}")
    public void deleteTeam(Long id) {
        teamService.deleteTeam(id);
        ResponseEntity.status(HttpStatus.NO_CONTENT);
    }
}
