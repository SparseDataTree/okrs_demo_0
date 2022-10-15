package com.caccia.david.okrs_demo_0.demo.report.objects;

import com.caccia.david.okrs_demo_0.demo.report.interfaces.Ided;
import lombok.Data;

@Data
public class IdedElement implements Ided<String,String>
{

    private String elementId;
    private String userId;

    @Override
    public String getElementId()
    {
        return elementId;
    }

    @Override
    public String getUserId()
    {
        return userId;
    }
}
