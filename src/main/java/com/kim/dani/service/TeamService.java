package com.kim.dani.service;

import com.kim.dani.entity.Member;
import com.kim.dani.entity.Team;
import com.kim.dani.repository.MemberRepository;
import com.kim.dani.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    public Team saveTeam(){
        Team team = new Team();
        team.setName("TeamA");
        teamRepository.save(team);
        return team;

    }

}

