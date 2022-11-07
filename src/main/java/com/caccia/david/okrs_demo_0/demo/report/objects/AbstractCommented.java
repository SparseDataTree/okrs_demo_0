package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Commented;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Ided;
import com.caccia.david.okrs_demo_0.demo.report.interfaces.Thread;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public abstract class AbstractCommented<E, I> implements Ided<I>, Commented<String, E, Date,String>
{
    /*
    Note that we do NOT want a boolean to indicate that new comments have been added since the last report.
    Better would be to provide the date of the most recent comment.  This could be used by a report assembler
    But we might consider putting fields into a report giving things like:  date of most recent change to objectives and
    key results (and maybe even ids of the changed objects).  Additionally, we might have a field that gives the date of the
    most recently added comment.
    This decouples the report object from any decisions to provide information about the recency of changes.
     */

    private Date time;
    private Set<Thread<String, Date, String>> threads;

    @Override
    public Date getTime()
    {
        return time;
    }

    @Override
    public Set<Thread<String, Date, String>> getThreads()
    {
        return threads;
    }

    /*
    We want a mechanism that can be used flexibly by report generators.  TODO consider putting an entry into a report indicating if
    there are new comments in a report.
     */
    @Override
    public Date getTimeOfMostRecentComment()
    {
        if(threads.isEmpty())
        {
            return time;
        }
        Date mostRecentDate = time;
        for(Thread thread: threads)
        {
            List<CommentImpl> commentList = thread.getThread();
            Date mostRecentDateOnThread = commentList.get(commentList.size() -1).getTime();
            if(mostRecentDate.before(mostRecentDateOnThread))
            {
                mostRecentDate = mostRecentDateOnThread;
            }
        }
        return mostRecentDate;
    }
}
