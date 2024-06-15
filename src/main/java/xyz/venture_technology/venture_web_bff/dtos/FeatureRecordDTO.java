package xyz.venture_technology.venture_web_bff.dtos;

import jakarta.validation.constraints.NotBlank;

public record FeatureRecordDTO(@NotBlank String title, @NotBlank String description) {
}
