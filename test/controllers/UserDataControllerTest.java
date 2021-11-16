//package controllers;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.ArgumentMatchers.*;
//import play.mvc.Result;
//import play.mvc.Http.Request;
//import play.test.Helpers;
//
//import static org.mockito.Mockito.when;
//
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.CompletionStage;
//import java.util.concurrent.ExecutionException;
//
//import static play.mvc.Results.ok;
//
//import org.eclipse.jetty.http.HttpStatus;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.stubbing.OngoingStubbing;
//
//import model.UserDetails;
//import services.UserDataService;
//
///**
// * Controller for testing the User Data
// *
// */
//@RunWith(MockitoJUnitRunner.class)
//public class UserDataControllerTest {
//	
//	@InjectMocks
//	UserDataController userDataController;
//	
//	@Mock
//	UserDataService userDataService;
//	
////	@Mock
//	static
//	UserDetails userDetails;
//	
//	@BeforeClass
//	public static void setUp() throws Exception{
//		MockitoAnnotations.initMocks(UserDataControllerTest.class);
//		
//		userDetails = new UserDetails();
//		userDetails.setName("test");
//		userDetails.setId(44037806);
//		userDetails.setAvatarUrl("https://avatars.githubusercontent.com/u/44037806?v=4");
//		userDetails.setBlog("http://fabien.potencier.org/");
//		userDetails.setCollaborators(3);
//		userDetails.setCompany("Symfony/Blackfire");
//		userDetails.setFollowers(700);
//		userDetails.setFollowing(20);
//		userDetails.setHireable(false);
//		userDetails.setHtmlUrl("https://github.com/fabpot");
//		userDetails.setPublicRepos(8);
//		userDetails.setPublicGists(10);
//		userDetails.setUrl("https://api.github.com/users/fabpot");
//		userDetails.setType("User");
//		userDetails.setPrivateGists(0);
//		userDetails.setTotalPrivateRepos(0);
//	}
//
//	@Test
//	public void testGetUser() {
//
//		when(userDataService.getUserData(anyString())).thenReturn(CompletableFuture.supplyAsync(() -> userDetails));
//		Result res1=null,res2 = null;
//		UserDetails ud = null;
//		try {
//			Request requestWithoutSession = Helpers.fakeRequest().method("GET").uri("/userData/harman8").build();
//			res1 = userDataController.getUserData(requestWithoutSession,"harman8").toCompletableFuture().get();
//			Request requestWithSession = Helpers.fakeRequest().method("GET").uri("/userData/harman8").session("harman8", "randomKeyTesting").build();
//			res2 = userDataController.getUserData(requestWithSession,"harman8").toCompletableFuture().get();
//			ud = userDataService.getUserData("harman8").toCompletableFuture().get();
//			System.out.println(ud.getName());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// 
//			e.printStackTrace();
//		}
//		//System.out.println(a);
//		assertNotNull(ud);
//		assertEquals("test",ud.getName());
//		assertEquals(44037806,ud.getId());
//		assertEquals("https://avatars.githubusercontent.com/u/44037806?v=4",ud.getAvatarUrl());
//		assertEquals("http://fabien.potencier.org/",ud.getBlog());
//		assertEquals(3,ud.getCollaborators());
//		assertEquals("Symfony/Blackfire",ud.getCompany());
//		assertEquals(700,ud.getFollowers());
//		assertEquals(20,ud.getFollowing());
//		assertEquals(false,ud.isHireable());
//		assertEquals("https://github.com/fabpot",ud.getHtmlUrl());
//		assertEquals(8,ud.getPublicRepos());
//		assertEquals(10,ud.getPublicGists());
//		assertEquals("https://api.github.com/users/fabpot",ud.getUrl());
//		assertEquals("User",ud.getType());
//		assertEquals(0,ud.getPrivateGists());
//		assertEquals(0,ud.getTotalPrivateRepos());
//		assertEquals( HttpStatus.OK_200,res1.status());
//		assertEquals( HttpStatus.OK_200,res2.status());
//
//	}
//}
