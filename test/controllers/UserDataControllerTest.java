package controllers;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import play.mvc.Result;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import static play.mvc.Results.ok;
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



@RunWith(MockitoJUnitRunner.class)
public class UserDataControllerTest {
	
	@InjectMocks
	UserDataController userDataController;
	
	@Mock
	UserDataService userDataService;
	
	@Mock
	static
	UserDetails userDetails;
	
	@BeforeClass
	public static void setUp() throws Exception{
		MockitoAnnotations.initMocks(UserDataControllerTest.class);
		
		userDetails = new UserDetails();
		userDetails.setName("test");
		userDetails.setId(44037806);
		userDetails.setAvatarUrl("https://avatars.githubusercontent.com/u/44037806?v=4");
	}

	@Test
	public void testGetUser() {
		
	//	when(userDataService.getUserData(anyString())).thenReturn(CompletableFuture.supplyAsync(() -> userDetails));
		CompletionStage<Result> a = null;
a = userDataController.getUserData("harman8");
			System.out.println(a);
//	System.out.println(a.getName());
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		UserDetails u = new UserDetails();
//		u.setName("Harman");
//		u.setId(44037806);
//		u.setAvatarUrl("https://avatars.githubusercontent.com/u/44037806?v=4");
//		try {
//			assertEquals( "test",((Object) a));
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
