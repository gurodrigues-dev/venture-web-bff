package xyz.venture_technology.venture_web_bff.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.venture_technology.venture_web_bff.dtos.FeatureRecordDTO;
import xyz.venture_technology.venture_web_bff.models.FeatureModel;
import xyz.venture_technology.venture_web_bff.services.impl.FeatureServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class FeatureController {

    @Autowired
    FeatureServiceImpl featureService;

    @PostMapping("/api/v1/feature")
    public ResponseEntity<FeatureModel> createFeature(@RequestBody @Valid FeatureRecordDTO featureRecordDTO) {
        try {
            var featureModel = new FeatureModel();
            BeanUtils.copyProperties(featureRecordDTO, featureModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(featureService.createFeature(featureModel));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/api/v1/feature")
    public ResponseEntity<List<FeatureModel>> getAllFeatures() {
        try {
            List<FeatureModel> featuresList = featureService.getAllFeatures();
            if (!featuresList.isEmpty()) {
                for (FeatureModel feature : featuresList) {
                    UUID id = feature.getIdFeature();
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(featuresList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/api/v1/feature/{id}")
    public ResponseEntity<FeatureModel> getFeatureById(@PathVariable(value="id")UUID id) {
        try {
            Optional<FeatureModel> featureO = featureService.getFeatureById(id);
            if (featureO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(featureO.get());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/api/v1/feature/{id}")
    public ResponseEntity<Object> deleteFeatureById(@PathVariable(value="id")UUID id) {
        try {
            Optional<FeatureModel> featureO = featureService.getFeatureById(id);
            if (featureO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feature não encontrada.");
            }
            featureService.deleteFeature(featureO.get());
            return ResponseEntity.status(HttpStatus.OK).body("Feature deletada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
