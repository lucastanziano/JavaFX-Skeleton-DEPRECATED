package data.repository.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import collections.CollectionFactory;

public class XSSFileHelper {
	
	
	private XSSFWorkbook workBook;
	private CellReader reader;
	
	private XSSFileHelper(File xssFile, CellReader reader) throws InvalidFormatException, IOException{
		if(!xssFile.exists()){
			throw new FileNotFoundException("File " + xssFile.getAbsolutePath() + "not found");
		}
		this.workBook = new XSSFWorkbook(xssFile);
		this.reader = reader;
	}
	
	public static XSSFileHelper newInstance(File xssFile, CellReader reader) throws InvalidFormatException, IOException{
		return new XSSFileHelper(xssFile, reader);
	}
	
	
	public List<String[]> readAllLines(int sheetIndex){
		XSSFSheet sheet = getWorkBook().getSheetAt(sheetIndex);
		
		List<String[]> rows = CollectionFactory.newArrayList();
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null) {
				String[] rowValues = new String[row.getPhysicalNumberOfCells()];
				for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
					rowValues[j] = (row.getCell(j) != null)? getReader().read(row.getCell(j)) : "";
				}
				rows.add(rowValues);
			}
		}
		return rows;
	}
	


	public XSSFWorkbook getWorkBook() {
		return workBook;
	}

	public void setWorkBook(XSSFWorkbook workBook) {
		this.workBook = workBook;
	}

	public CellReader getReader() {
		return reader;
	}

	public void setReader(CellReader reader) {
		this.reader = reader;
	}



}
