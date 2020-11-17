package br.edu.fiap.spring.email.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    private Long id;
    private String to;
    private String subject;
    private String message;
    private List<Object> attachments;
    private Map<String, Object> props;

}