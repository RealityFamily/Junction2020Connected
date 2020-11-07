package io.swagger.realityfamily.Repositories;

import io.swagger.model.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatternsRepository extends JpaRepository<Pattern, UUID> {
}
