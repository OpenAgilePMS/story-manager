package openagile.pms.storymanagement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import openagile.pms.storymanagement.modal.UserStory;

public interface UserStoryRepository extends MongoRepository<UserStory, Integer> {

	public UserStory findByName(String name);

	public List<UserStory> findByChildFeature(String childFeature);
}
