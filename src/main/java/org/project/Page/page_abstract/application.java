package org.project.Page.page_abstract;

public class application {

    private router router;

    public application(router router) {this.router = router;}

    public application() {this.router = org.project.Page.page_abstract.router.createDefault();}

    public router getRouter() {return this.router;}

    public void run() {this.router.navigate();}

    public static application CreateDefault(){
        return new application();
    }
}