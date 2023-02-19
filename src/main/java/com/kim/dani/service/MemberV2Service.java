package com.kim.dani.service;

import com.kim.dani.entity.MemberV2;
import com.kim.dani.entity.Team;
import com.kim.dani.repository.MemberV2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberV2Service {

    private final MemberV2Repository memberV2Repository;


    public void saveMember(){
        Team team = new Team();
        MemberV2 memberV2= new MemberV2();

        memberV2.setName("dani");
        memberV2.setTeam(team);
        memberV2Repository.save(memberV2);
     }
}
