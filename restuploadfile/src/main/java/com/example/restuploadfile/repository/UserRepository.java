package com.example.restuploadfile.repository;

import com.example.restuploadfile.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
