package com.playground.sqs.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CarDTO {
    private final String brand;
    private final String model;
}
