package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import play.mvc.Result;
import play.mvc.Http.Request;
import play.test.Helpers;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import static play.mvc.Results.ok;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.UserService;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import model.UserDetails;
import services.UserDataService;

/**
 * Service for testing the User Data
 * 
 * @author Harman Preet Kaur
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDataServiceTest {
	
	@InjectMocks
	UserDataService userDataService;
	
	@Mock
	UserService userService;
	
	@Mock
	RepositoryService repositoryService;
	
//	static
//	UserDetails userDetails;
	
	//@Mock
	static User user;
	
	//@Mock
	static List<Repository> repoList;
	
	//@Mock
	static Repository repository;
	
	/**
	 * This method is used for setting up the test data for testing
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception{
		MockitoAnnotations.initMocks(UserDataServiceTest.class);
		
		user = new User();
		repository = new Repository();
		repository.setName("repoName");
		repoList = new ArrayList<Repository>();
		//List<String> listOfRepoNames = new ArrayList<String>();
		user.setName("test");
		user.setId(44037806);
		user.setAvatarUrl("https://avatars.githubusercontent.com/u/44037806?v=4");
		user.setBlog("http://fabien.potencier.org/");
		user.setCollaborators(3);
		user.setCompany("Symfony/Blackfire");
		user.setFollowers(700);
		user.setFollowing(20);
		user.setHireable(false);
		user.setHtmlUrl("https://github.com/fabpot");
		user.setPublicRepos(8);
		user.setPublicGists(10);
		user.setUrl("https://api.github.com/users/fabpot");
		user.setType("User");
		user.setPrivateGists(0);
		user.setTotalPrivateRepos(0);
		repoList.add(repository);
		
	}


	
	/**
	 * This method test the getUser service 
	 * 
	 * @return void
	 * 
	 */
	@Test
	public void testGetUserService() {

		try {
			when(userService.getUser(anyString())).thenReturn(user);
			when(repositoryService.getRepositories(anyString())).thenReturn(repoList);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UserDetails ud = null;
		try {			
			ud = userDataService.getUserData("harman8").toCompletableFuture().get();
			System.out.println("repo------"+ud.getRepoName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// 
			e.printStackTrace();
		}
		//System.out.println(a);
		assertNotNull(ud);
		assertEquals("test",ud.getName());
		assertEquals(44037806,ud.getId());
		assertEquals("https://avatars.githubusercontent.com/u/44037806?v=4",ud.getAvatarUrl());
		assertEquals("http://fabien.potencier.org/",ud.getBlog());
		assertEquals(3,ud.getCollaborators());
		assertEquals("Symfony/Blackfire",ud.getCompany());
		assertEquals(700,ud.getFollowers());
		assertEquals(20,ud.getFollowing());
		assertEquals(false,ud.isHireable());
		assertEquals("https://github.com/fabpot",ud.getHtmlUrl());
		assertEquals(8,ud.getPublicRepos());
		assertEquals(10,ud.getPublicGists());
		assertEquals("https://api.github.com/users/fabpot",ud.getUrl());
		assertEquals("User",ud.getType());
		assertEquals(0,ud.getPrivateGists());
		assertEquals(0,ud.getTotalPrivateRepos());
		assertEquals(Arrays.asList("repoName"),ud.getRepoName());
		
		
		
	}
	
    @Test
    public void testUserNotFoundException()  {
       
		try {
			when(userService.getUser(anyString())).thenThrow(new IOException());
			assertThrows(IOException.class, () -> {
				userDataService.getUserData("harman8");
	            throw new IOException();
	        });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        
    }
}
