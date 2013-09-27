package edisonbetter.webexam.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import edisonbetter.webexam.infra.model.BaseEntity;

@Entity
public class QuestionItem extends BaseEntity {
	private String name;
	private boolean isCorrect;
	
	@ManyToOne
	private Question question;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
