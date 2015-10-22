package org.ihsp.data.cache.common;

import java.io.Serializable;

/*
 * share all basic info:application/device
 */
public class IMPObjectMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String type;
    private Object object;

    public IMPObjectMessage() {

    }

    public IMPObjectMessage(String type, Object object) {
        this.type = type;
        this.object = object;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the object
     */
    public Object getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(Object object) {
        this.object = object;
    }
}
