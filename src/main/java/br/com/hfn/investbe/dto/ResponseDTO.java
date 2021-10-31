package br.com.hfn.investbe.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO implements Serializable{

	private static final long serialVersionUID = 5720309261391377714L;
	
	private Integer cdStatus;
	private String dsStatus;
	private String dsErroMessage;
	private String dsBusinessErroMessage;
	private boolean showMessage;
	
}
