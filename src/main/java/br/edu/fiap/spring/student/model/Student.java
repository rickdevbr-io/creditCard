package br.edu.fiap.spring.student.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tb_student_stud")
@SequenceGenerator(name = "sq_student_stud", initialValue = 1, allocationSize = 1)
public class Student {

	@Id
	@GeneratedValue(generator = "sq_student_stud", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_student", nullable = false)
	private Long id;
	
	@Column(name = "nr_registration_record", nullable = false)
	private Long rm;
	
	@Column(name = "st_identification", nullable = false)
	private String identification;
	
	@Column(name = "st_name", nullable = false)
	private String name;
	
	@Column(name = "st_nickname", nullable = false)
	private String nickname;
	
	@Column(name = "dt_born")
	@Temporal(TemporalType.DATE)
	private Date born;
	
	@Column(name = "dt_created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

}
