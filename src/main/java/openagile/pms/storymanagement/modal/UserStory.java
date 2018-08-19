package openagile.pms.storymanagement.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stories")
public class UserStory {

	@Id
	private int id;

	@Indexed(name="name", unique=true)
	private String name;

	private String description;
	private String sprintNumber;
	private String owner;
	private String childFeature;
	
	public UserStory() {
		
	}

	public UserStory(String name, String description, String sprintNumber, String owner, String childFeature) {
		super();
		this.name = name;
		this.description = description;
		this.sprintNumber = sprintNumber;
		this.owner = owner;
		this.childFeature = childFeature;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSprintNumber() {
		return sprintNumber;
	}

	public void setSprintNumber(String sprintNumber) {
		this.sprintNumber = sprintNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getChildFeature() {
		return childFeature;
	}

	public void setChildFeature(String childFeature) {
		this.childFeature = childFeature;
	}

	public void updateValues(UserStory updatedStory) {
		setSprintNumber(updatedStory.getSprintNumber());
		setChildFeature(updatedStory.getChildFeature());
		setDescription(updatedStory.getDescription());
		setOwner(updatedStory.getOwner());
	}
}
