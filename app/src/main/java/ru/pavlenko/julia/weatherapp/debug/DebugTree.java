package ru.pavlenko.julia.weatherapp.debug;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

import timber.log.Timber;

public class DebugTree extends Timber.DebugTree {
    @Override
    protected void log(int priority, String tag, @NotNull String message, Throwable t) {
        final StackTraceElement ste = new Throwable().fillInStackTrace().getStackTrace()[5];
        super.log(priority, tag,
                String.format(Locale.US, "[%s] %s(%s:%s) %s",
                        Thread.currentThread().getName(),
                        ste.getMethodName(),
                        ste.getFileName(),
                        ste.getLineNumber(),
                        message), t);
    }
}
