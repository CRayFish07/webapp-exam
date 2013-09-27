package edisonbetter.webexam.service;

import java.util.List;

import edisonbetter.webexam.domain.model.Exam;

public interface ExamService {
	public void create(Exam exam);
	
	public void update(Exam exam);
	
	public void delete(Exam exam);
	
	public Exam query(String uuid);
	
	public List<Exam> list();
}
