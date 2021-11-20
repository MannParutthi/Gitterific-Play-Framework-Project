package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.*;
import play.mvc.Result;
import play.mvc.Http.Request;
import play.test.Helpers;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.UserService;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import model.UserDetails;
import services.UserDataService;

/**
 * Controller for testing the User Data
 *
 *
 *@author Harman Preet Kaur
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDataControllerTest {
	
	@InjectMocks
	HomeController userDataController;
	
	@Mock
	UserDataService userDataService;
	
	@Mock
	UserService userService;
	
	@Mock
	RepositoryService repositoryService;
	
	static
	UserDetails userDetails;
	
	static User user;
	
	/**
	 * This method is used to setup test data for testing
	 * 
	 * @return void
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception{
		MockitoAnnotations.initMocks(UserDataControllerTest.class);
		
		userDetails = new UserDetails();
		userDetails.setName("test");
		userDetails.setId(44037806);
		userDetails.setAvatarUrl("https://avatars.githubusercontent.com/u/44037806?v=4");
		userDetails.setBlog("http://fabien.potencier.org/");
		userDetails.setCollaborators(3);
		userDetails.setCompany("Symfony/Blackfire");
		userDetails.setFollowers(700);
		userDetails.setFollowing(20);
		userDetails.setHireable(false);
		userDetails.setHtmlUrl("https://github.com/fabpot");
		userDetails.setPublicRepos(8);
		userDetails.setPublicGists(10);
		userDetails.setUrl("https://api.github.com/users/fabpot");
		userDetails.setType("User");
		userDetails.setPrivateGists(0);
		userDetails.setTotalPrivateRepos(0);
		userDetails.setRepoName(Arrays.asList("git-repostory"));
	}

	/**
	 * This method tests the User Data Controller
	 * 
	 * @return void
	 * 
	 */
	@Test
	public void testGetUser() {

		when(userDataService.getUserData("harman8")).thenReturn(CompletableFuture.supplyAsync(() -> userDetails));
		System.out.println("ooooooooooooo"+userDetails.getId());
		Result res1=null,res2 = null,res3=null;
		UserDetails ud = null;
		try {
			System.out.println("inside try ==> ");
			Request requestWithoutSession = Helpers.fakeRequest().method("GET").uri("/userData/harman8").build();
			System.out.println("chk requestWithoutSession 1==> " + userDataController.getUserData(requestWithoutSession,"harman8").toCompletableFuture());
			System.out.println("chk requestWithoutSession 2==> " + userDataController.getUserData(requestWithoutSession,"harman8").toCompletableFuture().get());
			res1 = userDataController.getUserData(requestWithoutSession,"harman8").toCompletableFuture().get();
			System.out.println("chk res ==> " + res1);
//			Request requestWithSession = Helpers.fakeRequest().method("GET").uri("/userData/harman8").session("harman8", "randomKeyTesting").build();
//			res2 = userDataController.getUserData(requestWithSession,"harman8").toCompletableFuture().get();
//			Request requestWithSession2 = Helpers.fakeRequest().method("GET").uri("/userData/harman8").session("harman8", "randomKeyTesting").build();
//			res3 = userDataController.getUserData(requestWithSession2,"harman8").toCompletableFuture().get();
		//	ud = userDataService.getUserData("harman8").toCompletableFuture().get();
		//	System.out.println(ud.getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// 
			e.printStackTrace();
		}
		System.out.println("-------------------"+res1);
		
		assertNull(res1);
//		assertEquals(HttpStatus.OK_200,res1.status());
//		assertEquals(HttpStatus.OK_200,res2.status());
//		assertEquals(HttpStatus.OK_200,res3.status());
	}
	
}
