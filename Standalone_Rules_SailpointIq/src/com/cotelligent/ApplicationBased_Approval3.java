package com.cotelligent;

import java.util.ArrayList;
import java.util.List;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.ApprovalItem;
import sailpoint.object.ApprovalSet;
import sailpoint.object.IdentityRequest;
import sailpoint.object.TaskResult;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class ApplicationBased_Approval3 {
	private static SailPointContext context;

	public static void main(String[] args) throws GeneralException {

		SpringStarter starter = new SpringStarter("iiqBeans");
		starter.start();
		context = SailPointFactory.createContext();

		IdentityRequest ir = context.getObjectById(IdentityRequest.class, "0000000429");

		TaskResult requestDetails = context.getObjectById(TaskResult.class, "ac2a07d4cdf14aaea90691ae0c582581");
		System.out.println(requestDetails.getAttributes().getMap());

		System.out.println("requestDetails : " + requestDetails);
		System.out.println("Attributes : " + requestDetails.getAttributes());
		
		 ApprovalSet approvalSet = (ApprovalSet) requestDetails.getAttribute("approvalSet");
	        System.out.println("approvalSet : " + approvalSet);
	        
	        List<String> li = new ArrayList<String>();

	        for (ApprovalItem ai : approvalSet.getItems()) {
	            System.out.println("getAccountDisplayName : " + ai.getAccountDisplayName());
	            System.out.println("getApplicationName : " + ai.getApplicationName());
	            System.out.println("getApprover : " + ai.getApprover());
	            System.out.println("getDisplayName : " + ai.getDisplayName());
	            System.out.println("getDisplayValue : " + ai.getDisplayValue());
	            System.out.println("getAssignmentId : " + ai.getAssignmentId());
	            System.out.println("ai.getOwner() : " + ai.getOwner());
	            li.add(ai.getApprover());
//	            ai.setApprover();
	        }
	}

}
