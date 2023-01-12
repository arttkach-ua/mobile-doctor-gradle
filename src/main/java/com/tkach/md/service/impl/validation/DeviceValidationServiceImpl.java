package com.tkach.md.service.impl.validation;

import com.tkach.md.model.DeviceSeries;
import com.tkach.md.service.validation.DeviceValidationService;
import com.tkach.md.validators.DeviceSeriesValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Log4j2
@RequiredArgsConstructor
public class DeviceValidationServiceImpl implements DeviceValidationService {

    private final List<DeviceSeriesValidator> validators;

    @Override
    public void validate(DeviceSeries deviceSeries) {
        validators.forEach(v -> v.validate(deviceSeries));
    }
}
