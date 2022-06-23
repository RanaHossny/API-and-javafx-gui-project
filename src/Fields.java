public class Fields {
	private parent parentObject;
    private String name;
    private String allowedValues;
    private boolean mandatory;


    public Fields(parent parentObject, String name, String allowedValues, boolean mandatory) {
        this.parentObject = parentObject;
        this.name = name;
        if(allowedValues == "") {this.allowedValues = "ALL";}
        else {this.allowedValues = allowedValues;}
        this.mandatory = mandatory;
       // setMandatory(mandatory);
    }
    public boolean getMandatory() {
    	return mandatory;
    }

    public parent getParentObject() {
        return parentObject;
    }

    public void setParentObject(parent parentObject) {
        this.parentObject = parentObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(String allowedValues) {
        this.allowedValues = allowedValues;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
   
		
}
