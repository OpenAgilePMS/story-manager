package openagile.pms.storymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	private String kafkaTopic;

	public String getKafkaTopic() {
		return kafkaTopic;
	}

	public void setKafkaTopic(String kafkaTopic) {
		this.kafkaTopic = kafkaTopic;
	}

	public void sendMessage(Object message) {
		kafkaTemplate.send(kafkaTopic, message);
	}
}
