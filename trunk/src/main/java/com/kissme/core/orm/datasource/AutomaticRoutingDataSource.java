package com.kissme.core.orm.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @author loudyn
 *
 */
public class AutomaticRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceRouter.getSpecifiedRoute();
	}
}
