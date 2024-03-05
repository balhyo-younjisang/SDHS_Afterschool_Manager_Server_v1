package com.yunjisang.afterschool.afterschool.global.common;

import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.AttributeConverter;

public abstract class AbstractCodedEnumConverter<T extends Enum<T> & CodeEnum<E>, E>
        implements AttributeConverter<T, E> {
    private final Class<T> clazz;

    public AbstractCodedEnumConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public E convertToDatabaseColumn(T attribute) {
        return attribute.getCode();
    }

    @Override
    public T convertToEntityAttribute(E dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> e.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown code: " + dbData));
    }
}
