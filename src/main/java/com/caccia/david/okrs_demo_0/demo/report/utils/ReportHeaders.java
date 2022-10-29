package com.caccia.david.okrs_demo_0.demo.report.utils;

public enum ReportHeaders
{
    // TODO consider if we want headers to be more distinct.
    Objectives("Objectives: "),
    Objective("Objective: "),
    KeyResults("Key Results: "),
    KeyResult("Key Result: ");

    private static final String LINE = System.lineSeparator() + System.lineSeparator();

    private String wrap(String text)
    {
        return text + LINE;
    }

    private final String text;

    ReportHeaders(String text)
    {
        this.text = text;
    }
    @Override
    public String toString()
    {
        return wrap(text);

    }
}
