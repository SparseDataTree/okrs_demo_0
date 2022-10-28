package com.caccia.david.okrs_demo_0.demo.report.interfaces;

/*
   Do we id and date this object? Probably.   I am think that reports do not directly support comments, rather
   the elements of a report are commented.  That way, comments are propagated.
 */
public interface Report<U,I,R,T> extends Ided<U,I>, Timed<T>, Linked
{

    R getReport();

    // TODO we need to work on report events to help develop this.


    // vertical OKRs - can be updated via report events  (We need to define what this looks like)


    // team OKR - can be updated and will trigger report events

    // subscribed OKRs - can be updated via report events

    // generate a consumable report - updates are triggered by new report events.
}
