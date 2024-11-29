package example.jdbc.bean;

public class Article {
	private int id;
	private String name;
	private String category;
	private String dataCreated;
	private String creatorName;
	public Article(int id, String name, String category, String dataCreated, String creatorName) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.dataCreated = dataCreated;
		this.creatorName = creatorName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDataCreated() {
		return dataCreated;
	}
	public void setDataCreated(String dataCreated) {
		this.dataCreated = dataCreated;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	@Override
	public String toString() {
		return "article [id=" + id + ", name=" + name + ", category=" + category + ", dataCreated=" + dataCreated
				+ ", creatorName=" + creatorName + "]";
	}
}
