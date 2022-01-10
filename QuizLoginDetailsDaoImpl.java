package daoimpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.QuizLoginDetailsDao;
import model.Question;
import model.QuizUserDetails;
import repository.QuizLoginDetailsDaoRes;


public class QuizLoginDetailsDaoImpl implements QuizLoginDetailsDao{
	

	QuizLoginDetailsDaoRes quizLoginDetailsDaoRes=null;
	
	public QuizLoginDetailsDaoImpl(){
		
		try {
			quizLoginDetailsDaoRes=new QuizLoginDetailsDaoRes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean signUp(QuizUserDetails user) {
	
		String username=user.getUsername();
		String password =user.getPassword();
		boolean vuser=isValidUsername(username);
		boolean vpass=isValidPwd(password);
		try {
			if(vuser==true && vpass==true)
			{
				return quizLoginDetailsDaoRes.signUp(user);//condition true
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			System.out.println("problem in sign up"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String signIn(QuizUserDetails user) {

		try {
			return  quizLoginDetailsDaoRes.signIn(user);
	} catch (SQLException e) {
		
			System.out.println("problem in sign in"+e.getMessage());
			e.printStackTrace();
			return null;

		}
	}

	

	
	
	public static boolean isValidUsername(String name)
    {
		String regex = "^(.+)@(.+)$";
    	Pattern p=Pattern.compile(regex);
    	if(name==null){
    		return false;
    	}
    	
    	Matcher m=p.matcher(name);
    	return m.matches();
    }


	
	public static boolean isValidPwd(String pwd) {
        if(pwd.matches(".*[0-9]{1,}.*") && pwd.matches(".*[@#$]{1,}.*") && pwd.length() >=6 && pwd.length()<=20){
            return  true;
        }
        else
        {
            return false;
        
        }
        
		}
	}
	

    		
    	
    
    
	
	
	