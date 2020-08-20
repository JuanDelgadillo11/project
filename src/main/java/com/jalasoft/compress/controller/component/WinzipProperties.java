package com.jalasoft.compress.controller.component;

import com.jalasoft.compress.controller.exception.PropertyException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "execute.winzip")
public class WinzipProperties extends Properties {
    private String version23;
    private String version24;

    private final static String WINZIP_VERSION23 = "23";
    private final static String WINZIP_VERSION24 = "24";

    public String getVersion23() {
        return version23;
    }

    public void setVersion23(String version23) {
        this.version23 = version23;
    }

    public String getVersion24() {
        return version24;
    }

    public void setVersion24(String version24) {
        this.version24 = version24;
    }

    public String getLanguageFolder(String version) throws PropertyException{
        switch (version){
            case WINZIP_VERSION23:
                return this.getVersion23();
            case WINZIP_VERSION24:
                return this.getVersion24();
            default:
                throw new PropertyException("Invalid WinZip version");
        }
    }
}
