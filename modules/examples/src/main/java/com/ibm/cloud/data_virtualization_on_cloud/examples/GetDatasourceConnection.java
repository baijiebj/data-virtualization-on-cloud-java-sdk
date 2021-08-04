package com.ibm.cloud.data_virtualization_on_cloud.examples;

import java.util.List;

import com.ibm.cloud.data_virtualization.v1.DataVirtualization;
import com.ibm.cloud.data_virtualization.v1.model.DatasourceConnectionsList;
import com.ibm.cloud.data_virtualization.v1.model.DatasourceConnectionsListDatasourceConnectionsItem;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

public class GetDatasourceConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataVirtualization dv = DataVirtualization.newInstance();
		DatasourceConnectionsList connList = dv.listDatasourceConnections(null).execute().getResult();
		
		try {
			List<DatasourceConnectionsListDatasourceConnectionsItem> allConn = connList.getDatasourceConnections();
			
			if (allConn.isEmpty()) {
				System.out.println("No datasource connection was found in the system.");
			}
			
			for (DatasourceConnectionsListDatasourceConnectionsItem eachItem : allConn) {
				System.out.println("HostName is: " + eachItem.getHostname() + ", Port is: " + eachItem.getPort() + "OsUser is: " + eachItem.getOsUser());
			}
        	
        }catch(ServiceResponseException sre) {
            System.out.println("Get datasource connection failed with status code: " + sre.getStatusCode() + ", and error message: " + sre.getMessage());
        }
		

	}

}
