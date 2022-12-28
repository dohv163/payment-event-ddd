package com.example.demo.domain.shared;

import com.example.demo.infra.util.i18n.I18nCode;
import java.util.Set;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommandFailure {

  public final Set<I18nCode> codes;

}
