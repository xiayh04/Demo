package org.ihsp.data.common;


/**
 * @author yx09259
 * 
 */
public enum DeviceTypeEnum {
    MICROCARD("MICROCARD", 0), GATEWAY("GATEWAY", 1), ROUTE("ROUTE", 2);

    private String name;
    private int value;

    private DeviceTypeEnum(String name, int value) {
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
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }


}
