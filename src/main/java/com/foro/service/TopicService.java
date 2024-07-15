package com.foro.service;

import com.foro.model.Topic;
import com.foro.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic createTopic(Topic topic) {
        if (topicRepository.findByTitleAndMessage(topic.getTitle(), topic.getMessage()).isPresent()) {
            throw new IllegalArgumentException("Duplicate topic");
        }
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Long id, Topic topic) {
        return topicRepository.findById(id).map(existingTopic -> {
            existingTopic.setTitle(topic.getTitle());
            existingTopic.setMessage(topic.getMessage());
            existingTopic.setStatus(topic.getStatus());
            existingTopic.setAuthor(topic.getAuthor());
            existingTopic.setCourse(topic.getCourse());
            return topicRepository.save(existingTopic);
        }).orElseThrow(() -> new IllegalArgumentException("Topic not found"));
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
