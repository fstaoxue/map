package com.taoge.business.parsexls.bean;

/**
 * @author 1001234
 * @date 2019/05/21
 */
public enum FileType {

    XLS("xls"),
    XXLS("xxls"),
    TXT("txt");
    private String type;

    private FileType(String type){
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
