package com.projectb.nogo.converter;

import com.projectb.nogo.constant.ExpirationPeriod;
import org.springframework.core.convert.converter.Converter;

public class StringToExpirationPeriod implements Converter<String, ExpirationPeriod> {
  @Override
  public ExpirationPeriod convert(String source) {
    if (source.equals("1")) {
      return ExpirationPeriod.ONE_YEAR;
    } else if (source.equals("3")) {
      return ExpirationPeriod.THREE_YEAR;
    } else if (source.equals("-1")) {
      return ExpirationPeriod.UNTIL_WITHDRAWAL;
    }
    return null;
  }
}
