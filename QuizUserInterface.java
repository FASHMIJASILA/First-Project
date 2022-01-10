package appmain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dao.QuizLoginDetailsDao;
import daoimpl.QuestionDaoImpl;
import daoimpl.QuizLoginDetailsDaoImpl;
//import daoimpl.QuizValidationImpl;
import daoimpl.StudentDaoImpl;
import model.Question;
import model.QuizUserDetails;

public class QuizUserInterface{
	// TODO Auto-generated method stub
	public static void main(String[] args) {
			char ch=' ';
			
			QuizLoginDetailsDao LoginDao=new QuizLoginDetailsDaoImpl();
			StudentDaoImpl studentDao=new  StudentDaoImpl();
			QuestionDaoImpl questionDao=new QuestionDaoImpl();
			System.out.println("*Welcome to Online Quiz System**");
			do {
			System.out.println("1: Sign up");
			System.out.println("2: Sign In");
			System.out.println("3: Exit");
			System.out.println("*******");

			String username,password,firstname,lastname,location, mobileno,role;
			int count=0;
			
				System.out.println("What you do wish to check from the above list");
				Scanner sn=new Scanner(System.in);
			
				int option=sn.nextInt();
				switch(option)
				{
					case 1:
						System.out.println("enter the details to signup");
						System.out.println("enter the username");
						username=sn.next();
						System.out.println("enter the password");
						password=sn.next();
						System.out.println("enter the firstname");
						firstname=sn.next();
						System.out.println("enter the lastname");
						lastname=sn.next();
						System.out.println("enter the mobileno");
						mobileno=sn.next();
						System.out.println("enter the location");
						location=sn.next();
						System.out.println("enter the role");
						role=sn.next();
						
						
						QuizUserDetails user=new QuizUserDetails();
						user.setUsername(username);
						user.setPassword(password);
						user.setFirstName(firstname);
						user.setLastName(lastname);
						user.setMobileno(mobileno);
						user.setLocation(location);
						user.setRole(role);
						boolean valid=LoginDao.signUp(user);
						if(valid==true)
							System.out.println("user sign up successfully");
						else
							System.out.println("check the username and password format");
						break;
					case 2:
						System.out.println("enter the username and password to login");
						String usern=sn.next();
						String pass=sn.next();
						QuizUserDetails details=new QuizUserDetails();
						details.setUsername(usern);
						details.setPassword(pass);
						String res=LoginDao.signIn(details);
						String[] values=res.split(",");
						boolean flag=Boolean.parseBoolean(values[0]);
						role=values[1];
						int choice;
						char op1=' ';
							if(role.equals("admin")&& flag==true){
								do {
									System.out.println("1:addquestion");
									System.out.println("2:deletequestion");
									System.out.println("enter the choice");
									choice=sn.nextInt();
									switch(choice)
									{
										case 1: 	System.out.println("enter the question");
													System.out.println("enter questionid");
													int s1=sn.nextInt();
													System.out.println("enter questionname");
													StringBuffer sb=new StringBuffer();
													String s2=sn.nextLine();
													sb.append(sn.nextLine());
													s2=sb.toString();
													System.out.println(s2);
													System.out.println("enter op1");
													String s3=sn.next();
													System.out.println(s3);
													System.out.println("enter op2");
													String s4=sn.next();
													System.out.println(s4);
													System.out.println("enter op3");
													String s5=sn.next();
													System.out.println(s5);
													System.out.println("enter op4");
													String s6=sn.next();
													System.out.println(s6);
													System.out.println("enter the ans");
													String anss=sn.next();
													System.out.println(anss);
													Question questions=new Question();
													questions.setQuestionid(s1);
													questions.setQuestionname(s2);
													questions.setOp1(s3);
													questions.setOp2(s4);
													questions.setOp3(s5);
													questions.setOp4(s6);
													questions.setAns(anss);
													System.out.println(questionDao.addQuestion(questions));
											
													break;
										case 2:	System.out.println(" which questionid you want to delete the ");
													int sd=sn.nextInt();
													boolean value=questionDao.deleteQuestion(sd);
													System.out.println((value));
													if(value==true){
														System.out.println("deleted successfully");
													}
													break;
												
									
										//case '3':System.exit(0);
										default:System.out.println("invalid");
									}
									System.out.println("do you wish to continue the add and delete of question");
									op1=sn.next().charAt(0);
								}while(op1=='y'||op1=='Y');
							}
								else if(role.equals("student")&& flag==true){
									count=0;
									Question q=null;
									System.out.println("takeupquiz");
									ArrayList<Question> arraylist=studentDao.takeupquiz();
								
								
									Iterator<Question> it=arraylist.iterator();
										while(it.hasNext()){
											
											
											q=it.next();
											System.out.println(q);
										
								
											System.out.println("enter the answer");
											String answerss=sn.next();
											System.out.println(answerss);
								
											System.out.println(q.getAns());
											if(q.getAns().equals(answerss)){
												count++;
											}
										
								
										}
								}
								else{
									System.out.println("login failed..retry");
								}
						
									break;
					
						
							
							default: System.out.println("enter the valid option");
					 
							
						}
				
				System.out.println("Do you wish to check other options");
				ch=sn.next().charAt(0);
				
					}while(ch=='y'||ch=='Y');
			
			
			
			}
			}