package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Formater;
import org.springframework.stereotype.Component;

import java.util.List;

// todo let's make unit tests for this.
@Component
public class StringFormater implements Formater<String, List<ReportImpl>>
{
    /*
    This will be a vertical list of reports, starting with the designated team, and working up the tree.  Once that has been done,

     */
    StringBuffer b = new StringBuffer();

    public String format(String id, List<ReportImpl> input)
    {
        prereport(id,input);
        filter(id, input);
        return format(input);
    }

    private void prereport(String id, List<ReportImpl> input)
    {

    }

    @Override
    public String format(List<ReportImpl> input)
    {
        // todo implement
        return b.toString();
    }

    private void filter(String id, List<ReportImpl> input)
    {
        // todo  pull out id entry from list and return new list.
    }
}
