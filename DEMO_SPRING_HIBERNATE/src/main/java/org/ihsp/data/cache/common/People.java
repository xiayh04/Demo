package org.ihsp.data.cache.common;

import java.io.Serializable;

public class People implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name = "";
    private int id = 0;
    public People(){
        
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}