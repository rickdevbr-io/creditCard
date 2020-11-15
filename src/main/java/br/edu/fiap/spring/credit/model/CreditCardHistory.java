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
@Table(name = "tb_credit_card_history_cchi")
@SequenceGenerator(name = "sq_credit_card_history_cchi", initialValue = 1, allocationSize = 1)
public class CreditCardHistory {

	@Id
	@GeneratedValue(generator = "sq_credit_card_history_cchi", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_credit_card_history", nullable = false)
	private Long id;
	
	@Column(name = "nr_card_number", nullable = false)
	private int cardNumber;
	
	@Column(name = "db_amount_paid", nullable = false)
	private BigDecimal amountPaid;
	
	@Column(name = "dt_created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
}
