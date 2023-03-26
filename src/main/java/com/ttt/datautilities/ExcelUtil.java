package com.ttt.datautilities;

import com.ttt.runconstants.PathConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtil {

    private FileInputStream fis;
    public ExcelUtil(){
         fis = null;
    }

    public List<Map<Object,Object>> getExcelData(){
        XSSFWorkbook wb = null;
        try {
            fis = new FileInputStream(new File(PathConstants.EXCEL_TEST_DATA_FILE_PATH));
            wb = new XSSFWorkbook(fis);

        XSSFSheet sh =  wb.getSheetAt(0);
        int lastRowNum = sh.getLastRowNum();
        int lastColumn = sh.getRow(0).getLastCellNum();
        List<Map<Object,Object>> result = new ArrayList<>();
           for(int i=0;i<lastRowNum;i++) {
               HashMap<Object,Object> rowData = new HashMap<>();
               for(int j=0; j<lastColumn;j++) {
                    rowData.put(sh.getRow(0).getCell(j).getStringCellValue().trim(),
                        sh.getRow(i+1).getCell(j));
               }
               result.add(rowData);
          }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public Map<Object,Object> getRowData(String header,String value){
           List<Map<Object,Object>> lstMap =  getExcelData();
          if(lstMap != null) {
              for (Map<Object, Object> map : lstMap) {
                  if (map.get(header).toString()
                          .equalsIgnoreCase(value))
                      return map;
              }

          }
          throw new RuntimeException("Value not found in TestData sheet for: "+value);
    }

}
