package com.jalasoft.compress.controller.component;

import com.jalasoft.compress.controller.exception.PropertyException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "execute.zevenzip")

public class ZevenzipProperties extends Properties {
    private String version18;
    private String version19;
    private String compressedfolder;

    private final static String ZEVENZIP_VERSION18 = "18";
    private final static String ZEVENZIP_VERSION19 = "19";

    public String getVersion18() {
        return version18;
    }

    public void setVersion18(String version18) {
        this.version18 = version18;
    }

    public String getVersion19() {
        return version19;
    }

    public void setVersion19(String version19) {
        this.version19 = version19;
    }

    public String getCompressedfolder() {
        return compressedfolder;
    }

    public void setCompressedfolder(String compressedfolder) {
        this.compressedfolder = compressedfolder;
    }

    public String getLanguageFolder(String version) throws PropertyException{
        switch (version){
            case ZEVENZIP_VERSION18:
                return this.getVersion18();
            case ZEVENZIP_VERSION19:
                return this.getVersion19();
            default:
                throw new PropertyException("Invalid ZevenZip version");
        }
    }
}

