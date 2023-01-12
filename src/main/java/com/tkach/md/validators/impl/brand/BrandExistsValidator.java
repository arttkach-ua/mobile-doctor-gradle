package com.tkach.md.validators.impl.brand;

import com.tkach.md.model.Brand;
import com.tkach.md.service.BrandService;
import com.tkach.md.validators.BrandValidator;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BrandExistsValidator implements BrandValidator {
    @Autowired
    private BrandService brandService;

    @Override
    public void validate(Brand brand) {
        Optional<Brand> brandFromDB = brandService.findByName(brand.getName());
        if (brandFromDB.isPresent()){
            throw new EntityExistsException(String.format("Brand %s exists",brand.getName()));
        }
    }
}
