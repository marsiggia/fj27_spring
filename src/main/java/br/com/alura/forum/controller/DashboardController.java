package br.com.alura.forum.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.output.DashboardOutputDto;
import br.com.alura.forum.controller.repository.CategoryRepository;
import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.Category;

@RestController
public class DashboardController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@GetMapping(value="/api/dashboard", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<DashboardOutputDto> listDashboard() {
		
		List<DashboardOutputDto> dashboard = new ArrayList<>();
		List<Category> categories = categoryRepository.findAllMainCategories();
		for (Category category : categories) {
			Integer allTopics = topicRepository.countAllTopicsByCategory(category);
			Integer lastWeekTopics = topicRepository.countAllLastWeekTopicsByCategory(category, Instant.now().minus(7, ChronoUnit.DAYS));
			Integer unansweredTopics = topicRepository.countAllUnanswerTopicsByCategory(category);
			
			dashboard.add(DashboardOutputDto.toDashboardOutput(category, allTopics, lastWeekTopics, unansweredTopics));
		}
		
		return dashboard;
		
	}
	
}
