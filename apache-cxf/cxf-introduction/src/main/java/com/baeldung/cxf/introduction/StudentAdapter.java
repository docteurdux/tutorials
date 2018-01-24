package com.baeldung.cxf.introduction;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StudentAdapter extends XmlAdapter<StudentImpl, Entity> {
    public StudentImpl marshal(Entity student) throws Exception {
        if (student instanceof StudentImpl) {
            return (StudentImpl) student;
        }
        return new StudentImpl(student.getName());
    }

    public Entity unmarshal(StudentImpl student) throws Exception {
        return student;
    }
}