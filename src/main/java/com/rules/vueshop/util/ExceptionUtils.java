package com.rules.vueshop.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

public class ExceptionUtils {
    public ExceptionUtils() {
    }

    public static String stringifyException(Throwable throwable) {
        if (Objects.isNull(throwable)) {
            return "(null)";
        } else {
            StringWriter writer = new StringWriter();
            throwable.printStackTrace(new PrintWriter(writer));
            return writer.toString();
        }
    }

    public static String rethrow(Throwable throwable) {
        if (throwable instanceof Error) {
            throw (Error)throwable;
        } else if (throwable instanceof RuntimeException) {
            throw (RuntimeException)throwable;
        } else {
            throw new RuntimeException(throwable);
        }
    }
}
