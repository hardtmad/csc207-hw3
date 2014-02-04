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
    String[] strArray = new String[str.length ()];
    while (fromIndex < str.length ())
      {
        newIndex = str.indexOf (ch, fromIndex);
        if (newIndex == -1)
          {
            newIndex = str.length ();
          } //if
        strArray[strArrayIndex] = str.substring (fromIndex, newIndex);
        strArrayIndex++;
        fromIndex = newIndex + 1;
      } //while
    String[] strArrayTruncated = new String[strArrayIndex];
    strArrayTruncated = Arrays.copyOf (strArray, strArrayIndex);
    return strArrayTruncated;
  }// splitAt (String, char)

  public static String
    deLeet (String str)
  {
    String newStr = "";
    int a = 0;
    int b = 1;
    for (int i = 0; i < str.length (); i++)
      {
        String strTemp = str.substring (a, b);
        switch (strTemp)
          {
            case "+":
              newStr = newStr + "t";
              break;
            case "@":
              newStr = newStr + "a";
              break;
            case "|3":
              newStr = newStr + "b";
              a += 1;
              break;
            case "3":
              newStr = newStr + "e";
              break;
            case "1":
              newStr = newStr + "l";
              break;
            case "|\\|":
              newStr = newStr + "n";
              a += 2;
              break;
            case "0":
              newStr = newStr + "o";
              break;
            case " ":
              newStr = newStr + " ";
              break;
            default:
              a--;
              break;
          } //switch
        a++;
        b++;
      } //for
    return newStr;
  }//deLeet (String)

  public static void
    main (String[] args)
      throws Exception
  {
    return;
  }// main (String[])

}// class StringUtils
