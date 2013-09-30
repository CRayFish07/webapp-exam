package edisonbetter.webexam.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.Assert;

import com.opensymphony.xwork2.ActionSupport;

import edisonbetter.webexam.domain.model.Exam;
import edisonbetter.webexam.domain.model.Question;
import edisonbetter.webexam.domain.model.QuestionItem;
import edisonbetter.webexam.service.GenericService;

public class ExamAction extends ActionSupport{
	private GenericService<Exam> examService;
	private GenericService<QuestionItem> questionItemService;
	
	private final String CREATE_QUESTION = "createQuestion";
	private final String EXAM = "exam";
	private final String EXAM_RESULT = "examResult";
	
	public void setExamService(GenericService<Exam> examService) {
		this.examService = examService;
	}

	public void setQuestionItemService(
			GenericService<QuestionItem> questionItemService) {
		this.questionItemService = questionItemService;
	}
	
	/**
	 * Create new Exam 
	 * 
	 * @return
	 */
	public String create(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		
		Exam exam = getExamBean(req, res);
		examService.create(exam);
		
		List<Exam> examList = examService.list(Exam.class);
		Map<String, Object> attributesMap = new HashMap<String, Object>();
		attributesMap.put("examList", examList);
		attributesMap.put("msg", "Creation Success");
		setAttributesToReq(req, attributesMap);
		
		return SUCCESS;
	}
	
	/**
	 * Update the exam
	 * 
	 * @return
	 */
	public String update(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		
		Exam exam = getExamBean(req, res);
		examService.update(exam);
		
		List<Exam> examList = examService.list(Exam.class);
		Map<String, Object> attributesMap = new HashMap<String, Object>();
		attributesMap.put("examList", examList);
		attributesMap.put("msg", "Update Success");
		setAttributesToReq(req, attributesMap);
		
		return SUCCESS;
	}
	
	/**
	 * Delete the exam
	 * 
	 * @return
	 */
	public String delete(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		
		Exam exam = getExamBean(req, res);
		examService.delete(exam);
		
		List<Exam> examList = examService.list(Exam.class);
		Map<String, Object> attributesMap = new HashMap<String, Object>();
		attributesMap.put("examList", examList);
		attributesMap.put("msg", "Delete Success");
		setAttributesToReq(req, attributesMap);
		
		return SUCCESS;
	}
	
	public String createQuestion(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		
		Exam exam = getExamBean(req, res);
		exam = examService.query(Exam.class, exam.getUuid());
		
		Set<Question> questionSet = exam.getQuestionSet();
		Map<String, Object> attributesMap = new HashMap<String, Object>();
		attributesMap.put("questionSet", questionSet);
		attributesMap.put("exam", exam);
		attributesMap.put("msg", "Welcome to " + exam.getName() + " Exam System");
		setAttributesToReq(req, attributesMap);
		
		return CREATE_QUESTION;
	}
	
	/**
	 * Take an exam
	 *
	 * @return
	 */
	public String exam(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		
		Exam exam = getExamBean(req, res);
		exam = examService.query(Exam.class, exam.getUuid());
		
		Map<String, Object> attributesMap = new HashMap<String, Object>();
		attributesMap.put("exam", exam);
		attributesMap.put("msg", "Now" + exam.getName() + " Exam will be Started");
		setAttributesToReq(req, attributesMap);
		
		return EXAM;
	}
	
	public String submitExam(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		
		Exam exam = getExamBean(req, res);
		
		float result = 0f;
		
		Set<Question> questionSet = exam.getQuestionSet();
		
		for(Question question: questionSet){
			List<QuestionItem> questionItemList = question.getQuestionItemList();
			String questionId = (String)req.getParameter(question.getUuid() + "");
			Assert.notNull(questionId);
			
			for(QuestionItem questionItem: questionItemList){
				if(questionId.equals(questionItem.getUuid())){
					if(questionItem.isCorrect()){
						result = result + question.getPoint();
						break;
					}
				}
			}
		}
		
		Map<String, Object> attributesMap = new HashMap<String, Object>();
		attributesMap.put("exam", exam);
		attributesMap.put("result", result);
		attributesMap.put("msg", "The " + exam.getName() + " Exam result");
		setAttributesToReq(req, attributesMap);
		
		return EXAM_RESULT;
	}
	
	public String index(){
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse res = ServletActionContext.getResponse();
		
		List<Exam> examList = examService.list(Exam.class);
		Map<String, Object> attributesMap = new HashMap<String, Object>();
		attributesMap.put("examList", examList);
		attributesMap.put("msg", "Welcome to Exam Management System");
		setAttributesToReq(req, attributesMap);
		
		return SUCCESS;
	}
	
	private Exam getExamBean(HttpServletRequest req, HttpServletResponse res){
		
		Exam exam = new Exam();
		/*try{
			String hh = req.getParameter("examId" + (String)req.getParameter("checkbox") + "");
			if(!"".equals(hh) && null != hh){
				exam.setUuid(req.getParameter("examId" + (String)req.getParameter("checkbox") + ""));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}*/
		exam.setName(((String)req.getParameter("name")));
		return exam;
	}
	
	/**
	 * Set attributes for HttpServletRequest
	 * 
	 * @param req
	 * @param attributesMap
	 */
	private void setAttributesToReq(HttpServletRequest req, Map<String, Object> attributesMap){
		for (Map.Entry<String, Object> entry: attributesMap.entrySet()){
			String key = entry.getKey();
			Object value = entry.getValue();
			req.setAttribute(key, value);
		}
	}
	
	
}
