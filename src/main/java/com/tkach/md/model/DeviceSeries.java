package com.tkach.md.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "device_series")
@Getter
@Setter
public class DeviceSeries implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @ManyToOne()
    @JoinColumn(name = "brands_id")
    private Brand brand;
}
