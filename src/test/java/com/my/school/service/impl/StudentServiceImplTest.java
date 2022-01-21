// package com.my.school.service.impl;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import com.my.school.entities.Student;
// import com.my.school.exceptions.StudentNotFoundException;
// import com.my.school.repos.StudentRepo;
// import com.my.school.services.StudentService;
// import com.my.school.services.impl.StudentServiceImpl;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// @ExtendWith(MockitoExtension.class)
// public class StudentServiceImplTest {

//     @Mock
//     StudentRepo studentRepo;

//     @InjectMocks
//     StudentService studentService = new StudentServiceImpl();

//     Student student;
//     List<Student> studentList;

//     @BeforeEach
//     void init() {
//         student = new Student();
//         student.setId(1);
//         student.setName("Bob");
//         student.setSection('A');
//         student.setStandard(12);
        
//         studentList = new ArrayList<>();
//         studentList.add(student); 
//     }

//     @Test
//     void testAddStudent() {
//         when(studentRepo.save(any(Student.class))).thenReturn(student);
        
//         Student addedStudent = studentService.addStudent(student);
        
//         verify(studentRepo, times(1)).save(any(Student.class));
//         assertEquals(student.getName(), addedStudent.getName());
//         assertEquals(student.getSection(), addedStudent.getSection());
//         assertEquals(student.getSection(), addedStudent.getSection());
//     }

//     @Test
//     void testDeleteStudentById() {
//         int id = 1;
//         when(studentRepo.deleteStudentById(id)).thenReturn(studentList);

//         Student delStudent = studentService.deleteStudentById(id);

//         verify(studentRepo, times(1)).deleteStudentById(id);
//         assertTrue(studentList.size() == 1);
//         assertEquals(studentList.get(0).getName(), delStudent.getName());
//         assertEquals(studentList.get(0).getSection(), delStudent.getSection());
//         assertEquals(studentList.get(0).getSection(), delStudent.getSection());
//     }
    
//     @Test
//     void testDeleteStudentById_thenNotFound() {
//         int id = 1;
//         when(studentRepo.deleteStudentById(id)).thenReturn(new ArrayList<Student>());
        
//         assertThrows(StudentNotFoundException.class, () -> studentService.deleteStudentById(id));
//         verify(studentRepo, times(1)).deleteStudentById(id);
//     }

//     @Test
//     void testGetStudentById() {
//         int id = 1;
//         Optional<Student> stud = Optional.of(student);
//         when(studentRepo.findById(id)).thenReturn(stud);
        
//         Student foundStudent = studentService.getStudentById(id);
        
//         verify(studentRepo, times(1)).findById(id);
//         assertEquals(student.getName(), foundStudent.getName());
//         assertEquals(student.getSection(), foundStudent.getSection());
//         assertEquals(student.getSection(), foundStudent.getSection());
//     }

//     @Test
//     void testGetStudentById_thenNotFound() {
//         int id = 1;
//         Optional<Student> stud = Optional.ofNullable(null);
//         when(studentRepo.findById(id)).thenReturn(stud);
        
//         assertThrows(StudentNotFoundException.class, () -> studentService.getStudentById(id));
//         verify(studentRepo, times(1)).findById(id);
//     }

//     @Test
//     void testGetStudents() {
//         when(studentRepo.findAll()).thenReturn(studentList);

//         List<Student> studList = studentService.getStudents();

//         verify(studentRepo, times(1)).findAll();
//         assertTrue(studList.size() == 1);
//         assertEquals(studentList.get(0).getName(), studList.get(0).getName());
//         assertEquals(studentList.get(0).getSection(), studList.get(0).getSection());
//         assertEquals(studentList.get(0).getSection(), studList.get(0).getSection());
//     }
    
//     void testGetStudents_thenNotFound() {
//         when(studentRepo.findAll()).thenReturn(new ArrayList<Student>());
        
//         assertThrows(StudentNotFoundException.class, () -> studentService.getStudents());
//         verify(studentRepo, times(1)).findAll();
//     }

//     @Test
//     void testUpdateStudent() {
//         int id = 1;
//         when(studentRepo.save(student)).thenReturn(student);
//         when(studentRepo.existsById(id)).thenReturn(true);

//         Student updatedStudent = studentService.updateStudent(student);

//         verify(studentRepo, times(1)).save(student);
//         verify(studentRepo, times(1)).existsById(id);
//         assertEquals(student.getName(), updatedStudent.getName());
//         assertEquals(student.getSection(), updatedStudent.getSection());
//         assertEquals(student.getSection(), updatedStudent.getSection());
//     }
    
//     @Test
//     void testUpdateStudent_thenNotFound() {
//         int id = 1;
//         when(studentRepo.existsById(id)).thenReturn(false);
        
//         assertThrows(StudentNotFoundException.class, () -> studentService.updateStudent(student));
//         verify(studentRepo, times(1)).existsById(id);
//     }
// }
