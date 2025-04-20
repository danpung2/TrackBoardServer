package com.danpung2.trackboardserver.project.domain.model;

import com.danpung2.trackboardserver.constant.code.MemberRole;
import com.danpung2.trackboardserver.user.domain.model.User;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class ProjectAggregate {
    private final Project project;
    private final List<ProjectMember> members;

    private ProjectAggregate(Project project, List<ProjectMember> members) {
        this.project = project;
        this.members = members;
    }

    public static ProjectAggregate create(User owner, String name, String description) {
        Project project = new Project(owner, name, description);
        ProjectMember member = new ProjectMember(project, owner, MemberRole.OWNER);
        return new ProjectAggregate(project, List.of(member));
    }

    public Optional<ProjectMember> getOwner() {
        return members.stream().findFirst().filter(projectMember -> projectMember.getMemberRole() == MemberRole.OWNER).or(null);
    }
}
