package com.sinqia.teste_api.adapters;

import java.util.List;

public interface IAdapter {
	public <T> T get(String id);
	public List<?> getAll();
	public void create(Object obj);
	public boolean update(String id, Object updatedObj);
	public boolean delete(String id);
}
