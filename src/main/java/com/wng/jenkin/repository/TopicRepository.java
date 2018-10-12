package com.wng.jenkin.repository;

import com.wng.jenkin.datamodel.Topic;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends BaseRepository<Topic, Long> {
}
