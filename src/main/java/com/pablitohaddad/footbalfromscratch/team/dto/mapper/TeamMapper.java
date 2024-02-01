package com.pablitohaddad.footbalfromscratch.team.dto.mapper;

import com.pablitohaddad.footbalfromscratch.team.dto.TeamResponseDto;
import com.pablitohaddad.footbalfromscratch.team.dto.TeamUpdateDto;
import com.pablitohaddad.footbalfromscratch.team.entity.Team;
import com.pablitohaddad.footbalfromscratch.team.dto.TeamCreateDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class TeamMapper {

    public static TeamResponseDto toDto(Team team){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(team, TeamResponseDto.class);
    }

    public static Team toTeam(TeamCreateDto dto){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(dto, Team.class);
    }

    public static Team updateByDto(TeamUpdateDto updateDTO, Team team){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true); // pula campos nulos
        mapper.map(updateDTO, team);
        return team;
    }

    public static List<TeamResponseDto> toListDto(List<Team> teams) {
        return teams.stream().map(TeamMapper::toDto).collect(Collectors.toList());
    }
}
