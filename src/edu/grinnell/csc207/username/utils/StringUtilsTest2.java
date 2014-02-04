package edu.grinnell.csc207.username.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest2
{

  @Test
  public void
    testDeLeet ()
  {
    assertEquals ("e", StringUtils.deLeet ("3"));
    assertEquals ("leet", StringUtils.deLeet ("133+"));
    assertEquals ("eat banana", StringUtils.deLeet ("3@+ |3@|\\|@|\\|@"));
  }

}
