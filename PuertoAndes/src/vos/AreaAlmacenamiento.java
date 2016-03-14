package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class AreaAlmacenamiento 
{
	@JsonProperty(value="id")
	private int id; 
	

	
	public AreaAlmacenamiento(@JsonProperty(value="id")int nId)
	{
		id = nId; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
