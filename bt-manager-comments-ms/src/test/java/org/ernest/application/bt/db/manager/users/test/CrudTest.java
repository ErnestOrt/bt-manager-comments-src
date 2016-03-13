package org.ernest.application.bt.db.manager.users.test;

import java.util.Date;

import org.ernest.applications.bt.db.manager.comments.ct.CreateCommentInput;
import org.ernest.applications.bt.db.manager.comments.ct.entities.Comment;
import org.ernest.applications.bt.db.manager.comments.ms.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest({"server.port=0"})
public class CrudTest {
	
	@Value("${local.server.port}")
	String port;
	
	@Test
	public void createRetreieveDelete(){
		
		CreateCommentInput createComment = new CreateCommentInput(); 
		createComment.setContent("Content");
		createComment.setCreationDate(new Date());
		createComment.setUserIdOwner("USER_ID_TEST");
		
		String commentIdCreated = new RestTemplate().postForObject("http://localhost:"+port+"/create", createComment, String.class);
		
		Assert.assertEquals(commentIdCreated, new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+commentIdCreated, Comment.class).get_id());
		new RestTemplate().getForObject("http://localhost:"+port+"/delete/"+commentIdCreated, String.class);
	}
}