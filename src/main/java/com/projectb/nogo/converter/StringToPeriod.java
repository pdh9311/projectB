package com.projectb.nogo.converter;

import com.projectb.nogo.constant.Period;
import org.springframework.core.convert.converter.Converter;

public class StringToPeriod implements Converter<String, Period> {
  @Override
  public Period convert(String source) {
    if (source.equals("oneYear")) {
      return Period.ONE_YEAR;
    } else if (source.equals("threeYear")) {
      return Period.THREE_YEAR;
    } else if (source.equals("untilWithdrawal")) {
      return Period.UNTIL_WITHDRAWAL;
    }
    return null;
  }
}
