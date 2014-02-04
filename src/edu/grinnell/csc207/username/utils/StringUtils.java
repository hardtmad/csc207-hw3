package edu.grinnell.csc207.username.utils;

import java.lang.String;
import java.util.Arrays;

public class StringUtils
{
  public static String[]
    splitAt (String str, char ch)
  {
    int fromIndex = 0;
    int newIndex = 0;
    int strArrayIndex = 0;
    String[] strArray = new String[str.length()];
    while (fromIndex < str.length())
      {
        newIndex = str.indexOf (ch, fromIndex);
        if (newIndex == -1) {
          newIndex = str.length();
        } // if
        strArray[strArrayIndex] = str.substring (fromIndex, newIndex);
        strArrayIndex++;
        fromIndex = newIndex + 1;
      }
    String[] strArrayTruncated = new String[strArrayIndex];
    strArrayTruncated = Arrays.copyOf(strArray, strArrayIndex);
    return strArrayTruncated;
  }// splitAt (String, char)

  public static void
    main (String[] args)
      throws Exception
  {
    return;
  }// main (String[])

}// class StringUtils
