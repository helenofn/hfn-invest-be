package br.com.hfn.investbe.model;

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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FINANCIAL_ASSET_EVENT_INPLIT_SPLIT")
public class FinancialAssetEventInplitSplit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_financial_asset_event_inplit", length = 18)
	private Long cseqId;
	
	@ManyToOne
	@JoinColumn(name = "cseq_financial_asset")
	private FinancialAsset financialAsset;
	
	@JoinColumn(name = "dh_ocurrence")
	private LocalDateTime dhOcurrence;
	
	@JoinColumn(name = "proportion_from")
	private Integer proportionFrom;
	
	@JoinColumn(name = "proportion_to")
	private Integer proportionTo;

}
