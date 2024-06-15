package xyz.venture_technology.venture_web_bff.dtos;

import jakarta.validation.constraints.NotBlank;

public record SuggestionRecordDTO(@NotBlank String title, @NotBlank String description) {
}
