package openagile.pms.storymanagement.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class TestCase {
	@Id
	private int id;

	@Indexed(name = "name", unique = true)
	private String name;

	private String steps;
}
