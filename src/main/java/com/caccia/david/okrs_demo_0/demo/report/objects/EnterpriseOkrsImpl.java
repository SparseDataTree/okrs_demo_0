package com.caccia.david.okrs_demo_0.demo.report.objects;


import java.util.List;

public class EnterpriseOkrsImpl extends AbstractIdedMap<OkrMapImpl>
{
    String oKRsID;

    List<String> verticalOkrsIds;

    // TODO create a utility class to generate user-consumable reports from this.
    // See notes in the Report interface.
    // There is not presently any vertical structure here.  This might be added:

    // List of Team OKRs by id, giving the vertical relations?

    // Graph of Team OKRs by id, that can handle gaps, starting with the team OKRs?  This might better support
    // subscriptions to the OKRs of other teams.

    // Didn't we have the idea that reports would be inherited; that we would append to the vertical report?

    // Each team has its own report section.

    // Each team can offer its cumulative report, capturing the vertical OKRs, and also offers its specific team report
    // We can use our topics to propagate these.  In this case, a report change cascades down through the "cumulative" topic.
    // A team change is posted to both the "cumulative" topic and to the "team" topic.

    // At a team level, one can get three reports:  cumulative, team only, and full - which is cumulative plus subscribed.

    // But we also want the components of the report to be accessible for comments.

    // So, I'm thinking that each team have an OKR structure that supports comments, but that none of this structure be
    // part of the report events.

    // It also seems that reports should propagate as team units, rather than as increasingly large assemblies.


}
