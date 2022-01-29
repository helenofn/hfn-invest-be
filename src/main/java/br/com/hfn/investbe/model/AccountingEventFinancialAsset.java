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
@Table(name="ACCOUNT_EVENT_FINANCIAL_ASSET")
public class AccountingEventFinancialAsset implements Serializable{

	private static final long serialVersionUID = 3900217465580178166L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_account_event_finacial_asset", length = 18)
	private Long seqId;
	
	//Tipo (Desdobramento, Agrupamento, Bonificação,...)
	
	//...
}
