package com.log_test;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class HTMLFormatter extends Formatter {

    public String format(LogRecord record) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n<table>")
                .append(getRaw(Arrays.asList("date", getDate(record.getMillis()))))
                .append(getRaw(Arrays.asList("level", record.getLevel().toString())))
                .append(getRaw(Arrays.asList("message", record.getMessage())))
                .append(getRaw(Arrays.asList("class", record.getSourceClassName())))
                .append(getRaw(Arrays.asList("method", record.getSourceMethodName())))
                .append("\n</table>\n");
        return stringBuilder.toString();
    }

    private String getDate(long millis) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(millis);
        return gc.getTime().toString();
    }


    private String getRaw(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n<tr>");
        for (String str : list) {
            stringBuilder.append(getData(str));
        }
        stringBuilder.append("</tr>");
        return stringBuilder.toString();
    }

    private String getData(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<td>")
                .append(str)
                .append("</td>");
        return stringBuilder.toString();
    }
}
