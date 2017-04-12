package com.mihai.licenta.Repos;

import com.mihai.licenta.Models.DBModels.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mihai on 12.04.2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
