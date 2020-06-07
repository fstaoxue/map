package com.taoge.business.parsexls;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author taoxuefeng
 * @date 2019/05/21
 */
public interface FileParseHandler {

    <T> List<T> getListByFile(File file, Class<T> clazz);

    <T> List<T> getListByStream(InputStream stream, String fileName, Class<T> clazz);

    List<Map<String,Object>> getMapListByFile(File file);

}
