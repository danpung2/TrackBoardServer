package com.danpung2.trackboardserver.project.domain.service;

import com.danpung2.trackboardserver.project.domain.model.Project;
import com.danpung2.trackboardserver.project.domain.model.ProjectAggregate;
import com.danpung2.trackboardserver.project.domain.model.ProjectMember;
import com.danpung2.trackboardserver.project.domain.repository.ProjectMemberRepository;
import com.danpung2.trackboardserver.project.domain.repository.ProjectRepository;
import com.danpung2.trackboardserver.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;

    public void createProject(User user, String title, String description) {
        ProjectAggregate aggregate = ProjectAggregate.create(user, title, description);

        Project createdProject = projectRepository.save(aggregate.getProject());
        for (ProjectMember projectMember : aggregate.getMembers()) {
            projectMemberRepository.save(createdProject, projectMember);
        }
    }
}
