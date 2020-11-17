package br.edu.fiap.spring.student.controller;

import br.edu.fiap.spring.helper.HelperStudentBuilder;
import br.edu.fiap.spring.helper.HelperStudentDtoBuilder;
import br.edu.fiap.spring.student.model.Student;
import br.edu.fiap.spring.student.model.StudentRepository;
import br.edu.fiap.spring.student.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TestStudentController {

    @Mock
    private StudentRepository mockStudentRepository = Mockito.mock(StudentRepository.class);

    private StudentService studentService = new StudentService(mockStudentRepository);

    private StudentController studentController = new StudentController(studentService);

    @Test
    public void mustFindStudents_Success() {
        List<Student> mockStudents = new ArrayList<>();
        mockStudents.add(HelperStudentBuilder.mockDtoToStudent());

        List<StudentDto> studentsDto = new ArrayList<>();
        studentsDto.add(HelperStudentDtoBuilder.mockEntityToStudentDto());

        when(studentService.findStudents()).thenReturn(mockStudents);

        List<StudentDto> studentsDtoReturn = studentController.findStudents();

        assertEquals(studentsDto.get(0).getId(), studentsDtoReturn.get(0).getId());
        assertEquals(studentsDto.get(0).getRm(), studentsDtoReturn.get(0).getRm());
        assertEquals(studentsDto.get(0).getIdentification(), studentsDtoReturn.get(0).getIdentification());
        assertEquals(studentsDto.get(0).getName(), studentsDtoReturn.get(0).getName());
        assertEquals(studentsDto.get(0).getNickname(), studentsDtoReturn.get(0).getNickname());
        assertNotNull(studentsDtoReturn.get(0).getBorn().getTime());
        assertNotNull(studentsDtoReturn.get(0).getCreatedDate().getTime());
    }

    @Test
    public void mustFindStudent_Success() {
        Student mockStudent = HelperStudentBuilder.mockDtoToStudent();
        StudentDto studentDto = new StudentDto();

        when(mockStudentRepository.findByRm(anyLong())).thenReturn(Optional.of(mockStudent));

        StudentDto studentDtoReturn = studentController.findStudent(1L);

        assertEquals(studentDto.getId(), studentDtoReturn.getId());
        assertEquals(studentDto.getRm(), studentDtoReturn.getRm());
        assertEquals(studentDto.getIdentification(), studentDtoReturn.getIdentification());
        assertEquals(studentDto.getName(), studentDtoReturn.getName());
        assertEquals(studentDto.getNickname(), studentDtoReturn.getNickname());
        assertEquals(studentDto.getBorn(), studentDtoReturn.getBorn());
        assertEquals(studentDto.getCreatedDate(), studentDtoReturn.getCreatedDate());
    }

    @Test
    public void mustSaveStudent_Success() {
        Student mockStudent = HelperStudentBuilder.mockDtoToStudent();
        StudentDto studentDto = HelperStudentDtoBuilder.mockEntityToStudentDto();

        when(studentService.save(any(Student.class))).thenReturn(mockStudent);

        StudentDto saveStudentReturn = studentController.saveStudent(studentDto);

        assertEquals(studentDto.getId(), saveStudentReturn.getId());
        assertEquals(studentDto.getRm(), saveStudentReturn.getRm());
        assertEquals(studentDto.getIdentification(), saveStudentReturn.getIdentification());
        assertEquals(studentDto.getName(), saveStudentReturn.getName());
        assertEquals(studentDto.getNickname(), saveStudentReturn.getNickname());
        assertNotNull(saveStudentReturn.getBorn().getTime());
        assertNotNull(saveStudentReturn.getCreatedDate().getTime());
    }

    @Test
    public void mustDeleteStudent_Success() {
        studentController.deleteStudent(1L);
        mockStudentRepository.delete(new Student());
        Mockito.verify(mockStudentRepository, Mockito.times(1)).delete(any(Student.class));
    }
}
