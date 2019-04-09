package com.webbfontaine.repoactivitiesanalyzer.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.webbfontaine.repoactivitiesanalyzer.core.exception.JsonException;

import java.io.IOException;
import java.io.InputStream;

public class JSON {

	private static JSON instance;
	private ObjectMapper mapper;

	private JSON() {
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

	public static JSON I() {
		if (instance == null) {
			instance = new JSON();
		}
		return instance;
	}

	public String encode(Object obj) throws JsonException {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException ex) {
			throw new JsonException(ex.getMessage(), ex);
		}
	}

	public String prettyPrint(Object obj) throws JsonException {
		try {
			return mapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(obj);
		} catch (JsonProcessingException ex) {
			throw new JsonException(ex.getMessage(), ex);
		}
	}

	public <T> T decode(String json, Class<T> clazz) throws JsonException {
		try {
			return mapper.readValue(json, clazz);
		} catch (IOException ex) {
			throw new JsonException(ex.getMessage(), ex);
		}
	}

	public <T> T decode(String json, TypeReference valueTypeRef) throws JsonException {
		try {
			return mapper.readValue(json, valueTypeRef);
		} catch (IOException ex) {
			throw new JsonException(ex.getMessage(), ex);
		}
	}

	public <T> T decode(InputStream stream, TypeReference valueTypeRef) throws JsonException {
		try {
			return mapper.readValue(stream, valueTypeRef);
		} catch (IOException ex) {
			throw new JsonException(ex.getMessage(), ex);
		}
	}


	public <T> T decode(InputStream stream, Class<T> clazz) throws JsonException {
		try {
			return mapper.readValue(stream, clazz);
		} catch (IOException ex) {
			throw new JsonException(ex.getMessage(), ex);
		}
	}

	public byte[] encodeToByteArray(Object obj) throws JsonException {
		try {
			return mapper.writeValueAsBytes(obj);
		} catch (JsonProcessingException ex) {
			throw new JsonException(ex.getMessage(), ex);
		}
	}

	public <T> T convert(Object source, Class<T> targetClass) throws JsonException {
		return decode(encode(source), targetClass);
	}
}
