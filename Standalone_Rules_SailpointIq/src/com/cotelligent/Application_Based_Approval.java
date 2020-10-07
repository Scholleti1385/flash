package com.cotelligent;
import java.util.ArrayList;
import java.util.List;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.ApprovalSet;
import sailpoint.object.Identity;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class Application_Based_Approval {
	private static SailPointContext context;

	public static void main(String[] args) throws GeneralException{
		
		SpringStarter starter = new SpringStarter("iiqBeans");
        starter.start();
        context = SailPointFactory.createContext();
        System.out.println("HI");
        
        
        
        String identityName = "jesyy";
        Identity identity = context.getObjectByName(Identity.class, identityName);
        
        List approvals = new ArrayList();
        ApprovalSet approvalSet = new ApprovalSet();
        if (approvalSet != null) {
        	List items = approvalSet.getItems();
        	System.out.println(items);
        }
        
        
         
      
	}

}
