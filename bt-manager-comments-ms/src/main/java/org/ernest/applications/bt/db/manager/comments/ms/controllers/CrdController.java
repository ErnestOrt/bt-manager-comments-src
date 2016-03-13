package org.ernest.applications.bt.db.manager.comments.ms.controllers;

import org.ernest.applications.bt.db.manager.comments.ct.CreateCommentInput;
import org.ernest.applications.bt.db.manager.comments.ct.entities.Comment;
import org.ernest.applications.bt.db.manager.comments.ct.exceptions.CreateUserException;
import org.ernest.applications.bt.db.manager.comments.ct.exceptions.DeleteUserException;
import org.ernest.applications.bt.db.manager.comments.ct.exceptions.RetrieveUserException;
import org.ernest.applications.bt.db.manager.comments.ms.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrdController {

	@Autowired
	CrudService crudService;
	
	@RequestMapping("/create")
	public String create(@RequestBody CreateCommentInput createCommentInput) throws CreateUserException {
		return crudService.create(createCommentInput);
	}
	
	@RequestMapping(path = "/retrieve/{commentId}", method = RequestMethod.GET)
	public Comment retrieve(@PathVariable("commentId") String commentId) throws RetrieveUserException {
		return crudService.retrieve(commentId);
	}
	
	@RequestMapping(path = "/delete/{commentId}", method = RequestMethod.GET)
	public void delete(@PathVariable("commentId") String commentId) throws DeleteUserException {
		crudService.delete(commentId);
	}
}