package sikulixConfig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Class that allows to read data from Excel file.
 * 
 * @author Alan Buda
 */ 
public class ExcelReader {

	public static int totalRow;

	/**
	 * Read data from Excel file.
	 * 
	 * @param excelFilePath
	 * 			relative path to the file
	 * @param sheetName
	 * 			name of the sheet
	 * 
	 * @return
	 * 			collection of elements from the file
	 * 
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public List<Map<String, String>> getData(String excelFilePath, String sheetName) throws InvalidFormatException, IOException {
		Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		return readSheet(sheet);
	}

	/**
	 * Read data from specific Excel sheet.
	 * 
	 * @param sheet
	 * 			name of the sheet
	 * 
	 * @return
	 * 			collection of elements from the file
	 */
	private List<Map<String, String>> readSheet(Sheet sheet) {
		Row row;
		Cell cell;
		totalRow = sheet.getLastRowNum();
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		DataFormatter formatter = new DataFormatter();
		for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
			row = sheet.getRow(currentRow);
			int totalColumn = row.getLastCellNum();
			LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
				cell = row.getCell(currentColumn);
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
			//	columnMapdata.put(columnHeaderName, cell.getStringCellValue());
				columnMapdata.put(columnHeaderName, formatter.formatCellValue(cell));
			}
			excelRows.add(columnMapdata);
		}
		return excelRows;
	}

	/**
	 * Count rows in specific Excel sheet.
	 * 
	 * @return
	 * 			total number of rows
	 */
	public int countRow() {
		return totalRow;
	}

}
