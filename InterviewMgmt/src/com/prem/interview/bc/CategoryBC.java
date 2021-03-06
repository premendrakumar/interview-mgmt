/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prem.interview.bc;

import java.util.Vector;

import com.prem.interview.dao.CategoryDAO;
import com.prem.interview.pojo.CategoryDTO;
import com.prem.interview.pojo.QuestionDTO;

/**
 * 
 * @author PREMENDRA
 */
public class CategoryBC extends AbstractBC {
	CategoryDAO objWishDAO;

	public CategoryBC() {
		objWishDAO = new CategoryDAO();
	}

	public boolean keyExists(CategoryDTO objWishDTO) throws Exception {
		return objWishDAO.keyExists(objWishDTO);
	}

	public void save(CategoryDTO objWishDTO) throws Exception {
		objWishDAO.save(objWishDTO);
	}

	public void update(CategoryDTO objWishDTO) throws Exception {
		objWishDAO.update(objWishDTO);
	}

	public void retrieve(CategoryDTO objWishDTO) throws Exception {
		objWishDAO.retrieve(objWishDTO);
	}

	public Vector<CategoryDTO> fetchAll() throws Exception {
		Vector<CategoryDTO> objCategoryDTOs = objWishDAO.fetchAll();
		QuestionBC objQuestionBC = new QuestionBC();
		for (CategoryDTO objCategoryDTO : objCategoryDTOs) {
			Vector<QuestionDTO> objQuestionDTOs = objQuestionBC
					.fetchAllByCategory(objCategoryDTO.getCatID());
			objCategoryDTO.setQuestions(objQuestionDTOs);
		}
		return objCategoryDTOs;
	}
	
	public String deleteCategory(int catId) throws Exception {
		String msg = "";
		QuestionBC objQuestionBC = new QuestionBC();
		Vector<QuestionDTO> objQuestionDTOs = objQuestionBC
				.fetchAllByCategory(catId);
		for(QuestionDTO objQuestionDTO:objQuestionDTOs){
			msg+="\n"+objQuestionBC.deleteQuestion(objQuestionDTO);
		}
		msg+=objWishDAO.deleteCategory(catId);
		
		return msg;
	}
}
