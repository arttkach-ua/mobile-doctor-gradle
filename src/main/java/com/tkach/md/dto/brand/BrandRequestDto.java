package com.tkach.md.dto.brand;

import com.tkach.md.util.ValidationMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandRequestDto {
    @NotBlank
    @Size(min = 2,message = ValidationMessages.SHORT_BRAND_NAME)
    private String name;
}
