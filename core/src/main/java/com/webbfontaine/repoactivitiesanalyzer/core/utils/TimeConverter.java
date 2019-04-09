package com.webbfontaine.repoactivitiesanalyzer.core.utils;

import java.util.concurrent.TimeUnit;

import static java.lang.Math.toIntExact;

public final class TimeConverter {

	private TimeConverter() {
		throw new IllegalStateException("Utility class");
	}

	public static int convertDaysToSeconds(int days) {
		return toIntExact(TimeUnit.DAYS.toSeconds(days));
	}

}
