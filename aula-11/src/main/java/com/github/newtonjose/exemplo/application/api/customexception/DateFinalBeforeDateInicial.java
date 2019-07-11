package com.github.newtonjose.exemplo.application.api.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = "data final está antes da data inicial")
public class DateFinalBeforeDateInicial extends IllegalArgumentException {
}
