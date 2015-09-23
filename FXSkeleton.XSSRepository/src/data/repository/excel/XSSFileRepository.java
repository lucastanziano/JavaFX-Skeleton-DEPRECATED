package data.repository.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import data.repository.IRepository;
import data.repository.ObjBuilder;


public class XSSFileRepository<T> implements IRepository<T> {

	private final List<T> elements;
	private final XSSFileHelper xssFileHelper;
	private final ObjBuilder<T, String[]> builder;
	private final List<Integer> sheets;
	private final File xssFile;

	private XSSFileRepository(File xssFile,
			ObjBuilder<T, String[]> builder, CellReader reader,
			List<Integer> sheets) throws IOException {
		this.xssFile = xssFile;
		try {
			this.xssFileHelper = XSSFileHelper.newInstance(xssFile, reader);
		} catch (InvalidFormatException e) {
			throw new IOException(e);
		}
		this.builder = builder;
		this.sheets = sheets;
		this.elements = new ArrayList<T>();
	}

	public static <T> XSSFileRepository<T> newRepoWithBaseCellReader(File xssFile,
			ObjBuilder<T, String[]> builder) throws  IOException {
		return newInstance(xssFile, builder, new BaseCellReader());
	}
	
	public static <T> XSSFileRepository<T> newInstance(File xssFile,
			ObjBuilder<T, String[]> builder, CellReader reader) throws  IOException {
		return new XSSFileRepository<T>(xssFile, builder, reader, builder.getSheetsToParse());
	}

	public List<T> getAllElements() throws Exception {
		
		elements.clear();
		
		for (int sheetIndex : sheets) {
			int row = 0;
			for (String[] entry : xssFileHelper.readAllLines(sheetIndex)) {
				row++;
				try{
				T newObj = builder.build(entry, row);
				if (newObj != null) {
					elements.add(newObj);
				}
				}catch(Exception e){
					System.out.println("An exception occurred reading file " + xssFile.getName() 
							+ " line: " + row + " (Value: "+ Arrays.deepToString(entry) +" )\n" + e.getMessage());
					e.printStackTrace();
					throw new Exception("An exception occurred reading file " + xssFile.getName() 
							+ " line: " + row + " (Value: "+ Arrays.deepToString(entry) +" )\n" + e.getMessage(), e);
				}
			}
		}

		return elements;
	}

}
