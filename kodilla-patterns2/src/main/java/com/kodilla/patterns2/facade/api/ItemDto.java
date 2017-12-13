package com.kodilla.patterns2.facade.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemDto {
    private final Long productId;
    private final double quantity;
}
