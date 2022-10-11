package com.caccia.david.okrs_demo_0.demo.report.interfaces;

import java.util.Map;

public interface ReportEvent<T,R>
{

    // For now, we support deletion of objectives and of key results - not from the history, but from the current state.
    // One way to do this would be to have lists of objectives (by okr id and by objective id) and lists of key results
    // (by okr id, objective id, and kr id).

    // We support addition of new objectives and key results and comments
    // new versions of existing objectives, key results, and comments.
    // How do we capture this?
    Map<T,R> reportOKRs(); // hm?

}
