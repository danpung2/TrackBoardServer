package com.danpung2.trackboardserver.user.domain.repository;

import com.danpung2.trackboardserver.user.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User save(User user);
}
