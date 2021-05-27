package ru.alex.two.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SimpleResult<T> {
    private final T result;
}
