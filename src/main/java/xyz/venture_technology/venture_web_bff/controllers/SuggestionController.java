package xyz.venture_technology.venture_web_bff.controllers;

import jakarta.validation.Valid;
import jdk.jshell.SourceCodeAnalysis;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.venture_technology.venture_web_bff.dtos.SuggestionRecordDTO;
import xyz.venture_technology.venture_web_bff.models.SuggestionModel;
import xyz.venture_technology.venture_web_bff.services.impl.SuggestionServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class SuggestionController {

    @Autowired
    SuggestionServiceImpl suggestionService;

    @PostMapping("/api/v1/suggestion")
    public ResponseEntity<SuggestionModel> createSuggestion(@RequestBody @Valid SuggestionRecordDTO suggestionRecordDTO) {
        try {
            var suggestionModel = new SuggestionModel();
            BeanUtils.copyProperties(suggestionRecordDTO, suggestionModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(suggestionService.createSuggestion(suggestionModel));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/api/v1/suggestion")
    public ResponseEntity<List<SuggestionModel>> getAllSuggestions() {
        try {
            List<SuggestionModel> suggestionsList = suggestionService.getAllSuggestions();
            if (!suggestionsList.isEmpty()) {
                for (SuggestionModel suggestion : suggestionsList) {
                    UUID id = suggestion.getIdSuggestion();
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(suggestionsList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/api/v1/suggestion/{id}")
    public ResponseEntity<SuggestionModel> getSuggestionById(@PathVariable(value="id")UUID id) {
        try {
            Optional<SuggestionModel> suggestionO = suggestionService.getSuggestionById(id);
            if (suggestionO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(suggestionO.get());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/api/v1/suggestion/{id}")
    public ResponseEntity<Object> deleteSuggestionById(@PathVariable(value="id")UUID id) {
        try {
            Optional<SuggestionModel> suggestionO = suggestionService.getSuggestionById(id);
            if (suggestionO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sugestão não encontrada.");
            }
            suggestionService.deleteSuggestion(suggestionO.get());
            return ResponseEntity.status(HttpStatus.OK).body("Sugestão deletada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
