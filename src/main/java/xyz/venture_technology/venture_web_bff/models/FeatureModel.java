package xyz.venture_technology.venture_web_bff.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="features")
public class FeatureModel extends RepresentationModel<FeatureModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFeature;
    private String title;
    private String Description;

    public UUID getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(UUID idFeature) {
        this.idFeature = idFeature;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
