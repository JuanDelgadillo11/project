package com.jalasoft.compress.controller.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component // reconocer esta clase como componente para usar el autowrite y solo tener una instancia
// de application.properties
@ConfigurationProperties(prefix = "execute")//Saca la información de resources>application.properties que tengan execute
public class Properties {
    private String projectFolder;
    private String winrarPath;
    private String winzipPath;
    private String zevenzipPath;

    public String getProjectFolder() {
        return projectFolder;
    }

    public void setProjectFolder(String projectFolder) {
        this.projectFolder = projectFolder;
    }

    public String getWinrarPath() {
        return winrarPath;
    }

    public void setWinrarPath(String winrarPath) {
        this.winrarPath = winrarPath;
    }

    public String getWinzipPath() {
        return winzipPath;
    }

    public void setWinzipPath(String winzipPath) {
        this.winzipPath = winzipPath;
    }

    public String getZevenzipPath() {
        return zevenzipPath;
    }

    public void setZevenzipPath(String zevenzipPath) {
        this.zevenzipPath = zevenzipPath;
    }
}
