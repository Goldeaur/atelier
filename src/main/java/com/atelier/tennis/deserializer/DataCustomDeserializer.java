package com.atelier.tennis.deserializer;

import com.atelier.tennis.model.dto.Data;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.DataInput;
import java.io.IOException;

public class PlayerDataCustomDeserializer extends StdDeserializer<Data> {


    protected PlayerDataCustomDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Data deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode jsonNode = oc.readTree(jsonParser);
        Data data = new ObjectMapper().readValue((DataInput) jsonNode, Data.class);

        return Data.builder()
                .rank(jsonNode.get("rank").intValue())
                .points(jsonNode.get("points").intValue())
                .weight(jsonNode.get("weight").intValue())
                .height(jsonNode.get("height").intValue())
                .birthday(jsonNode.get("birthday").textValue())
                .titles(jsonNode.get("title").asText())
                .last()
                .bmi()
                .build();
    }
}
