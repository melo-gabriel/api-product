package com.byteup.apiproduct.entities.dtos;

import java.util.Date;

public record ProductRecordDto(String name, Date expirationDate, Float price, int quantity) {
}

