package com.dynamicdoers.hwapp.repository;

import com.dynamicdoers.hwapp.model.CourseTeacherMap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseTeacherMapRepository {
    @Autowired
    EntityManager entityManager;
    public List<CourseTeacherMap> getCourseTeacherMappings() {
        Query query = entityManager.createNativeQuery("select * from course_teacher_map;");

        @SuppressWarnings("unchecked")
        List<Object[]> rawResultList = query.getResultList();
        List<CourseTeacherMap> result = new ArrayList<>();

        rawResultList.forEach((row) -> {
            CourseTeacherMap currMap = new CourseTeacherMap();
            currMap.courseName = (String) row[0];
            currMap.teacherName = (String) row[1];
            result.add(currMap);
        });

        return result;
    }
}
