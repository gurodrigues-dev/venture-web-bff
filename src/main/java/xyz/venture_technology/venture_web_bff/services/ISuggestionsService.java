package xyz.venture_technology.venture_web_bff.services;

import xyz.venture_technology.venture_web_bff.exceptions.SuggestionException;
import xyz.venture_technology.venture_web_bff.models.SuggestionModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ISuggestionsService {
    SuggestionModel createSuggestion(SuggestionModel suggestion) throws SuggestionException;
    List<SuggestionModel> getAllSuggestions() throws SuggestionException;
    Optional<SuggestionModel> getSuggestionById(UUID id) throws SuggestionException;
    void deleteSuggestion(SuggestionModel suggestion) throws SuggestionException;
}
