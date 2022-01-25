package com.jokend.db.pojoAnswers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringAnswer {
    private String value;

    public StringAnswer(String value) {
        this.value = value;
    }
}
