package com.lti.service;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lti.dto.ReportDto;
import com.lti.entity.Student;
import com.lti.repository.ReportRepository;
import com.lti.repository.StudentRepository;
import com.lti.repository.StudentRepositoryImpl;

@Service
public class ReportServiceImpl implements ReportService {

//	@Autowired
//	StudentRepository studentRepository;
	
	@Autowired
	ReportRepository reportRepository;
	
	public int calulateMarksService(int studentId, int subjectId) {
		int i = reportRepository.calulateMarks(studentId, subjectId);
		System.out.println("controller -> "+studentId + " "+ subjectId);
		return i;
	} 
}
	
//	getLevel
	
	
	
//	getReport(){
//		update -> selected options from response  with given SID QUESID(count) RID
//		calculate marks 
//		pass/fail -> 
//		return 
//				DTO -> CORRECT OPTION (4) 
//				+ SELECTED OPTION (1) 
//				+ QUESTION DESC 
//				+ OPTION1 
//				+ OPTION2 
//				+ OPTION3 
//				+ OPTION4  
				
				
//	}
//}


//@Override
//public List<ReportDto> getReport(int studentId) {
//	
//	Student student = studentRepository.findById(studentId);
////    List<Report> resultList =  ReportRepository.getResultsOfaStudent(student); //resultRepo
//    List<ReportDto> resultDtoList = new ArrayList<>();
//    
//    return null;
//}


//@Override
//public List<ResultDto> getResultOfaStudent(int studentId){
//    Student student = studentDao.findAUser(studentId); //studentrepo
//    List<Result> resultList =  resultDao.getResultsOfaStudent(student); //resultRepo
//    List<ResultDto> resultDtoList = new ArrayList<>();
//    for(Result res: resultList) {
//        ResultDto resDto = new ResultDto();
//        resDto.setUserResultId(res.getUserResultId());
//        resDto.setExamId(res.getExamDetail().getExamId());
//        resDto.setExamSubject(res.getExamDetail().getTestSubject().getSubjectName());
//        resDto.setResultStatus(res.getResultStatus());
//        resDto.setScore(res.getScore());
//        resDto.setLevelPassed(res.getLevelPassed());
//        resultDtoList.add(resDto);
//    }
//    return resultDtoList;
//}

//package com.lti.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.lti.dto.ReportDto;
//import com.lti.entity.Student;
//import com.lti.repository.StudentRepository;
//import com.lti.repository.StudentRepositoryImpl;
//
//@Service
//public class ReportServiceImpl implements ReportService {
//
//	@Autowired
//	StudentRepository studentRepository;
//	
//	@Override
//	public List<ReportDto> getReport(int studentId) {
//		
//		Student student = studentRepository.findById(studentId);
////	    List<Report> resultList =  ReportRepository.getResultsOfaStudent(student); //resultRepo
//	    List<ReportDto> resultDtoList = new ArrayList<>();
//	    
//	    return null;
//	}
//}
//
//
////@Override
////public List<ResultDto> getResultOfaStudent(int studentId){
////    Student student = studentDao.findAUser(studentId); //studentrepo
////    List<Result> resultList =  resultDao.getResultsOfaStudent(student); //resultRepo
////    List<ResultDto> resultDtoList = new ArrayList<>();
////    for(Result res: resultList) {
////        ResultDto resDto = new ResultDto();
////        resDto.setUserResultId(res.getUserResultId());
////        resDto.setExamId(res.getExamDetail().getExamId());
////        resDto.setExamSubject(res.getExamDetail().getTestSubject().getSubjectName());
////        resDto.setResultStatus(res.getResultStatus());
////        resDto.setScore(res.getScore());
////        resDto.setLevelPassed(res.getLevelPassed());
////        resultDtoList.add(resDto);
////    }
////    return resultDtoList;
////} 
