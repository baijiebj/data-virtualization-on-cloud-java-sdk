package com.ibm.cloud.data_virtualization_on_cloud.examples;

import com.ibm.cloud.data_virtualization.v1.DataVirtualization;
import com.ibm.cloud.data_virtualization.v1.model.AddDatasourceConnectionOptions;
import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnection;
import com.ibm.cloud.data_virtualization.v1.model.PostDatasourceConnectionParametersProperties;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

public class CreateDatasourceConnection {

	public static void main(String[] args) {
		DataVirtualization dv = DataVirtualization.newInstance();
        PostDatasourceConnectionParametersProperties connParameters = 
        		new PostDatasourceConnectionParametersProperties.Builder().database("TPCDS").host("192.168.0.1").username("db2inst1").password("password").port("50000").build();
        connParameters.accessToken();
        AddDatasourceConnectionOptions connOptions = new AddDatasourceConnectionOptions.Builder().name("testdb").datasourceType("DB2").xProperties(connParameters).build();
        
        try {
        	PostDatasourceConnection addConnectionResult = dv.addDatasourceConnection(connOptions).execute().getResult();
        	System.out.println("The name of created datasource is:" + addConnectionResult.getName());
        	System.out.println("The datasource type of created datasource is:" + addConnectionResult.getDatasourceType());
        	System.out.println("The connection ID of created datasource is:" + addConnectionResult.getConnectionId());
        	
        }catch(ServiceResponseException sre) {
            System.out.println("Create datasource connection failed with status code: " + sre.getStatusCode() + ", and error message: " + sre.getMessage());
        }

	}
}
