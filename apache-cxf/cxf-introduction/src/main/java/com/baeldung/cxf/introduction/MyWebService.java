package com.baeldung.cxf.introduction;

import java.util.Map;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService
public interface MyWebService {
    public String sayHiTo(String name);

    public String addEntity(Entity student);

    @XmlJavaTypeAdapter(EntityMapAdapter.class)
    public Map<Integer, Entity> getEntities();

	public boolean isAlive();
	public void shutdown();
}