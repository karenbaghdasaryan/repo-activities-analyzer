package com.webbfontaine.repoactivitiesanalyzer.core.utils;

public final class ErrorMessageUtils {

	private static final String TEMPLATE_FOR_NOT_NULL_ERROR_MESSAGE = "The %s should not be null";

	private ErrorMessageUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static String notNull(String name) {
		return String.format(TEMPLATE_FOR_NOT_NULL_ERROR_MESSAGE, name.toUpperCase());
	}

	public static String notNullPageable() {
		return ErrorMessageUtils.notNull("pageable");
	}
}
