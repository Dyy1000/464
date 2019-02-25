package lecture464.model;

public class ShoppingcartDB {
      private String id="";
      private int quantity=0;
      private String type="";
      private String band="";
      private String thumbnail="";
      private String venue="";
      private String time="";
      private int total=0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setvalue(String id, int quantity, String type, String band, String thumbnail, String venue,
			String time, int total) {
 
		this.id = id;
		this.quantity = quantity;
		this.type = type;
		this.band = band;
		this.thumbnail = thumbnail;
		this.venue = venue;
		this.time = time;
		this.total = total;
	}
      
      
      
}
