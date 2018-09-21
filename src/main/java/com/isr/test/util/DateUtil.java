package com.isr.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.util.StringUtils;

/**
 * Created by gfs on 21/09/2018.
 */
public class DateUtil {

  /**
   * Utility method for parsing String to {@link Date} instance based on the given format
   * @param format - date format
   * @param value - value to be parsed
   * @return
   * @throws ParseException
   */
  public static Date parse(String format, String value) throws ParseException {
    if (StringUtils.isEmpty(value)) {
      return null;
    }
    return new SimpleDateFormat(format).parse(value);
  }


}
