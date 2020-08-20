package com.jalasoft.compress.controller.component;

import com.jalasoft.compress.controller.exception.PropertyException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "execute.winrar")
public class WinrarProperties extends Properties {
    private String version4;
    private String version5;
    private String compressedfolder;

    private final static String WINRAR_VERSION4 = "4";
    private final static String WINRAR_VERSION5 = "5";

    public String getVersion4() {
        return version4;
    }

    public void setVersion4(String version4) {
        this.version4 = version4;
    }

    public String getVersion5() {
        return version5;
    }

    public void setVersion5(String version5) {
        this.version5 = version5;
    }

    public String getCompressedfolder() {
        return compressedfolder;
    }

    public void setCompressedfolder(String compressedfolder) {
        this.compressedfolder = compressedfolder;
    }

    public String getLanguageFolder(String version) throws PropertyException{
        switch (version){
            case WINRAR_VERSION4:
                return this.getVersion4();
            case WINRAR_VERSION5:
                return this.getVersion5();
            default:
                throw new PropertyException("Invalid WinRar version");

        }
    }
}
