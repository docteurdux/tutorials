package com.baeldung.cxf.introduction;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(StudentAdapter.class)
public interface Entity {
    public String getName();
}