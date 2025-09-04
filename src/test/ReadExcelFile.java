package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadExcelFile {
	public static List<List<String>> readExcelFromSecondRow(String filePath) {
        List<List<String>> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // lấy sheet đầu tiên
            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next(); // bỏ qua dòng đầu tiên (header)
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                List<String> rowData = new ArrayList<>();

                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                rowData.add(cell.getDateCellValue().toString());
                            } else {
                            	double numericValue = cell.getNumericCellValue();
                                // Nếu là số nguyên thì bỏ .0
                                if (numericValue == Math.floor(numericValue)) {
                                    rowData.add(String.valueOf((long) numericValue));
                                } else {
                                    rowData.add(String.valueOf(numericValue));
                                }
                            }
                            break;
                        case BOOLEAN:
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        case BLANK:
                            rowData.add("");
                            break;
                        default:
                            rowData.add(cell.toString());
                            break;
                    }
                }
                data.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
	
	public static void writeRowsAsJson(List<List<String>> data, List<String> headers, String outputDir) {
	    ObjectMapper mapper = new ObjectMapper();
	    File folder = new File(outputDir);
	    if (!folder.exists()) folder.mkdirs();

	    for (int i = 0; i < data.size(); i++) {
	        List<String> row = data.get(i);
	        Map<String, Object> jsonMap = new LinkedHashMap<>();
	        Map<String, String> errorDetail = new LinkedHashMap<>();
	        
	        UUID uuid = UUID.randomUUID();
	        jsonMap.put("UserId", uuid);
	        
	        String jsonNameExport = row.get(0);
	        String status = row.get(1); // cột đầu tiên là status
	        jsonMap.put("status", status);

	        for (int j = 1; j < headers.size(); j++) { // bắt đầu từ cột 2 (bỏ qua status)
	            String key = headers.get(j);
	            String value = j < row.size() ? row.get(j) : "";

	            if (status.equals("1000")) {
	                // chỉ add field nếu có dữ liệu
	                if (value != null && !value.isEmpty()) {
	                    jsonMap.put(key, value);
	                }
	            } else if (status.equals("1001")) {
	                // từ cột 5 trở đi -> nhét vào Error Detail
	                if (j >= 4 && value != null && !value.isEmpty()) {
	                	errorDetail.put(key, value);
	                }else {
	                	jsonMap.put(key, value);
	                }
	            }
	        }

	        // nếu là status 1001 thì add Error Detail vào object chính
	        if (status.equals("1001") && !errorDetail.isEmpty()) {
	            jsonMap.put("Error Detail", errorDetail);
	        }

	        try {
	            mapper.writerWithDefaultPrettyPrinter()
	                  .writeValue(new File(outputDir + "/" + jsonNameExport + ".json"), jsonMap);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

    public static void main(String[] args) {
    	String filePath = "D:/FileExampleIOJava/result/InputData.xlsx"; // đường dẫn input file excel
        List<List<String>> allRows = readExcelFromSecondRow(filePath);

        // Dòng đầu tiên trong Excel là header
        List<String> headers = Arrays.asList("Status", "StatusCode", "Success Message", "Error Messag1", "Error Messag2");
        String path = "D:/FileExampleIOJava/result/json_output"; // folder output cái file json xuất ra

        writeRowsAsJson(allRows, headers, path);

        System.out.println("Xuất JSON thành công");
    }
}
