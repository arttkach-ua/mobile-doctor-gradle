package com.tkach.md.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationMessages {

    public static final String SHORT_BRAND_NAME = "Brand name must be at least 1 symbol";
    public static final String SHORT_SERIES_NAME = "Series name must be at least 1 symbol";
}
