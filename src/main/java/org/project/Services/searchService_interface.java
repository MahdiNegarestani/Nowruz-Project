package org.project.Services;

import org.project.Entities.entity;
import java.util.ArrayList;

public interface searchService_interface<S extends entity>{
    public ArrayList<S> getBySearch(String search);
}