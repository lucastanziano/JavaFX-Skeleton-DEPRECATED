package data.repository.xsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class CSVDriver {
	
	public final static String COMMA = ","; 
	private File csv;
	
	private String separator;
	
	
	private CSVDriver(File csv, String separator) throws FileNotFoundException{
		if(!csv.exists()){
			throw new FileNotFoundException("File " + csv.getAbsolutePath() + "not found");
		}
		this.csv = csv;
		this.separator = separator;
	}
	
	public static CSVDriver newCommaSVHelper(File csv) throws FileNotFoundException{
		return new CSVDriver(csv, COMMA);
	}
	
	public static CSVDriver newCustomSVHelper(File csv, String separator) throws FileNotFoundException{
		return new CSVDriver(csv, separator);
	}
	
	public List<String[]> readAllLines() throws IOException{
		List<String[]> allParsedLines = new LinkedList<String[]>();
		List<String> lines = Files.readAllLines(csv.toPath());
		for(String line : lines){
			allParsedLines.add(line.split(separator));
		}
		return allParsedLines;
	}
	


}
