package com.lti.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.ReportDto;
import com.lti.entity.Question;
import com.lti.entity.Report;
import com.lti.entity.Response;
import com.lti.entity.Student;


@Repository
public class ReportRepositoryImpl implements ReportRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public int calulateMarks(int studentId, int subjectId) {
		System.out.println(studentId + " 1 "+ subjectId);
		int reportIdNum = 1;
		
		String selectedOption = "select rs from Response rs"
						+ " where responseId = ( select reportId from Report"
						+ " where student.studentId = ( SELECT s.studentId from Student s where s.studentId =:studentId)"
						+ " AND subject.subjectId = ( SELECT sub.subjectId from Subject sub where sub.subjectId =:subjectId)"
//						+ " AND ATTEMPTNO = (select MAX(ATTEMPTNO) from Report))";
						+ " AND ATTEMPTNO [ maxindex(ATTEMPTNO) ])";
		
		System.out.println(studentId + "  22 "+ subjectId);
		 
//		String correctOption = "select CORRECT_OPTION"
//						+ " from Question"
//						+ " where subject.subjectId = (select subject.subjectId from Report r where r.reportId = :reportId)";
		
		


		System.out.println(studentId + " 3  "+ subjectId);
		
//		String report = " select rid from Report"
//						+ " where sid = ( sid from Student where sid =:studentId)"
//						+ " AND subid = ( subid from Subject where subid =:subjectId)"
//						+ " AND ATTEMPTNO = (select MAX(ATTEMPTNO) from Report)";
//						+ " AND ATTEMPTNO [ maxindex(ATTEMPTNO) ])";
		
//		select rid
//		from report
//		where sid = (select sid from student where sid = 1)
//		AND subid = (select subid from subject where subid = 1)
//		AND ATTEMPTNO = (select MAX(ATTEMPTNO) from report);
//		String s = "select * from REPORT";
//		System.out.println("Result "+ this.entityManager.createNativeQuery(s).getResultList());
	
		
		String vRid = "select rid " + 
				"from report " + 
				"where sid = (select sid from student where sid = ?) " + 
				"AND subid = (select subid from subject where subid = ?) " + 
				"AND ATTEMPTNO = (select MAX(ATTEMPTNO) from report where sid= ?)";
		
		List<String> vCorrectOptions = new ArrayList<String>();
		Query vq = (Query)this.entityManager.createNativeQuery(vRid);
		vq.setParameter(1, studentId);
		vq.setParameter(2, subjectId);
		vq.setParameter(3, studentId);
		
		System.out.println(" "+vq.getResultList().toString());
		List<BigDecimal> vRids = vq.getResultList();
		System.out.println(vRids.size());
		for(BigDecimal v :  vRids)
		{
			
			String vCorrectOption = "select CORRECT_OPTION from question where SUBJECTID = (select subid from report where RID = ?)";
			vq = (Query)this.entityManager.createNativeQuery(vCorrectOption);
			vq.setParameter(1, v);
			vCorrectOptions =  vq.getResultList();
			for(String o : vCorrectOptions)
				System.out.println(Integer.parseInt(o));
		}
		int vTotalMarks = 0;
		
		String vUserQuery = "select SELECTED_OPTION from Response where rid IN ( select rid from report "+
				"where sid = (select distinct(sid) from student where sid = ?) "+
					"AND subid = (select subid from subject where subid = ?) "+
					"AND ATTEMPTNO = (select MAX(ATTEMPTNO) from report where sid = ?)) ";
		
//		select SELECTED_OPTION
//		from Response
//		where rid = ( select rid from Report
//					where sid = (select sid from Student where sid = 2)
//					AND subid = (select subid from Subject where subid = 1)
//					AND ATTEMPTNO = (select MAX(ATTEMPTNO) from Report where sid = 2));
		
		System.out.println(studentId + " 99  "+ subjectId);
		
