/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prem.interview.bc;

import java.util.Vector;

import com.prem.interview.dao.QuestionDAO;
import com.prem.interview.pojo.AnswerDTO;
import com.prem.interview.pojo.QuestionDTO;

/**
 * 
 * @author PREMENDRA
 */
public class QuestionBC extends AbstractBC {
	QuestionDAO objQuestionDAO;

	public QuestionBC() {
		objQuestionDAO = new QuestionDAO();
	}

	public boolean keyExists(QuestionDTO objQuestionDTO) throws Exception {
		return objQuestionDAO.keyExists(objQuestionDTO);
	}

	public void save(QuestionDTO objQuestionDTO) throws Exception {
		objQuestionDAO.saveDetails(objQuestionDTO);
	}

	public void update(QuestionDTO objQuestionDTO) throws Exception {
		objQuestionDAO.updateDetails(objQuestionDTO);
	}

	public void retrieve(QuestionDTO objQuestionDTO) throws Exception {
		objQuestionDAO.retrieve(objQuestionDTO);
	}

	public Vector<QuestionDTO> fetchAllByCategory(int linkedCategId)
			throws Exception {
		Vector<QuestionDTO> objQuestionDTOs = objQuestionDAO
				.fetchAllByCategory(linkedCategId);
		AnswerBC objAnswerBC = new AnswerBC();
		for (QuestionDTO objCategoryDTO : objQuestionDTOs) {
			Vector<AnswerDTO> objAnswerDTOs = objAnswerBC
					.fetchAllByQuestion(objCategoryDTO);
			objCategoryDTO.setAnswers(objAnswerDTOs);
		}
		return objQuestionDTOs;
	}

	public String deleteQuestion(QuestionDTO objQuestionDTO) throws Exception {
		String msg = "";
		AnswerBC objAnswerBC = new AnswerBC();
		Vector<AnswerDTO> objAnswerDTOs = objAnswerBC.fetchAllByQuestion(objQuestionDTO);
		for (AnswerDTO objAnswerDTO : objAnswerDTOs) {
			msg += "\n" + objAnswerBC.deleteAnswer(objAnswerDTO);
		}
		msg+=objQuestionDAO.deleteQuestion(objQuestionDTO);
		return msg;
	}
}
