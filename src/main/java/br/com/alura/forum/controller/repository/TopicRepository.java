package br.com.alura.forum.controller.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.topic.domain.Topic;

public interface TopicRepository extends Repository<Topic, Long>, JpaSpecificationExecutor<Topic> {
	
	@Query("select t from Topic t")
	List<Topic> list();
	
	List<Topic> findAll();
	
	@Query("select count(*) from Topic t where t.course.subcategory.category = :category")
	Integer countAllTopicsByCategory(@Param("category")Category category);
	
	@Query("select count(*) from Topic t where t.course.subcategory.category = :category and t.creationInstant >= :instant")
	Integer countAllLastWeekTopicsByCategory(@Param("category")Category category, @Param("instant") Instant instant);
	
	@Query("select count(*) from Topic t where t.course.subcategory.category = :category and t.status >= br.com.alura.forum.model.topic.domain.TopicStatus.NOT_ANSWERED")
	Integer countAllUnanswerTopicsByCategory(@Param("category")Category category);

}
