package br.com.alura.forum.controller.dto.output;

import java.util.List;

import br.com.alura.forum.model.Category;

public class DashboardOutputDto {

	private String categoryName;
	
	private List<String> subcategories;
	
	private Integer allTopics;
	
	private Integer lastWeekTopics;
	
	private Integer unansweredTopics;
	
	public DashboardOutputDto(Category category, Integer allTopics, Integer lastWeekTopics, Integer unansweredTopics) {
		this.categoryName = category.getName();
		this.subcategories = category.getSubcategoryNames();
		this.allTopics = allTopics;
		this.lastWeekTopics = lastWeekTopics;
		this.unansweredTopics = unansweredTopics;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public List<String> getSubcategories() {
		return subcategories;
	}

	public Integer getAllTopics() {
		return allTopics;
	}

	public void setAllTopics(Integer allTopics) {
		this.allTopics = allTopics;
	}

	public Integer getLastWeekTopics() {
		return lastWeekTopics;
	}

	public void setLastWeekTopics(Integer lastWeekTopics) {
		this.lastWeekTopics = lastWeekTopics;
	}

	public Integer getUnansweredTopics() {
		return unansweredTopics;
	}

	public void setUnansweredTopics(Integer unansweredTopics) {
		this.unansweredTopics = unansweredTopics;
	}

	public static DashboardOutputDto toDashboardOutput(Category category, Integer allTopics, Integer lastWeekTopics, Integer unansweredTopics) {
		return new DashboardOutputDto(category, allTopics, lastWeekTopics, unansweredTopics);
	}
	
}
