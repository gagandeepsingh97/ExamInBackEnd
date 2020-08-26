//package com.lti.entity;
//
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//public class ReportSubStuTest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		
//
////		String questionID, SMASTER subjectID, String questionDescr,
////		String option1, String option2,String option3, String option4,
////		Boolean correctAns1, Boolean correctAns2, Boolean correctAns3,Boolean correctAns4,
////		String correctAnsCode
//		Subject s1=new Subject();
//		//s1.setSID("S1L2");
//		s1.setSLevel("L2");
//		s1.setSName("S1");
//		
//		Admin admin=new Admin();
//		admin.setEmail("admin@gmail.com");
//		admin.setName("admin");
//		admin.setPassword("system");
//		admin.setPhoneNo("9897401641");
//		
//		Student st=new Student();
//		st.setName("gagan");
//		//st.setStudentId("U1");
//		st.setEmail("gagan@gmail.com");
//		st.setPassword("abcd");
//		st.setPhoneNo("9897401641");
//		st.setDOB(null);
//		st.setCity("delhi");
//		st.setState("new delhi");
//		st.setQualification("BTECH");
//		st.setYearCompletion("2020");
//		
//		Report rep=new Report();
//		//rep.setReportId("U1S1L1R1");
//		rep.setNAttempt("1");
//		rep.setMarks("80");
//		rep.setPassingStatus(true);
//		rep.setStudent(st);
//		rep.setSubject(s1);
//
//		
//		
//		
//		Question q1=new Question();
//		//q1.setQuestionID("S1L1Q1");
////		q1.setSubjectID(1);
//		q1.setSubject(s1);
//		q1.setQuestionDescription("what is java");
//		q1.setOption1("an object");
//		q1.setOption2("an animal");
//		q1.setOption3("a place");
//		q1.setOption4("a language");
////		q1.setCorrectoption(1);
//
//		
//		Response response=new Response();
//		//response.setResponseId("RE1");
//
//		response.setStudent(st);
//		response.setQuestion(q1);
//		response.setSelectedoption(1);
//		
//		
//		Set<Question> set2 = new HashSet<Question>();        //create a question
//		set2.add(q1);
//		
//		
//		
//		Set<Report> set1 = new HashSet<Report>();        //create a question
//		set1.add(rep);
//		
//		Set<Response> set3=new HashSet<Response>();
//		set3.add(response);
//		
//		Session s=factory.openSession();
//		Transaction tx=s.beginTransaction();
//
//		s.save(s1);
//		s.save(st);
//		s.save(q1);
//		s.save(rep);
//		s.save(admin);
//		s.save(response);
//		tx.commit();
//		s.close();
//		factory.close();
//		}
//
//	
//}
//
//
