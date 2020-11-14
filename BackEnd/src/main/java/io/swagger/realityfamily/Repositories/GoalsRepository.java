package io.swagger.realityfamily.Repositories;

import io.swagger.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface GoalsRepository extends JpaRepository<Goal, UUID> {

    @Query("select u from Goal u where u.name = ?1")
    Goal findByName(String goalName);
}
