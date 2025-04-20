package com.danpung2.trackboardserver.project.domain.model;

import com.danpung2.trackboardserver.user.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Project {
    private int id;
    private User owner;
    private String name;
    private String description;

    public Project(User owner, String name, String description) {
        this.owner = owner;
        this.name = name;
        this.description = description;
    }
}
