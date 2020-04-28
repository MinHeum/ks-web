package com.minheum.app.repository;

import com.minheum.app.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository <Skill, Long> {
}
