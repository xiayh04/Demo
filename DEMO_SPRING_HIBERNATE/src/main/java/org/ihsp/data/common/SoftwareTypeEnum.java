package org.ihsp.data.common;


/**
 * @author yx09259
 * 
 */
public enum SoftwareTypeEnum {
    OS_ANDROID("OS_ANDROID", "Android系统", 0, true), OS_OPENWRT("OS_OPENWRT", "OpenWRT系统", 1, true), OS_UBUNTU("OS_UBUNTU", "Ubuntu系统", 2, true), OS_WINDOWS("OS_WINDOWS", "Windows系统", 3, true), APP_TEMPERATURE(
            "APP_TEMPERATURE", "温度应用", 4), APP_HUMIDITY("APP_HUMIDITY", "湿度应用", 5), APP_INFRARED("APP_INFRARED", "红外应用", 6), APP_GEOMAGN("APP_GEOMAGN", "地磁应用", 7), APP_ECG("APP_ECG", "心电应用", 8), APP_BP(
            "APP_BP", "血压应用", 9), APP_PRESSURE("APP_PRESSURE", "压力应用", 10), APP_HEAT_METER("APP_HEAT_METER", "热表应用", 11);

    private String nameEN;
    private String nameZH;
    private int value;
    private boolean os = false;

    private SoftwareTypeEnum(String nameEN, String nameZH, int value, boolean os) {
        this.nameEN = nameEN;
        this.nameZH = nameZH;
        this.value = value;
        this.os = os;
    }

    private SoftwareTypeEnum(String nameEN, String nameZH, int value) {
        this.nameEN = nameEN;
        this.nameZH = nameZH;
        this.value = value;
        this.os = false;
    }

    @Override
    public String toString() {
        return this.nameEN;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getNameZH() {
        return nameZH;
    }

    public void setNameZH(String nameZH) {
        this.nameZH = nameZH;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isOs() {
        return os;
    }

    public void setOs(boolean os) {
        this.os = os;
    }

}
