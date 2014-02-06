package edu.grinnell.csc207.username.utils;

import java.math.BigInteger;
import java.lang.String;

public class Calculator
{
  
  /*Part E*/
  public static BigInteger
    eval0 (String str)
  {
    int strLength = str.length ();
    char ch;
    BigInteger eval = BigInteger.valueOf (0);
    eval = BigInteger.valueOf(str.charAt(0) - '0');
    
    int number = 0;
    char operation = 0;

    for (int i = 2; i < strLength; i += 2)
      {
        ch = str.charAt (i);

        if ("+-*/^".indexOf (ch) != -1)
          {
            operation = ch;

          } // if

        else
          {
            number = (int) ch - '0';

            switch (operation)
              {
                case '+':
                  eval = eval.add (BigInteger.valueOf (number));
                  break;
                case '-':
                  eval = eval.subtract (BigInteger.valueOf (number));
                  break;
                case '*':
                  eval = eval.multiply (BigInteger.valueOf (number));
                  break;
                case '/':
                  eval = eval.divide (BigInteger.valueOf (number));
                  break;
                case '^':
                  eval = eval.pow ((int) number);
                  break;
                default:
                  break;
              } // switch
            
            System.out.println ("i " + i + " eval " + eval);
          } // else

       
      }

    return eval;
  } // eval0 (String)
}
