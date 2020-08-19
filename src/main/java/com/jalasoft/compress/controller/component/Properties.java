package com.jalasoft.compress.controller.component;

import com.jalasoft.compress.controller.exception.PropertyException;

public abstract class Properties {
    private String projectFolder;

    public String getProjectFolder() {
        return projectFolder;
    }

    public void setProjectFolder(String projectFolder) {
        this.projectFolder = projectFolder;
    }

    public abstract String getLanguageFolder(String version) throws PropertyException;

}
