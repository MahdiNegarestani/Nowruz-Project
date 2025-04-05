package org.project.Page.page_abstract;

public abstract class page {

    private String name;

    public page() {Initialize();}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    protected abstract void showContent();

    protected abstract void Initialize();

    public final void render() {
        System.out.println("___" + getName() + "___");
        showContent();
    }
}