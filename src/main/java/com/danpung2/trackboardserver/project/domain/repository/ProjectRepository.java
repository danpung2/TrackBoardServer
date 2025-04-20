package com.danpung2.trackboardserver.project.domain.repository;

import com.danpung2.trackboardserver.project.domain.model.Project;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository {
    Project save(Project project);
}
