package org.psc.jsonsb.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class MeaninglessData {

    @JsonProperty("someText")
    private String text;

    private Long sum;

    private String someAdditionalText;

    private BigDecimal anotherSum;

}
