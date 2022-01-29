package br.com.hfn.investbe.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="FINANCIAL_TRANSACTION")
public class FinancialTransaction implements Serializable{
	
	private static final long serialVersionUID = 3913037614522720180L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_financial_transaction", length = 18)
	private Long seqId;
	
	@JoinColumn(name = "dh_ocurrence")
	private LocalDateTime dhOcurrence;
	
	@ManyToOne
	@JoinColumn(name = "cseq_wallet")
	private Wallet wallet;
	
	@ManyToOne
	@JoinColumn(name = "cseq_financial_asset")
	private FinancialAsset financialAsset;
	
	@ManyToOne
	@JoinColumn(name = "cseq_financial_transaction_type")
	private FinancialTransactionType type;
	
	@Column(name = "qtd_asset")
	private Integer qtd;
	
	@Column(name = "unitary_value")
	private Double unitaryValue;
	
	@Column(name = "fee_value")
	private Double feeValue;
	
}
