package utilities;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRangeCopier;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	String path = System.getProperty("user.dir") + "//testData//dataOutput.xlsx";
	
	public void tableWritting(List<List<String>> tableData) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Year-O-Year Data");
			
			for(int i=0; i<tableData.size(); i++) {
				XSSFRow row = sheet.createRow(i);
				for(int j=0; j<tableData.get(i).size(); j++){
					XSSFCell cell = row.createCell(j);
					cell.setCellValue(tableData.get(i).get(j));
				}
			}
			
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
