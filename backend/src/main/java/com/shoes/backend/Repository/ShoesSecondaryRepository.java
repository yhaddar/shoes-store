package com.shoes.backend.Repository;

import com.shoes.backend.Entity.ShoesSecondary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShoesSecondaryRepository extends JpaRepository<ShoesSecondary, UUID> {
}
