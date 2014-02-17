package nl.lnlug.cucumber.integrationtest;

/**
 * General state values for the different tests
 * 
 */
public class State {
	private String serverUrl = "";
	private String databaseUrl = "";
	private String currentUser = "";

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String email) {
		this.currentUser = email;
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
}
