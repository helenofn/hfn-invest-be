package br.com.hfn.investbe.model.meta;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.hfn.investbe.model.Broker;

@StaticMetamodel(Broker.class)
public class Broker_ {

	public static volatile SingularAttribute<Broker, Integer> seqId;
	public static volatile SingularAttribute<Broker, Integer> internalId;
	public static volatile SingularAttribute<Broker, String> name;
	public static volatile SingularAttribute<Broker, String> ein;
	
	public static final String SEQ_ID = "seqId";
	public static final String INTERNAL_ID = "internalId";
	public static final String NAME = "name";
	public static final String EIN = "ein";
}
