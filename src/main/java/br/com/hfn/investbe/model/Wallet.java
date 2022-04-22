package br.com.hfn.investbe.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="WALLET")
public class Wallet implements Serializable{

	private static final long serialVersionUID = 658367273839864773L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_wallet", length = 9)
	private Integer seqId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_user")
	private User user;

	@Column(name = "dh_created")
	private LocalDateTime dhCreated;
	
	@Column(name = "dh_last_calculation")
	private LocalDateTime dhLastCalculation;
	
	@OneToMany(mappedBy = "wallet")
	private List<FinancialTransaction> financialTransactions;
}
