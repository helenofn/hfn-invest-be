package br.com.hfn.investbe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="FINANCIAL_TRANSACTION_TYPE")
public class FinancialTransactionType implements Serializable{

	private static final long serialVersionUID = -2419484924100545486L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_financial_transaction_type", length = 4)
	private Integer code;
	@Column(name = "ds_name", length = 100)
	private String name;
}
