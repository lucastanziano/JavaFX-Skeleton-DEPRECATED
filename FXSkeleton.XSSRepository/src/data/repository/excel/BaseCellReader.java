package data.repository.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class BaseCellReader implements CellReader {

	@Override
	public String read(XSSFCell cell) {
		String cellValue = "";
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			cellValue = readTypeString(cell);
			break;
		case Cell.CELL_TYPE_NUMERIC:
			cellValue = readTypeNumeric(cell);
			break;
		case Cell.CELL_TYPE_FORMULA:
			cellValue = readTypeFormula(cell);
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_BLANK:
			cellValue = "";
			break;
		case Cell.CELL_TYPE_ERROR:
			cellValue = cell.getErrorCellString();
			break;
		default:
			cellValue = cell.getRawValue();
			break;
		}
		return cellValue;
	}

	@Override
	public String readTypeString(XSSFCell cell) {
		return cell.getStringCellValue();
	}

	@Override
	public String readTypeNumeric(XSSFCell cell) {
		return cell.getNumericCellValue() + "";
	}

	@Override
	public String readTypeFormula(XSSFCell cell) {
		return cell.getRawValue();
	}

}
