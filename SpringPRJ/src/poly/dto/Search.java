package poly.dto;

public class Search extends LoginDTO {

	private String searchType;
	private String keyword;	
	private int iNum1;
	private int iNum2;
	
	
	

	public int getiNum1() {
		return iNum1;
	}

	public void setiNum1(int iNum1) {
		this.iNum1 = iNum1;
	}

	public int getiNum2() {
		return iNum2;
	}

	public void setiNum2(int iNum2) {
		this.iNum2 = iNum2;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
