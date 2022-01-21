package br.com.hfn.investbe.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.hfn.investbe.model.FinancialAsset;
import br.com.hfn.investbe.model.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletItemPK implements Serializable{
	
	private static final long serialVersionUID = 590101226104305888L;

	@ManyToOne
	@JoinColumn(name = "cseq_wallet")
	private Wallet wallet;
	
	@ManyToOne
	@JoinColumn(name = "cseq_financial_asset")
	private FinancialAsset financialAsset;
}
