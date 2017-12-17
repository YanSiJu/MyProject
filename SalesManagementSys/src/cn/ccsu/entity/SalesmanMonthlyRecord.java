package cn.ccsu.entity;

public class SalesmanMonthlyRecord {

	private Integer id; // 销售员编号
	private Double monthlySaleroom; // 月销售总额
	private String name;	//销售员姓名

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public SalesmanMonthlyRecord() {

	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	

	public SalesmanMonthlyRecord(Integer id, Double monthlySaleroom, String name) {
		super();
		this.id = id;
		this.monthlySaleroom = monthlySaleroom;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SalesmanMonthlyRecord [id=" + id + ", monthlySaleroom=" + monthlySaleroom + ", name=" + name + "]";
	}

	/**
	 * @return the monthlySaleroom
	 */
	public Double getMonthlySaleroom() {
		return monthlySaleroom;
	}

	/**
	 * @param monthlySaleroom
	 *            the monthlySaleroom to set
	 */
	public void setMonthlySaleroom(Double monthlySaleroom) {
		this.monthlySaleroom = monthlySaleroom;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
