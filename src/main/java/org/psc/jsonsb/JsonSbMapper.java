package org.psc.jsonsb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class JsonSbMapper {

    private final ObjectMapper objectMapper;

    @PostConstruct
    public void postConstruct() {
        objectMapper.setPropertyNamingStrategy(new UpperCasePropertyNamingStrategy());
    }

    public <T> String mapToString(T data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }

    static class UpperCasePropertyNamingStrategy extends PropertyNamingStrategy.PropertyNamingStrategyBase {

        @Override
        public String translate(String s) {
            return s.toUpperCase();
        }
    }
}
