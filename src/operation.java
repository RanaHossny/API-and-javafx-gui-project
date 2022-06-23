import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class operation {
	String lastName = "";
	private String apiName;	
	
	public operation (String path) throws IOException {
		utillity.AddExcel(path);
	}
	
	public void startOperation(){
		
        // apiName check getLastRowNum()+1  getPhysicalNumberOfRows()
		 XSSFSheet sheet = utillity.getSheet(); 
        for (int i = 0; i < sheet.getLastRowNum()+1; i++) {
        	if(sheet.getRow(i) == null) {continue;}
            XSSFCell firstCell = sheet.getRow(i).getCell(0);
            XSSFCell secondCell = sheet.getRow(i).getCell(2);
           if (firstCell == null) continue;
            
            String firstCellString = firstCell.toString().toLowerCase();
            if (!firstCellString.equals("i") && !firstCellString.equals("o") && !firstCellString.equals("i/o") ){
            	apiName = firstCellString; 
                i += 2;
                continue;// to skip the HTTP Operation part and not change the api name with it
            }
            
           
            XSSFRow currentRow = sheet.getRow(i);
            if(currentRow == null) {continue;}
            XSSFCell typeCell = sheet.getRow(i).getCell(2);
            String typeCellString = sheet.getRow(i).getCell(2).toString();
            String fieldCell = sheet.getRow(i).getCell(1).toString();//Field Name
           if (typeCellString.equals("string")) {
                createField(currentRow);
            }
            else if(typeCellString.equals("Type") || typeCellString == null) {continue;}
            else{
               
                createBigObject(currentRow);
            }
          
      
    }}

    public void createField(XSSFRow currentRow){//
        // Get Field Name
        String[] fieldNameCell = currentRow.getCell(1).toString().split("/");
        //TODO if field is found without parent 
        if(fieldNameCell.length == 2) { createfieldObject(fieldNameCell); return;}
        String fieldName = fieldNameCell[fieldNameCell.length - 1]; //name of field
        // Get ParentObject Name
        String parentObjectName = fieldNameCell[fieldNameCell.length - 2];//name of parentObject
        
        if(parentObjectName.equals("")) {
        	parentObjectName = lastName;
        }
        lastName = parentObjectName;
        // Get Allowed Values and If Mandatory
        String allowedValues = currentRow.getCell(3).toString();
        String mandatoryCell = currentRow.getCell(4).toString();
        boolean mandatory = false; // get if mandatory
        if (mandatoryCell.toLowerCase().equalsIgnoreCase("y") ) {mandatory = true;}
        else if (mandatoryCell.toLowerCase().equalsIgnoreCase("n")) {mandatory = false;}
        // Get BigObject ParentObject
        parent parentObject = parent.getBigObject(parentObjectName,apiName);
        // Create field
        Fields field = new Fields(parentObject, fieldName, allowedValues, mandatory);
        //System.out.println("Created [Field]: " + field.getName());
        // Add field to ParentObject
        parentObject.addFieldChild(field);
    }

    public void createBigObject(XSSFRow currentRow){
        // name from type
    	
    	 
    	String tstCell = currentRow.getCell(1).toString();
    	//System.out.println(tstCell);
    	String bigObjectName = currentRow.getCell(2).toString();
        
        String tstCellName[] = currentRow.getCell(1).toString().split("/");
        
        parent childObject = new parent(bigObjectName, apiName);
        if(tstCellName[tstCellName.length - 2] != null && tstCellName[tstCellName.length - 2] != "") {
            String parentChildObjectName = tstCellName[tstCellName.length - 2];
            //System.out.println(parentChildObjectName);
            parent parentObject = parent.getBigObject(parentChildObjectName,apiName);
           
            parentObject.addObjectChild(childObject);
        }
        
    }
    //TODO creation field with objects
    public void createfieldObject(String[] fieldnameCell) {
    	String fieldobjectName = fieldnameCell[fieldnameCell.length - 1];
    	parent fieldparent = new parent(fieldobjectName, apiName);
    }

			
}
