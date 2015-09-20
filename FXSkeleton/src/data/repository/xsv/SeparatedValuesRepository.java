package data.repository.xsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data.repository.IRepository;
import data.repository.ObjBuilder;


public class SeparatedValuesRepository<T> implements IRepository<T>{
	

	private List<T> elements;
	private CSVDriver csvHelper;
	private ObjBuilder<T, String[]> builder;
	
	public SeparatedValuesRepository(File csv, String separator, ObjBuilder<T,String[]> builder) throws FileNotFoundException{
		this.csvHelper = CSVDriver.newCustomSVHelper(csv, separator);
		this.builder = builder;
	}
	
	public List<T> getAllElements() throws Exception{
		elements = new ArrayList<T>();
		int row = 0;
		for(String[] entry : csvHelper.readAllLines()){
			elements.add(builder.build(entry, row++));
		}		
		return elements;
	}
	

	
	
}
