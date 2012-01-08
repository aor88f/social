package ru.hh.school.example;

public class Logger {
  String s;
  public Logger(Object object) {
    s = object.getClass().toString();
    int dotLastIndex = s.lastIndexOf('.');
    if (dotLastIndex != -1)
      s = s.substring(dotLastIndex + 1);
  }
    
  public void log(String s) {
    System.out.println(this.s + "." + s);
  }
}
