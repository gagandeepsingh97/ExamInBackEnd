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
	public void saveSelectedOptionInReportTable(int studentId, int subjectId, int marks) {
		String q = "UPDATE REPORT SET MARKS = ? WHERE SID =?  AND SUBID = ?";
		Query q1 = (Query)this.entityManager.createNativeQuery(q);
		q1.setParameter(1, marks);
		q1.setParameter(2, studentId);
		q1.setParameter(3, subjectId);
		q1.executeUpdate();
	}
	
	@Override
	@Transactional
	public int calulateMarks(int studentId, int subjectId) {
		System.out.println(studentId + " 1 "+ subjectId);
		int reportIdNum = 1;
		
		String vRid = "select rid " + 
				"from report " + 
				"where sid = (select sid from student where sid = ?) " + 
				"AND subid = (select subid from subject where subid = ?) " + 
				"AND ATTEMPTNO = (select MAX(ATTEMPTNO) from report where sid= ?) ORDER BY rid";
		
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
			
			String vCorrectOption = "select CORRECT_OPTION from question where SUBJECTID = (select subid from report where RID = ?) ORDER BY quesid";
			vq = (Query)this.entityManager.createNativeQuery(vCorrectOption);
			vq.setParameter(1, v);
			vCorrectOptions =  vq.getResultList();
			for(String o : vCorrectOptions)
				System.out.println(Integer.parseInt(o));
		}
		int vTotalMarks = 0;
		
		String vUserQuery = "select SELECTED_OPTION from Response where rid IN ( select rid from report "+
				"where sid = (select sid from student where sid = ?) "+
					"AND subid = (select subid from subject where subid = ?) "+
					"AND ATTEMPTNO = (select MAX(ATTEMPTNO) from report where sid = ?))ORDER BY resid ";
		
		vq = (Query)this.entityManager.createNativeQuery(vUserQuery);
		vq.setParameter(1, studentId);
		vq.setParameter(2, subjectId);
		vq.setParameter(3, studentId);
		List<BigDecimal> vSelectedOptions = vq.getResultList();
		System.out.println(vSelectedOptions.size() +" size "+ vRids.size() );
		for(int i = 0; i < 10; i++)
		{
			if(Integer.parseInt(vCorrectOptions.get(i))==vSelectedOptions.get(i).intValue()) vTotalMarks += 10;
			System.out.println(vCorrectOptions.get(i) +" "+ vSelectedOptions.get(i).intValue());
		}
		
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
 	@Override
	public List<Report> getResultsOfaStudent(Student student) {
			String sql = " from Report r where r.student= :stu";
			TypedQuery<Report> qry = entityManager.createQuery(sql, Report.class);
			qry.setParameter("stu", student);
			List<Report> resultList = qry.getResultList();
			return resultList;
		}
	
 	
}
	
	
