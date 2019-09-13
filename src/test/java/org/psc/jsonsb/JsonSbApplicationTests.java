package org.psc.jsonsb;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.psc.jsonsb.domain.MeaninglessData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Slf4j
@SpringBootTest
class JsonSbApplicationTests {

    @Autowired
    private JsonSbMapper mapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        MeaninglessData meaninglessData = new MeaninglessData().withText("some text")
                .withSum(12345L)
                .withSomeAdditionalText("more meaningless text")
                .withAnotherSum(new BigDecimal("1234.55555"));

        String convertedJson = mapper.mapToString(meaninglessData);

        assertThat(convertedJson, containsString("TEXT"));
        log.info(convertedJson);



    }

}
