package com.ibm.cloud.data_virtualization_on_cloud.examples;

import com.ibm.cloud.data_virtualization.v1.DataVirtualization;
import com.ibm.cloud.data_virtualization.v1.model.DeleteDatasourceConnectionOptions;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

public class DeleteDatasourceConnection {

	public static void main(String[] args) {
		String connectionID = "75e4d01b-7417-4abc-b267-8ffb393fb970";
		String cid = "DB210013";
		DataVirtualization dv = DataVirtualization.newInstance();
		DeleteDatasourceConnectionOptions deleteOptions = new DeleteDatasourceConnectionOptions.Builder().connectionId(connectionID).cid(cid).build();
		
		try {
			dv.deleteDatasourceConnection(deleteOptions).execute().getResult();

        	System.out.println("Delete datasource connection successfully.");
        	
        }catch(ServiceResponseException sre) {
            System.out.println("Delete datasource connection failed with status code: " + sre.getStatusCode() + ", and error message: " + sre.getMessage());
        }
	}

}
