package com.tkach.md.validators.impl.deviceSeries;

import com.tkach.md.model.DeviceSeries;
import com.tkach.md.service.DeviceSeriesService;
import com.tkach.md.validators.DeviceSeriesValidator;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeviceSeriesExistsValidator implements DeviceSeriesValidator {
    @Autowired
    private DeviceSeriesService deviceSeriesService;

    @Override
    public void validate(DeviceSeries deviceSeries) {
        Optional<DeviceSeries> fromDB = deviceSeriesService.findByNameAndBrand(deviceSeries.getName(), deviceSeries.getBrand());
        if (fromDB.isPresent()){
            throw new EntityExistsException(String.format("Devise series with brand %s and name %s exists",deviceSeries.getBrand().getName(), deviceSeries.getName()));
        }
    }
}
