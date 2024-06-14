package com.motta.attendance_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
public class AttendanceAlreadyExistsException extends RuntimeException {

	public AttendanceAlreadyExistsException(String message) {
		super(message);
	}
}
