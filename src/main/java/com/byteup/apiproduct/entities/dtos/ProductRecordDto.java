package com.byteup.apiproduct.entities.dtos;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

public record ProductRecordDto(@NotNull String name,@NotNull Date expirationDate,@NotNull Float price,@NotNull int quantity) implements Serializable {
}

