package com.adamzfc.infrastructure;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by adamzfc on 2017/7/6.
 */
public class CommonUtils {
    // https://stackoverflow.com/questions/18546842/stack-trace-as-string
    public static String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}
