package org.project.Services;

import java.util.ArrayList;
import org.project.Entities.entity;

public interface service_interface<S extends entity> {
    public S getById(String id);
    public void delete(S s);
    public void add(S s);
    public void edit(S s);
    public ArrayList<S> getAll();
}