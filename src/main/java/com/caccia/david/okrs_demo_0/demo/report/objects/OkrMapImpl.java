package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.ObjectiveId;
import com.caccia.david.okrs_demo_0.demo.report.objects.ids.HierarchicalIdImpl;

import java.util.List;

public class OkrMapImpl extends AbstractIdedMap<ObjectiveId, HierarchicalIdImpl, List<ObjectiveAndKeyResults>>
{
    // This is at the level of a team set of OKRs.  Note that versioning is done at the level of one objective and its
    // associated key results.  These components can be commented.

    // todo question: does the hierarchical id make sense for objectives and key results?  I like it for teams.
    // one approach would be to have reserved terms for name types:  eg. "exec" -> "dir" -> "team" -> "OBJECTIVE-agility" -> "KEY_RESULT-pivot-rate"
    // In this case, teams can be any name nat starting with a reserved prefix.  We see reserved prefixes here of "OBJECTIVE-" and "KEY-RESULT-"
    // Maybe.
    // Other ideas?  Maybe hierarchical ids for teams are scoped for each team.  We could expand the HierarchicalId class type to include fields for objectives and for key results.
    // That seems cleaner.

}
