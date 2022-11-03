package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import java.util.List;
import java.util.Map;

public interface Okr<I, T,V>
{
    // Note that we do not presently see a need ot set up team name and team summary to commenting.
    // But do we want to save versions of summaries?  Let's see if this works.

    T getObjective();
    Map<I,V> getKeyResults();
}
