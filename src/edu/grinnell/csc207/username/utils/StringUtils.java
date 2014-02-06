package edu.grinnell.csc207.username.utils;

import java.lang.String;
import java.util.Arrays;
import java.io.PrintWriter;

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
          } // if (newIndex == -1)
        strArray[strArrayIndex] = str.substring (fromIndex, newIndex);
        strArrayIndex++;
        fromIndex = newIndex + 1;
      } // while (fromIndex < str.length ())

    String[] strArrayTruncated = new String[strArrayIndex];

    if (newIndex == str.length () - 1)
      {
        strArrayTruncated = Arrays.copyOf (strArray, strArrayIndex + 1);
        strArrayTruncated[strArrayIndex] = "";
      } // if (newIndex == str.length() - 1)
    else
      {
        strArrayTruncated = Arrays.copyOf (strArray, strArrayIndex);
      } // else

    return strArrayTruncated;
  } // splitAt (String, char)

  public static void
    printValues (PrintWriter pen, String[] array)

  {
    int length = array.length;
    if (length == 0)
      {
        pen.println ("{}");
      }
    else
      {
        pen.print ("{\"");
        for (int i = 0; i < length - 1; i++)
          {
            pen.print ("\"" + array[i] + "\", ");
          }
        pen.println (array[length - 1] + "\"}");
      }
  }// printValues

  public static String[]
    splitCSV (String str)
  {
    PrintWriter pen = new PrintWriter (System.out, true);

    /* length of str */
    int strLength = str.length ();

    /* array of substrings */
    String[] output = new String[str.length ()];
    int strArrayIndex = 0;

    /* variables for traversing str */
    char ch;
    int index = 0;
    int prevStrIndex = 0;
    boolean quotesOpen = false;

    for (; index < strLength; index++)
      {
        ch = str.charAt (index);

        if (ch == ',' && quotesOpen == false)
          {
            output[strArrayIndex] = str.substring (prevStrIndex, index);
            strArrayIndex++;
            quotesOpen = false;
            prevStrIndex = index + 1;

          } // if (ch == ',')

        if (ch == '"')
          {
            quotesOpen = !quotesOpen;

            if (str.charAt (index + 1) == '"')
              {
                quotesOpen = !quotesOpen;
              } // if(str.charAt(i+1) == '"')

          } // if (ch == '"')

      } // for (int i = 0; i < str.length (); i++)

    if (prevStrIndex != index)
      {
        output[strArrayIndex] = str.substring (prevStrIndex, index);
      }

    String[] strArrayTruncated = new String[strArrayIndex];
    strArrayTruncated = Arrays.copyOf (output, strArrayIndex + 1);

    printValues (pen, output);
    printValues (pen, strArrayTruncated);
    return strArrayTruncated;

  } // splitCSV (String)


 
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
          } // switch (strTemp)
        a++;
        b++;
      } // for (int i = 0; i < str.length (); i++)
    return newStr;
  }// deLeet (String)

  /*
   * I found the code for this method from an isVowel method on Stack Overflow
   * http
   * ://stackoverflow.com/questions/19160921/how-do-i-check-if-a-char-is-a-vowel
   */
  public static int
    countLeadingVowels (String str)
  {
    int counter = 0;
    for (; counter < str.length (); counter++)
      {
        char ch = str.charAt (counter);
        if ("AEIOUaeiou".indexOf (ch) != -1)
          {
            break;
          } // if ("AEIOUaeiou".indexOf (ch) != -1)
      } // for (; counter < str.length (); counter++)
    return counter;
  } // countLeadingVowels ()

  public static String
    nameGame (String name)
  {
    String verse = "";

    int index = countLeadingVowels (name);
    String shortName;
    if (index == 0)
      {
        shortName = name.toLowerCase ();
      } // if (index == 0)
    else
      {
        shortName = name.substring (index);
      } // else

    verse += name + "! \n";
    verse += name + ", " + name + " bo B" + shortName + " Bonana fanna"
             + " fo F" + shortName + "\n";
    verse += "Fee fy mo M" + shortName + ", " + name + "!\n";

    return verse;
  } // nameGame (String)

  public static void
    main (String[] args)
      throws Exception
  {

    return;
  } // main (String[])

} // class StringUtils
