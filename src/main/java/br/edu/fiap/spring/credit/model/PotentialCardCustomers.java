package br.edu.fiap.spring.credit.model;

import java.math.BigDecimal;
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
@Table(name = "tb_potential_card_customers_pccu")
@SequenceGenerator(name = "sq_potential_card_customers_pccu", initialValue = 1, allocationSize = 1)
public class PotentialCardCustomers {

	@Id
	@GeneratedValue(generator = "sq_potential_card_customers_pccu", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_potential_card_customers", nullable = false)
	private Long id;
	
	@Column(name = "nr_registration_record")
	private Long rm;
	
	@Column(name = "st_client_name", nullable = false)
	private String clientName;
	
	@Column(name = "nr_card_number", nullable = false)
	private int cardNumber;
	
	@Column(name = "db_maximum_spend", nullable = false)
	private BigDecimal maximumSpend;
	
	@Column(name = "db_minimum_spend", nullable = false)
	private BigDecimal minimumSpend;
	
	@Column(name = "dt_created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
}
