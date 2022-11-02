package com.projectb.nogo.converter;

import com.projectb.nogo.constant.AuthMethod;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

public class StringToAuthMethod implements Converter<String, AuthMethod> {
  @Override
  public AuthMethod convert(String source) {
    if (source.equals("phone")) {
      return AuthMethod.PHONE;
    } else if (source.equals("ipin")) {
      return AuthMethod.IPIN;
    }
    return null;
  }
}
