package com.prem.interview.rpc;

import java.util.Vector;

import com.prem.interview.bc.AnswerBC;
import com.prem.interview.bc.CategoryBC;
import com.prem.interview.bc.QuestionBC;
import com.prem.interview.pojo.AnswerDTO;
import com.prem.interview.pojo.CategoryDTO;
import com.prem.interview.pojo.QuestionDTO;

public class InterviewRPC {

	private CategoryBC objCategoryBC;
	private QuestionBC objQuestionBC;
	private AnswerBC objAnswerBC;

	public InterviewRPC() {
		objCategoryBC = new CategoryBC();
		objQuestionBC = new QuestionBC();
		objAnswerBC = new AnswerBC();
	}

	public boolean isValidLogin(String loginName, String loginPassword) {

		if (loginName == null) {
			return false;
		}

		if (loginPassword == null) {
			return false;
		}
		if (loginName.equalsIgnoreCase("WISH")
				&& loginPassword.equalsIgnoreCase("123")) {
			return true;
		} else {
			return false;
		}
	}

	// Category
	public boolean categoryKeyExists(CategoryDTO objCategoryDTO)
			throws Exception {
		return objCategoryBC.keyExists(objCategoryDTO);
	}

	public void saveCategory(CategoryDTO objCategoryDTO) throws Exception {
		objCategoryBC.save(objCategoryDTO);
	}

	public void updateCategory(CategoryDTO objCategoryDTO) throws Exception {
		objCategoryBC.update(objCategoryDTO);
	}

	public void retrieveCategory(CategoryDTO objCategoryDTO) throws Exception {
		objCategoryBC.retrieve(objCategoryDTO);
	}

	public Vector<CategoryDTO> fetchAllCategories() throws Exception {
		return objCategoryBC.fetchAll();
	}

	public String deleteCategory(int catId) throws Exception {
		return objCategoryBC.deleteCategory(catId);
	}

	// Question
	public boolean questionKeyExists(QuestionDTO objQuestionDTO)
			throws Exception {
		return objQuestionBC.keyExists(objQuestionDTO);
	}

	public void saveQuestion(QuestionDTO objQuestionDTO) throws Exception {
		objQuestionBC.save(objQuestionDTO);
	}

	public void updateQuestion(QuestionDTO objQuestionDTO) throws Exception {
		objQuestionBC.update(objQuestionDTO);
	}

	public void retrieveQuestion(QuestionDTO CategoryDTO) throws Exception {
		objQuestionBC.retrieve(CategoryDTO);
	}

	public Vector<QuestionDTO> fetchAllQuestionsByCategory(int linkedCategId)
			throws Exception {
		return objQuestionBC.fetchAllByCategory(linkedCategId);
	}

	public String deleteQuestion(QuestionDTO objQuestionDTO) throws Exception {
		return objQuestionBC.deleteQuestion(objQuestionDTO);
	}

	// Answer
	public boolean answerKeyExists(AnswerDTO objAnswerDTO) throws Exception {
		return objAnswerBC.keyExists(objAnswerDTO);
	}

	public void saveAnswer(AnswerDTO objAnswerDTO) throws Exception {
		objAnswerBC.save(objAnswerDTO);
	}

	public void updateAnswer(AnswerDTO objAnswerDTO) throws Exception {
		objAnswerBC.update(objAnswerDTO);
	}

	public void retrieveAnswer(AnswerDTO objAnswerDTO) throws Exception {
		objAnswerBC.retrieve(objAnswerDTO);
	}

	public Vector<AnswerDTO> fetchAllAnswersByQuestion(
			QuestionDTO objQuestionDTO) throws Exception {
		return objAnswerBC.fetchAllByQuestion(objQuestionDTO);
	}

	public String deleteAnswer(AnswerDTO objAnswerDTO) throws Exception {
		return objAnswerBC.deleteAnswer(objAnswerDTO);
	}
}
