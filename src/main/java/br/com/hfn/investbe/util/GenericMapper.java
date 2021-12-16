package br.com.hfn.investbe.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.com.hfn.investbe.exception.HfnInvestException;

public class GenericMapper {

	private GenericMapper() {
		throw new HfnInvestException("It is a utility class", false);
	}
	
	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass){
		return source
				.stream()
				.map(element -> new ModelMapper().map(element, targetClass))
				.collect(Collectors.toList());
	}
}
