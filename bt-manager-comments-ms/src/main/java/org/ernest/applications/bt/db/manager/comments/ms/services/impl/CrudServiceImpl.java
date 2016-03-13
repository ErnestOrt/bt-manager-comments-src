package org.ernest.applications.bt.db.manager.comments.ms.services.impl;

import java.util.UUID;

import org.ernest.applications.bt.db.manager.comments.ct.CreateCommentInput;
import org.ernest.applications.bt.db.manager.comments.ct.entities.Comment;
import org.ernest.applications.bt.db.manager.comments.ct.exceptions.CreateUserException;
import org.ernest.applications.bt.db.manager.comments.ct.exceptions.DeleteUserException;
import org.ernest.applications.bt.db.manager.comments.ct.exceptions.RetrieveUserException;
import org.ernest.applications.bt.db.manager.comments.ms.services.CrudService;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CrudServiceImpl implements CrudService{
	
	@Value("${db.name}")
	private String dbName;
	
	@Value("${db.host}")
	private String dbHost;

	@Override
	public String create(CreateCommentInput createCommentInput) throws CreateUserException {
		
		Comment comment = new Comment();
		comment.set_id(UUID.randomUUID().toString());
		comment.setCreationDate(createCommentInput.getCreationDate());
		comment.setUserIdOwner(createCommentInput.getUserIdOwner());
		comment.setContent(createCommentInput.getContent());
		try{
			CouchDbClient dbClient = new CouchDbClient(buildCouchDbProperties());
			dbClient.save(comment);
			dbClient.shutdown();
		
			return comment.get_id();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new CreateUserException(e.getMessage());
		}
	}

	@Override
	public Comment retrieve(String commentId) throws RetrieveUserException {
		
		try{
			CouchDbClient dbClient = new CouchDbClient(buildCouchDbProperties());
			Comment comment = dbClient.find(Comment.class, commentId);
			dbClient.shutdown();
			
			return comment;
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RetrieveUserException(e.getMessage());
		}
		
	}

	@Override
	public void delete(String commentId) throws DeleteUserException {
		try{
			CouchDbClient dbClient = new CouchDbClient(buildCouchDbProperties());
			Comment comment = dbClient.find(Comment.class, commentId);
			dbClient.remove(comment);
			dbClient.shutdown();
		}catch(Exception e){
			e.printStackTrace();
			throw new DeleteUserException(e.getMessage());
		}
	}
	
	private CouchDbProperties buildCouchDbProperties() {
		CouchDbProperties properties = new CouchDbProperties();
		properties.setDbName(dbName);
		properties.setHost(dbHost);
		properties.setPort(5984);
		properties.setCreateDbIfNotExist(true);
		properties.setProtocol("http");
		return properties;
	}

}
