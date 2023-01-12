package com.tkach.md.repository;

import com.tkach.md.model.DeviceSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceSeriesRepository extends JpaRepository<DeviceSeries, Long> {
}
