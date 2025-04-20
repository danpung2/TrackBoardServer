package com.danpung2.trackboardserver.project.domain.service;

import com.danpung2.trackboardserver.constant.code.UserRole;
import com.danpung2.trackboardserver.project.domain.model.Project;
import com.danpung2.trackboardserver.project.domain.model.ProjectMember;
import com.danpung2.trackboardserver.project.domain.repository.ProjectMemberRepository;
import com.danpung2.trackboardserver.project.domain.repository.ProjectRepository;
import com.danpung2.trackboardserver.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ProjectMemberRepository projectMemberRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void createProject() {
        // given
        User user = new User(0, "tester", "tester@gmail.com", UserRole.MEMBER);
        String title = "my test project";
        String description = "this is test project";

        Project dummyProject = new Project(user, title, description);
        when(projectRepository.save(any(Project.class))).thenReturn(dummyProject);

        // when
        projectService.createProject(user, title, description);

        // then
        ArgumentCaptor<Project> projectCaptor = ArgumentCaptor.forClass(Project.class);
        verify(projectRepository).save(projectCaptor.capture());

        Project savedProject = projectCaptor.getValue();
        // System.out.println(savedProject);
        // Project(id=0, owner=User(id=0, nickname=tester, email=tester@gmail.com, userRole=MEMBER), name=my test project, description=this is test project)
        assertThat(savedProject.getOwner()).isEqualTo(user);
        assertThat(savedProject.getName()).isEqualTo(title);
        assertThat(savedProject.getDescription()).isEqualTo(description);

        verify(projectMemberRepository).save(eq(dummyProject), any(ProjectMember.class));
    }
}