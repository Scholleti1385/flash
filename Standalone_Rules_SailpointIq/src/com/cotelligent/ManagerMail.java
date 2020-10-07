
    
package com.cotelligent;


import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.spring.SpringStarter;
import java.util.List;
import sailpoint.object.EmailOptions;
import sailpoint.object.EmailTemplate;
import sailpoint.tools.GeneralException;
import sailpoint.object.*;


public class ManagerMail {


    private static SailPointContext context;


    public static void main(String[] args) throws GeneralException {
        SpringStarter starter = new SpringStarter("iiqBeans");
        starter.start();
        context = SailPointFactory.createContext();


        String identityName = "aileen.mottern";
        Identity identity = context.getObjectByName(Identity.class, identityName);
        EmailOptions options = new EmailOptions();
        String email = identity.getManager().getEmail();
        System.out.println(email);
        options.setTo(email);
        EmailTemplate template = null;
        try {
            template = context.getObject(EmailTemplate.class, "LCM User Notification");
        } catch (GeneralException e) {
            e.printStackTrace();
        }
        String listofApplications = " -> Sailpoint IdentityIQ.\n";
        List<Link> accounts = identity.getLinks();


        if (accounts != null) {
            for (Link link : accounts) {
                System.out.println(link.getApplicationName());
                String apps = link.getApplicationName();
                listofApplications += " -> "+ apps + ".\n";
            }
        }
        template.setBody("Mr/Mrs. " + identity.getManager().getName() + ",\n\n\t your team member '" + identityName
                + "' has disabled successfully." + "\n\nThese below list of applications access has been disabled.\n"+"\n"+listofApplications);
        context.sendEmailNotification(template, options);
    }
}
 








