package org.psc.jsonsb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.psc.jsonsb.domain.MeaninglessData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
@SpringBootTest
class JsonSbApplicationTests {

    @Autowired
    private JsonSbMapper mapper;

    @Value("classpath:testData.json")
    private Resource resource;

    @Test
    void testContextLoads() throws JsonProcessingException {
        MeaninglessData meaninglessData = new MeaninglessData().withText("some text")
                .withSum(12345L)
                .withSomeAdditionalText("more meaningless text")
                .withAnotherSum(new BigDecimal("1234.55555"));

        String convertedJson = mapper.mapToString(meaninglessData);

        assertThat(convertedJson, containsString("TEXT"));
        log.info(convertedJson);

    }

    @Test
    void testDeserialization() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        MeaninglessData input = objectMapper.readValue(resource.getInputStream(), MeaninglessData.class);
        assertThat(input, is(not(nullValue())));
    }


}
