package com.baeldung.cxf.introduction;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface = "com.baeldung.cxf.introduction.MyWebService", name = "myName", portName = "myPortName", serviceName = "myServiceName", targetNamespace = "oh.my")
public class MyWebServiceImpl implements MyWebService {
	private Map<Integer, Entity> entities = new LinkedHashMap<>();
	private boolean alive = true;

	public String sayHiTo(String name) {
		return "Hello " + name;
	}

	public String addEntity(Entity entity) {
		entities.put(entities.size() + 1, entity);
		return "Added " + entity.getName();
	}

	public Map<Integer, Entity> getEntities() {
		return entities;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	public void shutdown() {
		alive = false;
	}
}