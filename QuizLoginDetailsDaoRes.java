package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;



import config.MyConnection;
import model.Question;
import model.QuizUserDetails;

public class QuizLoginDetailsDaoRes {
	
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	
	//default coonstructor
	public QuizLoginDetailsDaoRes() throws SQLException {
		
		connection=MyConnection.getConnection();
		statement=connection.createStatement();
	}
	
	public boolean signUp(QuizUserDetails user) throws SQLException {
		int r=statement.executeUpdate("insert into  quizuserdeatils values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getMobileno()+"','"+user.getLocation()+"','"+user.getRole()+"')");
		if(r==1)
		{
		return true;
		}else
			return false;
		
	}
	
	
	public String signIn(QuizUserDetails user) throws SQLException {
		String admin,student;
		String tuser=user.getUsername();
		String pass=user.getPassword();
		
		
		resultSet=statement.executeQuery("select *from quizuserdeatils where username='"+tuser+"' and password='"+pass+"'");
		String role=null;
		if(resultSet.next()){
			 role=resultSet.getString("role");
			return true+","+role;

			}
			else
				return false+","+role;
		
	
		
	}

	public boolean delete(String username) {
		boolean flag=false;
		try {
			int res=statement.executeUpdate("delete from  where username ='"+username+"' ");
			if(res==1){
				System.out.println("*******"+res);
				return true;
			
			}
			else{
				System.out.println("username is not deleted since its not found");
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		
			return false;
		}
				
		

		}
	
	public boolean update(String useranme){
		try{
			int res= statement.executeUpdate("update  set name='chanchi hanee' where mobileno='7349480450");
	
			if(res==1)
			{
				System.out.println("updated.......");
			}else
				System.out.println("failed.......");
	
		}catch(Exception ex) {
				System.out.println("eeee"+ex.getMessage());
		}   
		return false;
		}
	
		
	
	
	public  boolean addQuestion(Question question){
		int res=0;
		try {
			 res= statement.executeUpdate("insert into question values("+question.getQuestionid()+",'"+question.getQuestionname()+"','"+question.getOp1()+"','"+question.getOp2()+"','"+question.getOp3()+"','"+question.getOp4()+"','"+question.getAns()+"')");
			
			 if(res==1){
				 System.out.println("**********"+res);
				return true;
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return false;
		
	}

	public boolean deleteques(int questionid){
		boolean flag=false;
		try {
			int res=statement.executeUpdate("delete from question where questionid ="+questionid+" ");
			if(res==1){
				System.out.println("*******"+res);
				return true;
			
			}
			else{
				System.out.println("question is not deleted since its not found");
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		
			return false;
		}
				
		

		}
	
		
	
		public ArrayList<Question> takeupquiz() {
			// TODO Auto-generated method stub
			ArrayList<Question> list=new ArrayList<Question>();
			ResultSet rs=null;
			try {
				rs = statement.executeQuery("select * from question ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				
			}
			try {
				while(rs.next()){
					Question q=new Question();
					q.setQuestionid(rs.getInt("questionid"));
					q.setQuestionname(rs.getString("questionname"));
					q.setOp1(rs.getString("op1"));
					q.setOp2(rs.getString("op2"));
					q.setOp3(rs.getString("op3"));
					q.setOp4(rs.getString("op4"));
					q.setAns(rs.getString("ans"));
			
					list.add(q);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				return null;
			}
				return list;
			}
			
	



}
