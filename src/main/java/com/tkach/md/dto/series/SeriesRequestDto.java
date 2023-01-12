package com.tkach.md.dto.series;

import com.tkach.md.util.ValidationMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeriesRequestDto {
    @NotNull
    private Long brandId;
    @NotBlank
    @Size(min = 2,message = ValidationMessages.SHORT_SERIES_NAME)
    private String name;

    public void checkBrandId(Long id){
        if (getBrandId()==null) {
            setBrandId(id);
        }
    }
}
