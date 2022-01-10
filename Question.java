package model;

public class Question {
	int questionid;
	String questionname;
	String op1;
	String op2;
	String op3;
	String op4;
	String ans;
	//constructor
	public Question(int questionid, String questionname, String op1, String op2, String op3, String op4, String ans) {
		super();
		this.questionid = questionid;
		this.questionname = questionname;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.ans = ans;
	}
	public Question() {
		
			}
	
	//getter and setter methods
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getQuestionname() {
		return questionname;
	}
	public void setQuestionname(String questionname ) {
		this.questionname = questionname ;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	@Override
	public String toString() {
		return "Question [questionid=" + questionid + ", questionname=" + questionname + ", op1=" + op1 + ", op2=" + op2
				+ ", op3=" + op3 + ", op4=" + op4 + ", ans=" + ans + ", getQuestionid()=" + getQuestionid()
				+ ", getQuestionname()=" + getQuestionname() + ", getOp1()=" + getOp1() + ", getOp2()=" + getOp2()
				+ ", getOp3()=" + getOp3() + ", getOp4()=" + getOp4() + ", getAns()=" + getAns() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	
}
