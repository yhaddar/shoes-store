package com.shoes.backend.Repository;

import com.shoes.backend.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
    @Query("SELECT b FROM Brand b JOIN b.shoes s GROUP BY b HAVING COUNT(s) >= 1")
    List<Brand> findAllWithShoes();
}
