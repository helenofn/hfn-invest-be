package br.com.hfn.investbe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.hfn.investbe.model.pk.WalletItemPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="WALLET_ITEM")
public class WalletItem implements Serializable{

	private static final long serialVersionUID = 1223360324713447249L;
	
	@EmbeddedId
	private WalletItemPK id = new WalletItemPK();
	
	@Column(name = "QTD_FINANCIAL_ASSET", length = 9)
	private Integer qtd;
}
