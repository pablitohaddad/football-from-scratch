package com.pablitohaddad.footbalfromscratch.web.dto.mapper;

import com.pablitohaddad.footbalfromscratch.entity.Team;
import com.pablitohaddad.footbalfromscratch.web.dto.TeamCreateDto;
import com.pablitohaddad.footbalfromscratch.web.dto.TeamResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamMapper {

    private final ModelMapper modelMapper;

    public TeamResponseDto covertToResponseDto(Team team){
        return modelMapper.map(team, TeamResponseDto.class);
    }

    public Team toDto(TeamCreateDto dto){
        return modelMapper.map(dto, Team.class);
    }

}
