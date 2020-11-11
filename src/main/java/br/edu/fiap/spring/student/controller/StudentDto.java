package br.edu.fiap.spring.student.controller;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	private Long id;
	private Long rm;
	private String identification;
	private String name;
	private String nickname;
	private Date born;
	private Date createdDate;
}
