/**
 * 
 */
package edisonbetter.webexam.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import edisonbetter.webexam.infra.model.BaseEntity;



/**
 * @author Edison Yang
 *
 */
@Entity
public class Exam extends BaseEntity{
	private String name;
	
	@OneToMany(cascade={CascadeType.REMOVE}, fetch=FetchType.EAGER, mappedBy="exam")
	private Set<Question> questionSet;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Question> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(Set<Question> questionSet) {
		this.questionSet = questionSet;
	}
	
}
