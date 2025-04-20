package com.danpung2.trackboardserver.project.domain.repository;

import com.danpung2.trackboardserver.project.domain.model.Project;
import com.danpung2.trackboardserver.project.domain.model.ProjectMember;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepository {
    ProjectMember save(Project project, ProjectMember projectMember);
}
