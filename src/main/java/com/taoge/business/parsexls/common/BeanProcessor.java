package com.taoge.business.parsexls.common;

import org.apache.poi.ss.usermodel.*;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 1001234
 * @date 2019/05/22
 */
public class BeanProcessor {

    private Map<String,String> mapColumn;

    public BeanProcessor(){
        this.mapColumn=new HashMap<String, String>();
    }

    public BeanProcessor(Map<String,String> mapColumn){
        this.mapColumn=mapColumn;
    }

    public <T> T toBean(Row row,String[] titles,Class<T> clazz){
        T newInstance=null;
        try {
            for(int i=0;i<titles.length;i++){
                String temp=titles[i].toLowerCase();
                if(mapColumn.containsKey(temp)){
                    titles[i]=mapColumn.get(temp);
                }
            }
            for(int i=0;i<row.getPhysicalNumberOfCells();i++){
                Field field=clazz.getDeclaredField(titles[i]);
                field.setAccessible(true);
                Class type=field.getType();
                Object obj=getCellValue(row.getCell(i),type);
                if(obj!=null&&!obj.equals("")){
                    if(newInstance==null){
                        newInstance=clazz.newInstance();
                    }
                    field.set(newInstance,obj);
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return newInstance;
    }

    private Object getCellValue(Cell cell,Class type) {
        try {
            if(cell!=null){
                cell.setCellType(CellType.STRING);
                if(cell.getStringCellValue()!=null&&!"".equals(cell.getStringCellValue())){
                    return CommonCode.processColumn(cell.getStringCellValue(),type);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String toStr(Object obj){

        return obj.toString();
    }


}
