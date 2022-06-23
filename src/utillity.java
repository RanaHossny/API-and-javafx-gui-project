import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 public final class utillity {
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	
	public static void AddExcel(String path) throws IOException {
		 File file = new File(path);
		    FileInputStream fis =new FileInputStream(file);
		    workbook = new XSSFWorkbook(fis);
		   sheet = workbook.getSheetAt(0);
	}
		
	
	public static XSSFSheet getSheet() {
		return sheet;
	}
	public static  void setSheet(XSSFSheet newsheet) {
		sheet=newsheet;
	}
	public static XSSFWorkbook getworkbook() {
		return workbook;
	}
	public static void setworkbook(XSSFWorkbook addedworkbook) {
		workbook = addedworkbook;
	}

}
