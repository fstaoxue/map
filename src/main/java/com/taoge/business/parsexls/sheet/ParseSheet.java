package com.taoge.business.parsexls.sheet;

import com.taoge.business.parsexls.FileParseHandler;
import com.taoge.business.parsexls.bean.FileType;
import com.taoge.business.parsexls.common.BeanProcessor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 1001234
 * @date 2019/05/21
 */
@Service
public class ParseSheet implements FileParseHandler {

    @Override
    public <T> List<T> getListByFile(File file, Class<T> clazz) {
        if (file == null) {
            return null;
        }
        InputStream stream = null;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (stream == null) {
            return null;
        }
        return getListByStream(stream,file.getName(),clazz);
    }

    @Override
    public <T> List<T> getListByStream(InputStream stream,String fileName, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        Workbook book = null;
        String suffixName = fileName;
        try {
            if (suffixName.endsWith(FileType.XLS.getType())) {
                book = new HSSFWorkbook(stream);
            } else if (suffixName.endsWith(FileType.XXLS.getType())) {
                book = new XSSFWorkbook(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (book == null) {
            return null;
        }
        Sheet sheet = book.getSheetAt(0);
        Row head = sheet.getRow(0);
        List<String> titlesList = new ArrayList<String>();
        for (int i = 0; i < head.getPhysicalNumberOfCells(); i++) {
            Cell cell = head.getCell(i);
            String tempValue = cell.getStringCellValue();
            titlesList.add(tempValue);
        }
        BeanProcessor processor = new BeanProcessor();
        String[] titles = new String[titlesList.size()];
        titlesList.toArray(titles);
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            if(row==null){
                continue;
            }
            T temp = processor.toBean(row, titles, clazz);
            if (temp != null) {
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> getMapListByFile(File file) {
        return null;
    }



}
