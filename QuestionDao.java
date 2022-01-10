package dao;

import model.Question;

public interface QuestionDao {
	public boolean addQuestion(Question question);
	public boolean deleteQuestion(int questionid);
}
