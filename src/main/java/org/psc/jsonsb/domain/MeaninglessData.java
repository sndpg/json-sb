package org.psc.jsonsb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Wither
public class MeaninglessData {

    private String text;

    private Long sum;

    private String someAdditionalText;

    private BigDecimal anotherSum;

}
