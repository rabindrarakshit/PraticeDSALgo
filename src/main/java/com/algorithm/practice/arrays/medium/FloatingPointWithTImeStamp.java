package com.algorithm.practice.arrays.medium;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FloatingPointWithTImeStamp {
    public Float getFloatingValue() {
        return floatingValue;
    }

    public void setFloatingValue(Float floatingValue) {
        this.floatingValue = floatingValue;
    }

    Float floatingValue;
    Timestamp timestamp;

    public FloatingPointWithTImeStamp(Float floatingValue, Timestamp timestamp) {
        this.floatingValue = floatingValue;
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

class FloatingPointUtil {
    List<FloatingPointWithTImeStamp> list = new ArrayList<>();

    public void insert(FloatingPointWithTImeStamp val) {
        list.add(val);
    }
    public List<FloatingPointWithTImeStamp> getAll() {
        return list.stream().filter(val -> val.getTimestamp().after(Timestamp.from(Instant.now().minusSeconds(60)))).collect(Collectors.toList());
    }

}

class Test {
    public static void main(String[] args) {

    }
}
