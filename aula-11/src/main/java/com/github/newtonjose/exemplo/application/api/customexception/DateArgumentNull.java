package com.github.newtonjose.exemplo.application.api.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = "the dates cant be empty")
public class DateArgumentNull extends IllegalArgumentException { }
