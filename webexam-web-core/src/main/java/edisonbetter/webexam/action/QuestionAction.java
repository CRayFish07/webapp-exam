package edisonbetter.webexam.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import edisonbetter.webexam.domain.model.Exam;
import edisonbetter.webexam.domain.model.Question;
import edisonbetter.webexam.domain.model.QuestionItem;
import edisonbetter.webexam.service.GenericService;

public class QuestionAction extends ActionSupport{
	
	private GenericService<Exam> examService;
	private GenericService<Question> questionService;
	
	public void setExamService(GenericService<Exam> examService) {
		this.examService = examService;
	}
	
	public void setQuestionService(GenericService<Question> questionService) {
		this.questionService = questionService;
	}
	public String create()  { 
		HttpServletRequest req = ServletActionContext.getRequest();
		Exam exam = getExamBean(req);

		Question question = getQuestionBean(req);
		question.setExam(exam);

		questionService.update(question);
		exam = examService.query(Exam.class, exam.getUuid());

        Set<Question> questionSet = exam.getQuestionSet();
		req.setAttribute("listQuestions", questionSet);
		req.setAttribute("exam", exam);
		req.setAttribute("msg", "Create Success");
		
        return SUCCESS; 
	 } 

	public String update() { 
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		
		Exam exam = getExamBean(req);
		
		Question question = getQuestionBean(req);
		question.setExam(exam);
        
		questionService.update(question);
		
		exam = examService.query(Exam.class, exam.getUuid());
        Set<Question> listQuestions = exam.getQuestionSet();
		req.setAttribute("listQuestions", listQuestions);
		req.setAttribute("exam", exam);
		req.setAttribute("msg", "Update Success");
		
        return SUCCESS; 
	 } 
	
	public String delete() { 
		HttpServletRequest req = ServletActionContext.getRequest();
		
		Exam exam = getExamBean(req);
		
		Question question = getQuestionBean(req);
		question.setExam(exam);
		questionService.delete(question);
		exam = examService.query(Exam.class, exam.getUuid());
		
        Set<Question> questionSet = exam.getQuestionSet();
		req.setAttribute("questionSet", questionSet);
		req.setAttribute("exam", exam);
		req.setAttribute("msg", "Delete Success");
		
        return SUCCESS; 
	 } 

	public String createItem(){ 
		HttpServletRequest req = ServletActionContext.getRequest();

		Question question = getQuestionBean(req);
		question = questionService.query(Question.class, question.getUuid());

        List<QuestionItem> questionItemList = question.getQuestionItemList();
		req.setAttribute("questionItemList", questionItemList);
		req.setAttribute("question", question);
		req.setAttribute("msg", "欢迎进入" + question.getName() + "试题项目管理系统");
        
		return "createItem"; 
	 } 


	public Exam getExamBean(HttpServletRequest req){
		Exam exam = new Exam();
		exam.setUuid(req.getParameter("examId"));
    	return exam;
	}
	
	public Question getQuestionBean(HttpServletRequest req){
		Question question = new Question();
		String hh = req.getParameter("questionId" + (String)req.getParameter("checkbox") + "");
		if(!"".equals(hh) && null != hh){
			question.setUuid(req.getParameter("questionId" + (String)req.getParameter("checkbox") + ""));
		}
		
		question.setName((String)req.getParameter("name" + (String)req.getParameter("checkbox") + ""));
		question.setRadio(Boolean.parseBoolean((String)req.getParameter("isRadio" + (String)req.getParameter("checkbox") + "")));
		question.setPoint(Float.parseFloat((String)req.getParameter("point" + (String)req.getParameter("checkbox") + "")));
		
		return question;
	}
}
