package daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.StudentDao;
import model.Question;
import repository.QuizLoginDetailsDaoRes;

public class StudentDaoImpl implements StudentDao {
	QuizLoginDetailsDaoRes quzires=null;
	public StudentDaoImpl(){
		 try {
			quzires=new QuizLoginDetailsDaoRes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Question> takeupquiz() {
		// TODO Auto-generated method stub
		System.out.println("welcome to takeupquizin impl");
		ArrayList<Question> arraylist=quzires.takeupquiz();
		System.out.println("welcome to studentDaoImpl");
		//System.out.println(arraylist);
		return arraylist;

		
		
		 
	
	}

}
