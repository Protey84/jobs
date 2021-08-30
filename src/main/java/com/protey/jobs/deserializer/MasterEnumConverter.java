package com.protey.jobs.deserializer;

import com.protey.jobs.entity.Master;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Stream;

public final class MasterEnumConverter implements Converter<String, Master> {
    @Override
    public Master convert(String s) {
        if (s == null) {
            return null;
        }

        return Stream.of(Master.values())
                .filter(c -> c.toString().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static void main(String[] args) {
        System.out.print(new MasterEnumConverter().convert("Бабин Александр"));
    }
}
