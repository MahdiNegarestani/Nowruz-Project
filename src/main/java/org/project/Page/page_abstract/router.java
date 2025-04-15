package org.project.Page.page_abstract;

import java.util.HashMap;
import java.util.Map;

public class router {

    private static final Map<String, page> routeMap = new HashMap<>();
    private page currentPage;
    private String indexRoute = "HomePage";

    public String getIndexRoute() {
        return indexRoute;
    }

    public void setIndexRoute(String indexRoute) {
        this.indexRoute = indexRoute;
    }

    public void addRoute(String route, page page) {
        routeMap.put(route, page);
    }

    public static router createDefault(){
        return new router();
    }

    public void navigate(String route) {
        page nextPage = routeMap.get(route);
        if (nextPage != null) {
            currentPage = nextPage;
            currentPage.render();
        } else {
            System.out.println("No route found for " + route);
        }
    }

    public void navigate(){
        navigate(indexRoute);
    }

    public page getCurrentPage() {
        return currentPage;
    }
}