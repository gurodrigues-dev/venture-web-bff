package xyz.venture_technology.venture_web_bff.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.venture_technology.venture_web_bff.exceptions.SuggestionException;
import xyz.venture_technology.venture_web_bff.models.SuggestionModel;
import xyz.venture_technology.venture_web_bff.repositories.SuggestionRepository;
import xyz.venture_technology.venture_web_bff.services.ISuggestionsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SuggestionServiceImpl implements ISuggestionsService {

    @Autowired
    private SuggestionRepository suggestionRepository;

    @Override
    public SuggestionModel createSuggestion(SuggestionModel suggestion) {
        try {
            return suggestionRepository.save(suggestion);
        } catch (Exception e) {
            throw new SuggestionException("Erro ao criar sugestão", e);
        }
    }

    @Override
    public List<SuggestionModel> getAllSuggestions() {
        try {
            return suggestionRepository.findAll();
        } catch (Exception e) {
            throw new SuggestionException("Erro ao buscar todas as sugestões", e);
        }
    }

    @Override
    public Optional<SuggestionModel> getSuggestionById(UUID id) {
        try {
            return suggestionRepository.findById(id);
        } catch (Exception e) {
            throw new SuggestionException("Erro ao encontrar sugestão", e);
        }
    }


    @Override
    public void deleteSuggestion(SuggestionModel suggestion) {
        try {
            suggestionRepository.deleteById(suggestion.getIdSuggestion());
        } catch (Exception e) {
            throw new SuggestionException("Erro a deletar sugestão", e);
        }
    }

}
