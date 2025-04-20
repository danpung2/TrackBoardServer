package com.danpung2.trackboardserver.project.domain.model;

import com.danpung2.trackboardserver.constant.code.MemberRole;
import com.danpung2.trackboardserver.user.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ProjectMember {
    private int id;
    private Project project;
    private User user;
    private MemberRole memberRole;

    public ProjectMember(Project project, User user, MemberRole memberRole) {
        this.project = project;
        this.user = user;
        this.memberRole = memberRole;
    }
}
