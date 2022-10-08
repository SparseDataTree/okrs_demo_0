package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import java.util.List;

public interface Okr<I, T,V> extends Ided<I> // Timed?
{
    // Note that we do not presently see a need ot set up team name and team summary to commenting.
    // But do we want to save versions of summaries?  Let's see if this works.
    String getTeamName();
    String getTeamSummary();
    T getObjective();
    List<V> getKeyResults();
}
