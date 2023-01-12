package com.tkach.md.service.impl.validation;

import com.tkach.md.model.Brand;
import com.tkach.md.service.validation.BrandValidationService;
import com.tkach.md.validators.BrandValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BrandValidationServiceImpl implements BrandValidationService {
    private final List<BrandValidator> validators;
    @Override
    public void validate(Brand brand) {
        validators.forEach(v -> v.validate(brand));
    }
}
