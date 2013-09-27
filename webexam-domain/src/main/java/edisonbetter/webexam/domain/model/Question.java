package edisonbetter.webexam.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import edisonbetter.webexam.infra.model.BaseEntity;


@Entity
public class Question extends BaseEntity {
	private String name;
	private boolean isRadio;
	private float point;
	
	@ManyToOne
	private Exam exam;
	
	@OneToMany(cascade={CascadeType.REMOVE}, fetch=FetchType.EAGER, mappedBy="question")
	private List<QuestionItem> questionItemList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRadio() {
		return isRadio;
	}

	public void setRadio(boolean isRadio) {
		this.isRadio = isRadio;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<QuestionItem> getQuestionItemList() {
		return questionItemList;
	}

	public void setQuestionItemList(List<QuestionItem> questionItemList) {
		this.questionItemList = questionItemList;
	}
	
	
}
