package nl.lnlug.cucumber.integrationtest;

/**
 * General state values for the different tests
 * 
 */
public class State {
	private String serverUrl = "";
	private String currentUser = "";

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String email) {
		this.currentUser = email;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
}
