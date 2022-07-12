package com.gon.custom;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomTimestamp  extends JsonDeserializer<Timestamp>{
	  @Override
	    public Timestamp deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
	        return Timestamp.from(Instant.parse(p.getText()));
	    }
}
