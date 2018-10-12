package com.wng.jenkin;


import com.wng.jenkin.datamodel.Message;
import com.wng.jenkin.datamodel.Topic;
import com.wng.jenkin.repository.BaseRepositoryImpl;
import com.wng.jenkin.repository.MessageRepository;
import com.wng.jenkin.repository.TopicRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest

@EnableJpaRepositories(basePackages = {"com.wng.jenkin.repository"},
        repositoryBaseClass = BaseRepositoryImpl.class)
public class MessageRepositoryTest {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    TopicRepository topicRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void getMessageByTopic() {
        Topic topic = testEntityManager.persistAndFlush(new Topic(null, "topic"));

        Message message = testEntityManager.persistAndFlush(new Message(null, topic, "test", "test"));

        List<Message> list = messageRepository.getMessageByTopic(topic.getId());
        Assertions.assertThat(list.size()).isEqualTo(1);
        Assertions.assertThat(list.get(0).getMessage()).isEqualTo("test");

    }
}
