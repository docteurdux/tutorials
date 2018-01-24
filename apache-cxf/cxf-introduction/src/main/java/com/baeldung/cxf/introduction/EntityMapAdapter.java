package com.baeldung.cxf.introduction;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EntityMapAdapter extends XmlAdapter<StudentMap, Map<Integer, Entity>> {
    public StudentMap marshal(Map<Integer, Entity> boundMap) throws Exception {
        StudentMap valueMap = new StudentMap();
        for (Map.Entry<Integer, Entity> boundEntry : boundMap.entrySet()) {
            StudentMap.StudentEntry valueEntry = new StudentMap.StudentEntry();
            valueEntry.setStudent(boundEntry.getValue());
            valueEntry.setId(boundEntry.getKey());
            valueMap.getEntries().add(valueEntry);
        }
        return valueMap;
    }

    public Map<Integer, Entity> unmarshal(StudentMap valueMap) throws Exception {
        Map<Integer, Entity> boundMap = new LinkedHashMap<Integer, Entity>();
        for (StudentMap.StudentEntry studentEntry : valueMap.getEntries()) {
            boundMap.put(studentEntry.getId(), studentEntry.getStudent());
        }
        return boundMap;
    }
}