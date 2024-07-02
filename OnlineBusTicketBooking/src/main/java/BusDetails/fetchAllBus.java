package BusDetails;

public class fetchAllBus {
	
	private int id;;
	private String start;
	private String end;
	private String dtime;
	private String ddate;
	private String atime;
	private String adate;
	private double price;
	private double rating;
	private int seatCap;
	private String stype;
	private String atype;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getAtime() {
		return atime;
	}
	public void setAtime(String atime) {
		this.atime = atime;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getSeatCap() {
		return seatCap;
	}
	public void setSeatCap(int seatCap) {
		this.seatCap = seatCap;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	@Override
	public String toString() {
		return "fetchAllBus [id=" + id + ", start=" + start + ", end=" + end + ", dtime=" + dtime + ", ddate=" + ddate
				+ ", atime=" + atime + ", adate=" + adate + ", price=" + price + ", rating=" + rating + ", seatCap="
				+ seatCap + ", stype=" + stype + ", atype=" + atype + "]";
	}
	

}