		vq = (Query)this.entityManager.createNativeQuery(vUserQuery);
		vq.setParameter(1, studentId);
		vq.setParameter(2, subjectId);
		vq.setParameter(3, studentId);
		List<BigDecimal> vSelectedOptions = vq.getResultList();
		System.out.println(vSelectedOptions.size() +" size "+ vRids.size() );
		for(int i = 0; i < vSelectedOptions.size(); i++)
		{
			if(Integer.parseInt(vCorrectOptions.get(i))==vSelectedOptions.get(i).intValue()) vTotalMarks += 10;
		}
		
		
		
		
		
		
		
//		
//		
//		System.out.println(studentId + " 4 "+ subjectId);
//		
//		ArrayList<Report> list3 = (ArrayList<Report>) entityManager.createQuery(report)
//						.setParameter("reportId", reportIdNum)
//						.getResultList();
//		
//		ArrayList<Response> list1 = (ArrayList<Response>) entityManager.createQuery(selectedOption)
//        				.setParameter("studentId", studentId)
//        				.setParameter("subjectId", subjectId)
//        				.getResultList();
//		
//		System.out.println(studentId + " 5 "+ subjectId);
//        
//		ArrayList<Question> list2 = (ArrayList<Question>) entityManager.createQuery(correctOption)
//    					.setParameter("studentId", studentId)
//    					.setParameter("subjectId", subjectId)
//    					.getResultList();
//		
//		System.out.println(studentId + " 6 "+ subjectId);
//		
//
//		
//		
//		System.out.println("LIST ---->" +list3);
//		
//		
//		
//    	for(int i = 0; i < list1.size(); i++) 
//    	{ 
//    		System.out.println(list1.get(i)); 
//    	}
//    	for(int i = 0; i < list2.size(); i++) 
//    	{ 
//    		System.out.println(list2.get(i)); 
//    	}
//    	
//    	int marks = 0;
//    	
//    	for(int i = 0 ; i < list1.size(); i++) {
//    		for(int j=0; j < list2.size(); j++) {
//		    	if(list1.get(i).equals(list2.get(j)) && i==j) {
//		    		marks = marks + 10;
//	    	}}
//    	}		
    return vTotalMarks;
}
	
	@Override
	public List<ReportDto> fetchReportByStudentId(int studentId) {
		String sql = "from Student stu, Report rep, Subject sub where stu.studentId =:sid";
        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
        qry.setParameter("sid", studentId);
        ReportDto report = (ReportDto)qry.getSingleResult();
        return (List<ReportDto>) report;
	}

	@Override
	public List<ReportDto> fetchReportBySubjectName(String subjectName) {
		String sql = "from Student stu, Report rep, Subject sub where sub.subjectName =:subName";
        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
        qry.setParameter("subName", subjectName);
        ReportDto report = (ReportDto)qry.getSingleResult();
        return (List<ReportDto>) report;
	}

	@Override
	public List<ReportDto> fetchReportBySubjectlevel(int subjectLevel) {
		String sql = "from Student stu, Report rep, Subject sub where sub.subjectLevel =:sLevel";
        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
        qry.setParameter("sLevel", subjectLevel);
        ReportDto report = (ReportDto)qry.getSingleResult();
        return (List<ReportDto>) report;
	}

	@Override
	public List<ReportDto> fetchReportByState(String state) {
		String sql = "from Student stu, Report rep, Subject sub where stu.state=:s";
        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
        qry.setParameter("s", state);
        ReportDto report = (ReportDto)qry.getSingleResult();
        return (List<ReportDto>) report;
	}

	@Override
	public List<ReportDto> fetchReportByCity(String city) {
		String sql = "from Student stu, Report rep, Subject sub where stu.city=:c";
        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
        qry.setParameter("c", city);
        ReportDto report = (ReportDto)qry.getSingleResult();
        return (List<ReportDto>) report;
    }

 	@Override
	public List<ReportDto> fetchReportByMarks(int marks) {
		String sql = "from Student stu, Report rep, Subject sub where rep.marks=:m";
        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
        qry.setParameter("m", marks);
        ReportDto report = (ReportDto)qry.getSingleResult();
        return (List<ReportDto>) report;
	}
 	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public List<> viewReport(int studentId, int subjectId, String attempt) {
//		return (Report) entityManager
//				.createQuery()//"select q from QUESTION q where q.subjectID = :subjectId AND q.questionNumber = :prevQuestionNumber")
//				.setParameter("subjectId", subId)
//				.setParameter("prevQuestionNumber", prevQuestionNumber + 1)
//				.getSingleResult();
//		
//		}
	
//	
//	Query("select acct.sclientacctid,acct.sacctdesc,acct.slocation,invest.sinvestigatorname, dept.sclientdeptid,dept.sdeptname,acp.sccpcode
//		       from AccountModel acct join acct.department dept join acct.investigator invest join acct.accountCPC acp
//		       where acct.nInstID= :instId
//		       order by acct.sclientacctid")
//		List<Object[]> findByInstId (@Param("instId") Integer instId);
//		
//		
//		
//
//	}


//package com.lti.repository;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//
//import com.lti.dto.ReportDto;
//import com.lti.entity.Question;
//import com.lti.entity.Report;
//import com.lti.entity.Student;
//
//public class ReportRepositoryImpl implements ReportRepository {
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ReportDto> fetchReportByStudentId(int studentId) {
//		String sql = "from Student stu, Report rep, Subject sub where stu.studentId =:sid";
//        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
//        qry.setParameter("sid", studentId);
//        ReportDto report = (ReportDto)qry.getSingleResult();
//        return (List<ReportDto>) report;
//	}
//
//	@Override
//	public List<ReportDto> fetchReportBySubjectName(String subjectName) {
//		String sql = "from Student stu, Report rep, Subject sub where sub.subjectName =:subName";
//        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
//        qry.setParameter("subName", subjectName);
//        ReportDto report = (ReportDto)qry.getSingleResult();
//        return (List<ReportDto>) report;
//	}
//
//	@Override
//	public List<ReportDto> fetchReportBySubjectlevel(int subjectLevel) {
//		String sql = "from Student stu, Report rep, Subject sub where sub.subjectLevel =:sLevel";
//        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
//        qry.setParameter("sLevel", subjectLevel);
//        ReportDto report = (ReportDto)qry.getSingleResult();
//        return (List<ReportDto>) report;
//	}
//
//	@Override
//	public List<ReportDto> fetchReportByState(String state) {
//		String sql = "from Student stu, Report rep, Subject sub where stu.state=:s";
//        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
//        qry.setParameter("s", state);
//        ReportDto report = (ReportDto)qry.getSingleResult();
//        return (List<ReportDto>) report;
//	}
//
//	@Override
//	public List<ReportDto> fetchReportByCity(String city) {
//		String sql = "from Student stu, Report rep, Subject sub where stu.city=:c";
//        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
//        qry.setParameter("c", city);
//        ReportDto report = (ReportDto)qry.getSingleResult();
//        return (List<ReportDto>) report;
//    }
//
// 	@Override
//	public List<ReportDto> fetchReportByMarks(int marks) {
//		String sql = "from Student stu, Report rep, Subject sub where rep.marks=:m";
//        TypedQuery<ReportDto> qry = entityManager.createQuery(sql, ReportDto.class);
//        qry.setParameter("m", marks);
//        ReportDto report = (ReportDto)qry.getSingleResult();
//        return (List<ReportDto>) report;
//	}
// 	
//}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
////	public List<> viewReport(int studentId, int subjectId, String attempt) {
////		return (Report) entityManager
////				.createQuery()//"select q from QUESTION q where q.subjectID = :subjectId AND q.questionNumber = :prevQuestionNumber")
////				.setParameter("subjectId", subId)
////				.setParameter("prevQuestionNumber", prevQuestionNumber + 1)
////				.getSingleResult();
////		
////		}
//	
////	
////	Query("select acct.sclientacctid,acct.sacctdesc,acct.slocation,invest.sinvestigatorname, dept.sclientdeptid,dept.sdeptname,acp.sccpcode
////		       from AccountModel acct join acct.department dept join acct.investigator invest join acct.accountCPC acp
////		       where acct.nInstID= :instId
////		       order by acct.sclientacctid")
////		List<Object[]> findByInstId (@Param("instId") Integer instId);
////		
////		
////		
////
////	}
