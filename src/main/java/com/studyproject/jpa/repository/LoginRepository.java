package com.studyproject.jpa.repository;

import com.studyproject.jpa.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity,String> {
}
