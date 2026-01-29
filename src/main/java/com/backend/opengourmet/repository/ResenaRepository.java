package com.backend.opengourmet.repository;

import com.backend.opengourmet.repository.entity.ResenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResenaRepository extends JpaRepository<ResenaEntity, Long> {
}
