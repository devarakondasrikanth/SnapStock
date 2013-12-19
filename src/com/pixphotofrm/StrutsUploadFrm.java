package com.pixphotofrm;




	

	import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;


	public class StrutsUploadFrm extends ActionForm
	{
	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	private FormFile theFile;

	  /**
	   * @return Returns the theFile.
	   */
	  public FormFile getTheFile() {
	    return theFile;
	  }
	  /**
	   * @param theFile The FormFile to set.
	   */
	  public void setTheFile(FormFile theFile) {
	    this.theFile = theFile;
	  }
	  private String category;
	  private double cost;
	  

		public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}


	}


