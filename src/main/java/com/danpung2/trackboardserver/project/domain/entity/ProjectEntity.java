package com.danpung2.trackboardserver.project.domain.entity;

import com.danpung2.trackboardserver.project.domain.model.Project;
import com.danpung2.trackboardserver.user.domain.entity.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;
    private String name;
    private String description;

    public Project toModel() {
        return new Project(id, owner.toModel(), name, description);
    }
}
