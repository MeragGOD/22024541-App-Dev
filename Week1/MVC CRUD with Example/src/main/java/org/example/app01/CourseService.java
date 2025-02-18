package org.example.app01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> getAllCourses();
    void saveCourse(Course course);
    Course getCourseById(int id);

    void deleteCourseById(int id);

    Page<Course> findPaginated(int pageNum, int pageSize,
                               String sortField,
                               String sortDirection);
}
