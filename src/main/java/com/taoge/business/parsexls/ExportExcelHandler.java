package com.taoge.business.parsexls;

import java.util.List;

public interface ExportExcelHandler {

   <T> void export(List<T> data, Class<T> clazz, String fileName);

}
