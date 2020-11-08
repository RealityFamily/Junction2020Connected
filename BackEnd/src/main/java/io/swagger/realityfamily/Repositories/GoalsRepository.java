package io.swagger.realityfamily.Repositories;

import io.swagger.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GoalsRepository extends JpaRepository<Goal, UUID> {
}
