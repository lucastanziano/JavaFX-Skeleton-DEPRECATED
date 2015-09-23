package data.repository.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;

public class StringCellReader extends BaseCellReader {


	
	@Override
	public String readTypeNumeric(XSSFCell cell) {		
		return cell.getRawValue();
	}




	
}
