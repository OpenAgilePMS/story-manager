package openagile.pms.storymanagement.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import openagile.pms.storymanagement.NextSequenceService;
import openagile.pms.storymanagement.modal.UserStory;
import openagile.pms.storymanagement.repository.UserStoryRepository;

@RestController
@RequestMapping("/stories")
public class StoryController {

	@Autowired
	private NextSequenceService nextSequenceService;

	@Autowired
	private UserStoryRepository repository;

	@GetMapping
	public List<UserStory> getStories(@RequestParam(name = "childFeature", required = false) String childFeature)
			throws Exception {
		if (null != childFeature && !childFeature.isEmpty()) {
			return repository.findByChildFeature(childFeature);
		}
		return repository.findAll();
	}

	@GetMapping("/{name}")
	public UserStory getStoryByName(@PathVariable String name) throws Exception {
		return repository.findByName(name);
	}

	@PostMapping
	public UserStory addStory(@RequestBody UserStory userStory) throws Exception {
		int number = nextSequenceService.getNextSequence("customSequences");
		userStory.setId(number);
		userStory.setName("US" + number);
		return repository.save(userStory);
	}

	@PutMapping("/{name}")
	public UserStory updateStory(@PathVariable String name, @RequestBody UserStory userStory) throws Exception {
		UserStory currentUserStory = repository.findByName(name);
		currentUserStory.updateValues(userStory);
		return repository.save(currentUserStory);
	}

	@DeleteMapping("/{name}")
	public boolean deleteStory(@PathVariable String name) throws Exception {
		repository.delete(repository.findByName(name));
		return true;
	}
}
