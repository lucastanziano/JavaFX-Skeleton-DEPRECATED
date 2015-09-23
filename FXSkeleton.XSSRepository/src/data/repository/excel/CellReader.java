package data.repository.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;

public interface CellReader {
	
	
	public String read(XSSFCell cell);
	
	public String readTypeString(XSSFCell cell);
	
	public String readTypeNumeric(XSSFCell cell);
	
	public String readTypeFormula(XSSFCell cell);

}
