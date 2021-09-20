/*
package sofrecom.collaborateur.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import sofrecom.collaborateur.model.DAOUser;


public class UserItemProcessor implements ItemProcessor<DAOUser, DAOUser> {
    private static final Logger log = LoggerFactory.getLogger(UserItemProcessor.class);
    
	@Autowired
	private PasswordEncoder bcryptEncoder;

    @Override
    public DAOUser process(final DAOUser person) throws Exception {

    final String password = bcryptEncoder.encode(person.getPassword());
    	
   	 
        final DAOUser transformedPerson = new DAOUser(person.getDateIntegration(),person.getEmail(),person.getFullname(),person.getMatricule(),password,person.getUsername());

        log.info("Converting (" + person + ") into (" + transformedPerson + ") +");

        return transformedPerson;
    }

}
*/