package com.cotelligent;

import java.util.List;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.integration.ProvisioningPlan;
import sailpoint.object.ApprovalItem;
import sailpoint.object.ApprovalSet;
import sailpoint.object.Identity;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class ApplicationBased_Approval2 {
	private static SailPointContext context;

	public static void main(String[] args) throws GeneralException {

		SpringStarter starter = new SpringStarter("iiqBeans");
		starter.start();
		context = SailPointFactory.createContext();
		System.out.println("Sailpoint Connection Success");
		
		//String launcher = "";
		String identityName = "krishna prasad";
		
		//Identity requester = context.getObjectByName(Identity.class, launcher);
		Identity identity = context.getObjectByName(Identity.class, identityName);
		//IdentityRequest ir = context.getObjectById(IdentityRequest.class, "0000000429");
		
		Identity manager = identity.getOwner();
		System.out.println(manager);
		ProvisioningPlan plan = new ProvisioningPlan();
		 
		
		List<ApprovalItem> items = ApprovalItem.getId();
		
        
        
		
		  
		 
        
        
	}

}
