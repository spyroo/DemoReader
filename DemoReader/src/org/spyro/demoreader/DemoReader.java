package org.spyro.demoreader;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class DemoReader {
	
	public static void main(String[] args){
		new DemoReader();
	}
	
	public DemoReader(){
		try {
			
			ArrayList<DemoGeneralInfo> demos = batchloadDemos(new File("testdemo.dem"), new File("D:/Steam/steamapps/common/Team Fortress 2/tf/match-20141213-2149-koth_pro_viaduct_rc4.dem"));
			for(DemoGeneralInfo dem : demos){
				System.out.println(dem.getClientName());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readBytes(DataInputStream br, int length) throws IOException{
		byte[] charArray = new byte[length];
		br.read(charArray, 0, length);
		return (new String(charArray));
	}
	
	public ArrayList<DemoGeneralInfo> batchloadDemos(File...files) throws IOException{
		ArrayList<DemoGeneralInfo> demos = new ArrayList<DemoGeneralInfo>();
		for(File f : files){
			demos.add(getGeneralDemoInfo(f));
		}
		return demos;
	}
	
	public DemoGeneralInfo getGeneralDemoInfo(File file) throws IOException{
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		byte[] handle = new byte[8]; in.readFully(handle);
		if(!new String(handle).contains("HL2DEMO"))
			return null;
		int demoProtocol = in.readInt();
		int networkProtocol = in.readInt();
		String serverName = readBytes(in, 260).trim();
		String clientName = readBytes(in, 260).trim();
		String mapName = readBytes(in, 260).trim();
		String gameDir = readBytes(in, 260).trim();
		float playbackTime = in.readFloat();
		int ticks = in.readInt();
		int frames = in.readInt();
		in.close();
		return new DemoGeneralInfo(file.getName(), demoProtocol, networkProtocol, serverName, clientName, mapName, gameDir, playbackTime, ticks, frames);
	}
	
	
}
