package com.algorithm.practice.functional;

import java.util.function.Function;

public class SumFunction implements Function<Long, Long> {

    @Override
    public Long apply(Long aLong) {
        return aLong + 3;
    }
}
