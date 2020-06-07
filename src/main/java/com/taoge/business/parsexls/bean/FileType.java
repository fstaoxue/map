package com.taoge.business.parsexls.bean;

/**
 * @author taoxuefeng
 * @date 2019/05/21
 */
public enum FileType {

    XLS("xls"),
    XXLS("xlsx"),
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
