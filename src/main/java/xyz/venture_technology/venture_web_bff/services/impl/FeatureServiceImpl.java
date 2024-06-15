package xyz.venture_technology.venture_web_bff.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.venture_technology.venture_web_bff.exceptions.FeatureException;
import xyz.venture_technology.venture_web_bff.models.FeatureModel;
import xyz.venture_technology.venture_web_bff.repositories.FeatureRepository;
import xyz.venture_technology.venture_web_bff.services.IFeatureService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeatureServiceImpl implements IFeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Override
    public FeatureModel createFeature(FeatureModel feature) {
        try {
            return featureRepository.save(feature);
        } catch (Exception e) {
            throw new FeatureException("Erro ao criar feature", e);
        }
    }

    @Override
    public List<FeatureModel> getAllFeatures() {
        try {
            return featureRepository.findAll();
        } catch (Exception e) {
            throw new FeatureException("Erro ao buscar todas as features", e);
        }
    }

    @Override
    public Optional<FeatureModel> getFeatureById(UUID id) {
        try {
            return featureRepository.findById(id);
        } catch (Exception e) {
            throw new FeatureException("Erro ao encontrar feature", e);
        }
    }


    @Override
    public void deleteFeature(FeatureModel feature) {
        try {
            featureRepository.deleteById(feature.getIdFeature());
        } catch (Exception e) {
            throw new FeatureException("Erro a deletar sugestão", e);
        }
    }

}
