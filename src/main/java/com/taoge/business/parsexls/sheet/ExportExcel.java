package com.taoge.business.parsexls.sheet;

import com.taoge.business.main.bean.Excel;
import com.taoge.business.parsexls.ExportExcelHandler;
import com.taoge.business.parsexls.common.CommonCode;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

@Service
public class ExportExcel implements ExportExcelHandler {

    @Override
    public <T> void export(List<T> data, Class<T> clazz,String filename) {

        Field[] fields=clazz.getDeclaredFields();
        String[] titles=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            Field field=fields[i];
            String name=field.getName();
            if(field.isAnnotationPresent(Excel.class)){
                Excel excel=field.getAnnotation(Excel.class);
                String tempTitle=excel.title();
                if(StringUtils.isNotEmpty(tempTitle)){
                    name=tempTitle;
                }
            }
            titles[i]=name;
        }
        HSSFWorkbook book=null;
        book=new HSSFWorkbook();
        HSSFSheet sheet=book.createSheet();
        Row row=sheet.getRow(0);
        for(int i=0;i<titles.length;i++){
            Cell cell=row.createCell(i);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(titles[i]);
        }
        for(int i=0;i<data.size();i++){
            T temp=data.get(i);
            Row tempRow=sheet.getRow(i+1);
            for(int j=0;j<fields.length;j++){
                Field field=fields[j];
                Class type=field.getType();
                Cell cell=tempRow.createCell(j);
                cell.setCellType(CellType.STRING);
                try {
                    cell.setCellValue(CommonCode.processColumn(field.get(temp),type).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        File file=new File("D:\\output\\"+filename);
        try {
            book.write(file);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                book.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
