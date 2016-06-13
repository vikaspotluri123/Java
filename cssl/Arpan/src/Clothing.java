
public class Clothing 
{

	private boolean isLongSleeve;
	private boolean isWool;
	private boolean isThick;
	private String itemName;
	private boolean isShirt;
	
public Clothing( boolean isLongSleeve, boolean isWool, boolean isThick, String itemname, boolean isShirt)
{
	isLongSleeve= false;
	isWool=false;
	isThick=false;
	isShirt= false;
	itemName= null; 
	
}

public Clothing()
{
	isLongSleeve= false;
	isWool=false;
	isThick=false;
	isShirt= false;
	itemName= null;
}

public  String getItemName()
{
	return itemName; 
}
public boolean isLongSleeve()
{
	return isLongSleeve;
}
public boolean isWool()
{
	return isWool;
}
public boolean isThick()
{
	return isThick;
}
public boolean isShirt()
{
	return isShirt;
}
public void setSleeve(boolean x)
{
	isLongSleeve=x;
	
	
}
public void setShirt(boolean x)
{
	isShirt=x;

}
public void setMaterial(boolean x)
{
	isWool=x; 
 
}
public void setThickness (boolean x)
{
	isThick = x;
}
public void setItemName(String x)
{
	itemName = x; 
}
}