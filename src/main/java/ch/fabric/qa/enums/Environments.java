package ch.fabric.qa.enums;

public enum Environments {
	
	/**
	 * Enumerator for testing environments
	 * 
	 * @author aila.bogasieru@agys.ch
	 */



	DEVELOPMENT("http://ubtdock.hq.bpmwave.ch:9333/", "jdbc:postgresql://devdb-postgre.hq.agys.ch:5432/ENGINEDB"),
	TEST("https://test01.qa.hq.aurachain.ch/", "jdbc:postgresql://test01.qa.hq.aurachain.ch:5432/engine_db"),
	STAGING("http://ubtdock.hq.bpmwave.ch:9333/","jdbc:postgresql://camunda-test.hq.agys.ch:5432/camunda_db");

	private String URL;
	private String dbURL;
	
	Environments(String URL, String dbURL) {
		this.URL = URL;
		this.dbURL = dbURL;
	}
	
	public String getURL() {
		return URL;
	}
	
	public String getDBURL() {
		return dbURL;
	}
}
