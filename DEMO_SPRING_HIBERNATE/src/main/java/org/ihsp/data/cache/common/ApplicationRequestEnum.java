package org.ihsp.data.cache.common;

/**
 * @author yx09259
 * 
 */
public enum ApplicationRequestEnum {
    CAR_GEOSTATUS("geostatus", "http://115.29.232.47:8080/TraWeb/rest/gateway/geostatus"), CAR_VOICECARD_NUM("voicecardnum", "http://115.29.232.47:8080/TraWeb/rest/gateway/voicecard")

    ;

    private String name;
    private String value;

    private ApplicationRequestEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}
