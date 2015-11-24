package action;

import com.opensymphony.xwork2.Action;

public class UpdateTextAction implements Action{
	private String states;

	public String getStatus() {
		return states;
	}

	public void setStatus(String status) {
		this.states = status;
	}
	
	public String execute() throws Exception{
		
	}
}
