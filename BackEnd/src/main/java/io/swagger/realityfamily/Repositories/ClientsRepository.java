package io.swagger.realityfamily.Repositories;

import io.swagger.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientsRepository extends JpaRepository<Client, UUID> {
}
