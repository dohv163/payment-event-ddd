package com.example.demo.interfaces.rest.model;


import com.example.demo.infra.util.i18n.I18nMessage;
import lombok.Data;

import java.util.Set;

@Data
public class ErrorResponse {
    private Set<I18nMessage> errors;
}
