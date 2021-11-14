package controllers;

import org.junit.*;

import model.GitHubApi;
import model.GitHubApiMock;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;

import static org.junit.Assert.assertEquals;
import static play.inject.Bindings.bind;
import play.test.Helpers;


public class GitHubTest {
	private static Application testApp;
	private static GitHubApi testGitHub;
	
	@BeforeClass
	public static void initTestApp() {
		testApp = new GuiceApplicationBuilder()
		.overrides(bind(GitHubApi.class).to(GitHubApiMock.class))
		.build();
		
		testGitHub = testApp.injector().instanceOf(GitHubApi.class);
	}
	
	@AfterClass
	public static void stopTestApp() {
		Helpers.stop(testApp);
	}

	@Test
	public void getRepository() {
		assertEquals("This is mock API", testGitHub.getRepositoryInfo(1));
	}
}
