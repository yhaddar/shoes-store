package com.shoes.backend.Repository;

import com.shoes.backend.Entity.Shoes;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, UUID> {
//    @Query("SELECT s FROM Shoes s ORDER BY s.created_at ASC")
//    List<Shoes> findAll();

    @Query("SELECT s FROM Shoes s WHERE s.name LIKE concat('%', :q, '%') ORDER BY s.created_at ASC")
    List<Shoes> searchByName(@Param("q") String q);

    @Query("SELECT s FROM Shoes s")
    List<Shoes> filterByBrandOrCategory(@Param("f") String f);

    boolean existsByCode(@Param("code") String code);
}
