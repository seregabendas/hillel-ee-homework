package com.jmx_test;

public interface JMXResourceI {
    String getValue();

    void setValue(String value);

    void printJMXResorceInfo();

    @Override
    String toString();
}
