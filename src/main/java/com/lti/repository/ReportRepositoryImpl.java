package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lti.dto.ReportDto;
import com.lti.entity.Question;
import com.lti.entity.Report;
import com.lti.entity.Student;

public class ReportRepositoryImpl implements ReportRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
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
