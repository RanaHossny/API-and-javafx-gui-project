import java.util.ArrayList;
import java.util.List;

public class parent {
	private String name;
    private String apiName;
    public static List<parent> bigObjectList = new ArrayList<>();
    private List<Fields> fieldChildren = new ArrayList<>();
    private List<parent> childObject = new ArrayList<>();
    public parent(String name, String apiName) {
        this.name = name;
        this.apiName = apiName;
        bigObjectList.add(this);
    }

    public static parent getBigObject(String name,String apiname){
  //      BigObject[] objectList = bigObjectList.toArray(new BigObject[bigObjectList.size()]);
        for (int i = 0; i < bigObjectList.size(); i++) {
            if (bigObjectList.get(i).name.equals(name) && bigObjectList.get(i).getApiName().equals(apiname)){
                return bigObjectList.get(i);
            }
        }
        return null;
    }

    public void addFieldChild(Fields newfieldChild){
        fieldChildren.add(newfieldChild);
    }
    
    public void addObjectChild(parent newobjectChild){
    	childObject.add(newobjectChild);
    }

    public List<Fields> getFieldChildren(){
        return fieldChildren;
    }
    
    public List<parent> getObjectChildren(){
        return childObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }
    public static String ToStringObjects_Fields_children(int index,String api_name) {
    	String fields = "\0";
    	ArrayList<parent> P_same_api = new ArrayList<parent>();

    	P_same_api = parent.Split_ArrayObject(api_name); 
    	for(int j = 0; j < P_same_api.get(index).getObjectChildren().size(); j++) {
    		fields+=P_same_api.get(index).getObjectChildren().get(j).getName();
    		fields+="\n";
    		
    	}
    	for (int j = 0; j < P_same_api.get(index).getFieldChildren().size(); j++) { 
    		
    		fields+=P_same_api.get(index).getFieldChildren().get(j).getName();
    		fields+="\n";
    		fields+= "Mandatory "+P_same_api.get(index).getFieldChildren().get(j).isMandatory()
    				+ ", Values:" +P_same_api.get(index).getFieldChildren().get(j).getAllowedValues()+"\n";
    		
    	}
    	return fields;
    	
    }
    public static ArrayList <String> api_names() {
    	ArrayList <String>  api_names =new ArrayList<String>();
    	for (int i =0 ;i < parent.bigObjectList.size();i++) {
    		if(!api_names.contains(parent.bigObjectList.get(i).getApiName()))
    			api_names.add(parent.bigObjectList.get(i).getApiName());
    	}
    	return api_names; 
 
    }
    public static ArrayList<parent> Split_ArrayObject(String api_name){
    	ArrayList<parent> P_same_api = new ArrayList<parent>();
    	for (int i =0 ;i < parent.bigObjectList.size();i++) {
    		if (parent.bigObjectList.get(i).getApiName()==api_name) {
    			P_same_api.add(parent.bigObjectList.get(i));
    		}	
    	}
    	return P_same_api;
    	
    }

    


}

