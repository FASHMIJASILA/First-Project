package daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.QuestionDao;
import model.Question;
import repository.QuizLoginDetailsDaoRes;

public class QuestionDaoImpl implements QuestionDao {

	@Override
	public boolean addQuestion(Question question) {
		// TODO Auto-generated method stub
		QuizLoginDetailsDaoRes quizres;
		try {
			quizres = new QuizLoginDetailsDaoRes();
		return quizres.addQuestion(question);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in addquestion in"+e.getMessage());
			
		}
		return false;
		
		
	}

	@Override
	public boolean deleteQuestion(int questionid) {
		// TODO Auto-generated method stub
		QuizLoginDetailsDaoRes quizress;
		try {
			quizress = new QuizLoginDetailsDaoRes();
			
			return quizress.deleteques(questionid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem deletequestion in"+e.getMessage());
			return false;
		}
		
	}

}
