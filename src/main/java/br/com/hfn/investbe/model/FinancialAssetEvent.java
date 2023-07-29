package br.com.hfn.investbe.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="FINANCIAL_ASSET_EVENT")
public class FinancialAssetEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_financial_asset_event", length = 18)
	private Long cseqId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_financial_asset")
	private FinancialAsset financialAsset;
	
	@JoinColumn(name = "ts_ocurrence")
	private LocalDateTime tsOcurrence;
	
}
