package xyz.venture_technology.venture_web_bff.services;

import xyz.venture_technology.venture_web_bff.exceptions.FeatureException;
import xyz.venture_technology.venture_web_bff.models.FeatureModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IFeatureService {
    FeatureModel createFeature(FeatureModel feature) throws FeatureException;
    List<FeatureModel> getAllFeatures() throws FeatureException;
    Optional<FeatureModel> getFeatureById(UUID id) throws FeatureException;
    void deleteFeature(FeatureModel feature) throws FeatureException;
}

