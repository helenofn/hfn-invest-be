package br.com.hfn.investbe.commom.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ticker Symbol entity - Identifies the company on the stock exchange
 * @author hefreita
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TickerSymbol implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String symbol;
}
