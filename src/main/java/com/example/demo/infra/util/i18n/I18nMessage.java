package com.example.demo.infra.util.i18n;

import lombok.Data;

@Data
public class I18nMessage {
    private String field;
    private Object rejectedValue;
    private String message;
}
