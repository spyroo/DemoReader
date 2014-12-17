package org.spyro.demoreader;

public class DemoGeneralInfo {
	
	private int demoProtocol, networkProtocol, ticks, frames;
	private String serverName, clientName, mapName, gameDir, demoFileName;
	/**
	 * @return the demoFileName
	 */
	public String getDemoFileName() {
		return demoFileName;
	}

	private float playbackTime;
	
	/**
	 * @return the demoProtocol
	 */
	public int getDemoProtocol() {
		return demoProtocol;
	}

	/**
	 * @return the networkProtocol
	 */
	public int getNetworkProtocol() {
		return networkProtocol;
	}

	/**
	 * @return the ticks
	 */
	public int getTicks() {
		return ticks;
	}

	/**
	 * @return the frames
	 */
	public int getFrames() {
		return frames;
	}

	/**
	 * @return the serverName
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @return the mapName
	 */
	public String getMapName() {
		return mapName;
	}

	/**
	 * @return the gameDir
	 */
	public String getGameDir() {
		return gameDir;
	}

	/**
	 * @return the playbackTime
	 */
	public float getPlaybackTime() {
		return playbackTime;
	}

	public DemoGeneralInfo(String demoFileName, int demoProtocol, int networkProtocol, String serverName, String clientName, String mapName, String gameDir, float playbackTime, int ticks, int frames){
		this.demoFileName = demoFileName;
		this.demoProtocol = demoProtocol;
		this.networkProtocol = networkProtocol;
		this.serverName = serverName;
		this.clientName = clientName;
		this.mapName = mapName;
		this.gameDir = gameDir;
		this.playbackTime = playbackTime;
		this.ticks = ticks;
		this.frames = frames;
	}
	
}
