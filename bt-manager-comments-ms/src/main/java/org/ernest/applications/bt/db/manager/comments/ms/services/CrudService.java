package org.ernest.applications.bt.db.manager.comments.ms.services;

import org.ernest.applications.bt.db.manager.comments.ct.CreateCommentInput;
import org.ernest.applications.bt.db.manager.comments.ct.entities.Comment;
import org.ernest.applications.bt.db.manager.comments.ct.exceptions.CreateUserException;
import org.ernest.applications.bt.db.manager.comments.ct.exceptions.DeleteUserException;
import org.ernest.applications.bt.db.manager.comments.ct.exceptions.RetrieveUserException;

public interface CrudService {

	String create(CreateCommentInput createCommentInput) throws CreateUserException;
	Comment retrieve(String commentId) throws RetrieveUserException;
	void delete(String commentId) throws DeleteUserException;
	
}
