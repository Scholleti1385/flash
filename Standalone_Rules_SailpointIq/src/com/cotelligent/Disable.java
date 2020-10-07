package com.cotelligent;
import java.util.List;

import sailpoint.api.Provisioner;
import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.Identity;
import sailpoint.object.Link;
import sailpoint.object.ProvisioningPlan;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;
public class Disable {

	
		
		private static SailPointContext context;

		 

	    public static void main(String[] args) throws GeneralException {
	        SpringStarter starter = new SpringStarter("iiqBeans");
	        starter.start();
	        context = SailPointFactory.createContext();
		
       
        
        ProvisioningPlan plan = new ProvisioningPlan();
        String identityName = "aileen.mottern";
        Identity identity = context.getObjectByName(Identity.class, identityName);
        if (identity != null) {
            List<Link> links = identity.getLinks();
            for (Link link : links) {
                sailpoint.object.ProvisioningPlan.AccountRequest accountRequest = new sailpoint.object.ProvisioningPlan.AccountRequest();
                plan.setIdentity(identity);
                accountRequest.setApplication(link.getApplicationName());
                accountRequest.setInstance(link.getInstance());
                accountRequest.setNativeIdentity(link.getNativeIdentity());
                accountRequest.setOperation(sailpoint.object.ProvisioningPlan.AccountRequest.Operation.Disable);
                accountRequest.setTargetIntegration(link.getApplicationName());
                System.out.println("In ProvPlan: " + accountRequest.getApplicationName());
                plan.add(accountRequest);
            }
   
            Provisioner prov = new Provisioner(context);
            prov.execute(plan);
            context.saveObject(identity);
            context.commitTransaction();
        }
        System.out.println("Building plan completed");
        System.out.println(plan); 
	}

}
