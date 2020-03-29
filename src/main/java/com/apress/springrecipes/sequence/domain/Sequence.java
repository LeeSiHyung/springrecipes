package com.apress.springrecipes.sequence.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class Sequence {
    private final String id;
    private final String prefix;
    private final String suffix;
}
