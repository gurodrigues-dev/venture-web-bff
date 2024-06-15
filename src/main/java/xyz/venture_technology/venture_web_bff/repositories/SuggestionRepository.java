package xyz.venture_technology.venture_web_bff.repositories;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.venture_technology.venture_web_bff.models.SuggestionModel;

import java.util.UUID;

@Repository
public interface SuggestionRepository extends JpaRepository<SuggestionModel, UUID> {}
