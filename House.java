

public class House {
    // Class variables
    private int id;
    private String imageLocation;
    private String street;
    private String city;
    private int bedrooms;
    private int bathrooms;
    private double price;
    private double change;
    private String contactNo;

    public static int count = 0;
    //Constructor
    public House(String street, String city, int bedrooms, int bathrooms, double price, String imageLocation,
	    String contactNo) {
	this.id = ++count;
	this.street = street;
	this.city = city;
	this.bedrooms = bedrooms;
	this.bathrooms = bathrooms;
	this.price = price;
	this.change = 0.0;
	this.imageLocation = imageLocation;
	this.contactNo = contactNo;
    }
    
    // Getter/Accessor methods
    public int getId() {
	return id;
    }

    public String getStreet() {
	return street;
    }

    public String getCity() {
	return city;
    }

    public int getBedrooms() {
	return bedrooms;
    }

    public int getBathrooms() {
	return bathrooms;
    }

    public double getPrice() {
	return price;
    }

    public double getChange() {
	return change;
    }

    public String getImageLocation() {
	return imageLocation;
    }

    public String getContactNo() {
	return contactNo;
    }
    
    public static int getCount() {
        return count;
    }
    
    // Setter/Mutator methods
    public void setPrice(double price) {
	this.price = price;
    }

    public void setChange(double change) {
	this.change = change;
    }

    public static void setCount(int count) {
        House.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    
    // toString method
    @Override
    public String toString() {
	return "House [id=" + id + ", imageLocation=" + imageLocation + ", street=" + street + ", city=" + city
		+ ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms + ", price=" + price + ", change=" + change
		+ ", contactNo=" + contactNo + "]";
    }

}
