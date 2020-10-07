package com.cotelligent;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.integration.ProvisioningPlan;
import sailpoint.object.Identity;
import sailpoint.object.ProvisioningResult;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class Application_Based_Approval4 {
	private static SailPointContext context;

	public static void main(String[] args) throws GeneralException {
		SpringStarter starter = new SpringStarter("iiqBeans");
		starter.start();
		context = SailPointFactory.createContext();
		System.out.println("HI");
		
		ProvisioningPlan plan = new ProvisioningPlan();
		plan.setIdentity( "jessy");
		System.out.println(plan);
		
		/*
		 * String approvingIdentities= "jessy"; Identity identity =
		 * context.getObjectByName(Identity.class, approvingIdentities); List items =
		 * approvalSet.getItems();
		 */

	}

}
