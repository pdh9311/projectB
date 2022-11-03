package com.projectb.nogo.security.lea;

import com.projectb.nogo.security.lea.BlockCipher.Mode;
import com.projectb.nogo.security.lea.padding.PKCS5Padding;
import com.projectb.nogo.security.lea.symm.LEA;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


@Component
public class LeaTool {

  private final String keyString = "nogoLeaKey";
  private final BlockCipherMode cipher = new LEA.ECB();

  public String decrypt(String encoded) throws UnsupportedEncodingException {

    cipher.reset();
    cipher.init(Mode.DECRYPT, getKey());
    cipher.setPadding(new PKCS5Padding(16));

    return new String(cipher.doFinal(hexStringToByteArray(encoded)), StandardCharsets.UTF_8);
  }


  public String encrypt(String data) throws UnsupportedEncodingException {

    cipher.reset();
    cipher.init(Mode.ENCRYPT, getKey());
    cipher.setPadding(new PKCS5Padding(16));

    return byteArrayToHexString(cipher.doFinal(data.getBytes("utf-8")));
  }

  private String byteArrayToHexString(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%02X", b & 0xff));
    }
    return sb.toString();
  }

  private byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
      data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
          + Character.digit(s.charAt(i + 1), 16));
    }
    return data;
  }

  private byte[] getKey() throws UnsupportedEncodingException {
    return keyString.getBytes("utf-8");
  }
}
