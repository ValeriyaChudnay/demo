package com.expert.dao;

import com.expert.entity.Expert;

import java.util.List;

public interface ExpertDao {

    List<Expert> findAll();

    Expert getExpertByEmail(String email);
    Expert createExpert(String email, String password, String score, String name,String organizationCode);

    List<Expert> getExpertsByProjectId(int id);

    List<Expert> getExpertsByOrganization(String organizationCode);
}
