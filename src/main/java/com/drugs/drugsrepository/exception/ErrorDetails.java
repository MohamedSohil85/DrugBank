package com.drugs.drugsrepository.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record ErrorDetails(@JsonFormat(pattern = "yyyy-MM-dd") Date timestamp, String message, String details) {

}
