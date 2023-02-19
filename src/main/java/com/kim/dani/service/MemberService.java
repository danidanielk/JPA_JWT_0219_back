package com.kim.dani.service;

import com.kim.dani.entity.Member;
import com.kim.dani.entity.Team;
import com.kim.dani.repository.MemberRepository;
import com.kim.dani.repository.TeamRepository;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public void saveMember(){

        Team team = teamRepository.getOne(1L);

        System.out.println("------------------------------"+team);
        System.out.println("------------------------------"+team.getName());
        System.out.println("------------------------------"+team.getId());
        Long id = team.getId();

        Member member = new Member();
        member.setName("member1");
//        member.setTeamId(id);
        member.setTeam(team);
        memberRepository.save(member);
        ;
    }



}
