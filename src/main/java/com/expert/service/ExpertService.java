package com.expert.service;

import com.expert.entity.Expert;
import com.expert.entity.Project;

import java.util.List;

public interface ExpertService {

    List<Expert> findAll();

    Expert getExpertByEmailAndPassword(String email, String password);

    Expert createExpert(String email, String password, String score,String name, String organizationCode);

    List<Expert> getExpertsByProjectId(int parseInt);

    List<Expert> getExpertsByOrganization(String organizationCode);
}
