// package com.my.school.controller;

// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.my.school.controllers.StudentController;
// import com.my.school.entities.Student;
// import com.my.school.exceptions.StudentNotFoundException;
// import com.my.school.services.StudentService;

// import org.hamcrest.core.Is;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// @WebMvcTest(controllers = { StudentController.class })
// public class StudentControllerTest {

//     @Autowired
//     MockMvc mockMvc;

//     @MockBean
//     StudentService studentService;

//     List<Student> studentList;

//     Student student;

//     static int id = 1;

//     @BeforeAll
//     static void setStudentData() {
//         Student student = new Student();
//         student.setId(id);
//         student.setName("Bob");

//         List<Student> studentList = new ArrayList<>();
//         studentList.add(student);
//     }

//     @Test
//     void testGetAllStudents() throws Exception {
//         when(studentService.getStudents()).thenReturn(studentList);

//         mockMvc.perform(MockMvcRequestBuilders.get("/student")).andDo(MockMvcResultHandlers.print())
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 // .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Is.is(student.getId())))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Is.is(student.getName())));
//     }

//     @Test
//     void testGetAllStudentsException() throws Exception {
//         when(studentService.getStudents()).thenThrow(new StudentNotFoundException(""));

//         mockMvc.perform(MockMvcRequestBuilders.get("/student")).andDo(MockMvcResultHandlers.print())
//                 .andExpect(MockMvcResultMatchers.status().isNotFound())
//                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.errorMsg", Is.is("studentId:  - student not found")));
//     }

//     @Test
//     void testGetStudent() throws Exception {
//         when(studentService.getStudentById(id)).thenReturn(student);

//         mockMvc.perform(MockMvcRequestBuilders.get("/student/{studentId}", id)).andDo(MockMvcResultHandlers.print())
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(student.getId())))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(student.getName())));

//     }

//     @Test
//     void testGetStudentException() throws Exception {
//         when(studentService.getStudentById(id)).thenThrow(new StudentNotFoundException(String.valueOf(id)));

//         mockMvc.perform(MockMvcRequestBuilders.get("/student/{studentId}", id)).andDo(MockMvcResultHandlers.print())
//                 .andExpect(MockMvcResultMatchers.status().isNotFound())
//                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.errorMsg",
//                         Is.is("studentId: " + id + " - student not found")));
//     }

//     @Test
//     void testDeleteStudent() throws Exception {
//         when(studentService.deleteStudentById(id)).thenReturn(student);

//         mockMvc.perform(MockMvcRequestBuilders.delete("/student/{studentId}", id)).andDo(MockMvcResultHandlers.print())
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(student.getId())))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(student.getName())));

//     }

//     @Test
//     void testDeleteStudentException() throws Exception {
//         when(studentService.deleteStudentById(id)).thenThrow(new StudentNotFoundException(String.valueOf(id)));

//         mockMvc.perform(MockMvcRequestBuilders.delete("/student/{studentId}", id)).andDo(MockMvcResultHandlers.print())
//                 .andExpect(MockMvcResultMatchers.status().isNotFound())
//                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.errorMsg",
//                         Is.is("studentId: " + id + " - student not found")));
//     }

//     @Test
//     void testAddStudent() throws Exception {
//         when(studentService.addStudent(student)).thenReturn(student);

//         mockMvc.perform(MockMvcRequestBuilders.post("/student")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(new ObjectMapper().writeValueAsString(student)))
//                 .andDo(MockMvcResultHandlers.print())
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(student.getName())));
//     }

//     @Test
//     void testAddStudentBadRequest() throws Exception {
//         when(studentService.addStudent(student)).thenReturn(student);

//         mockMvc.perform(MockMvcRequestBuilders.post("/student").contentType(MediaType.APPLICATION_JSON))
//                 .andDo(MockMvcResultHandlers.print())
//                 .andExpect(MockMvcResultMatchers.status().isBadRequest())
//                 .andExpect(MockMvcResultMatchers.content().string(""));

//     }

//     @Test
//     void testUpdateStudent() throws Exception {
//         when(studentService.updateStudent(student)).thenReturn(student);

//         mockMvc.perform(MockMvcRequestBuilders.put("/student/{num}", id)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(new ObjectMapper().writeValueAsString(student)))
//                 .andDo(MockMvcResultHandlers.print())
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(student.getName())));
//     }

//     @Test
//     void testUpdateStudentException() throws Exception {
//         when(studentService.updateStudent(student)).thenThrow(new StudentNotFoundException(String.valueOf(id)));

//         mockMvc.perform(MockMvcRequestBuilders.put("/student/{num}", id)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(new ObjectMapper().writeValueAsString(student)))
//                 .andDo(MockMvcResultHandlers.print())
//                 .andExpect(MockMvcResultMatchers.status().isNotFound())
//                 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.errorMsg",
//                         Is.is("studentId: " + id + " - student not found")));
//     }
// }
