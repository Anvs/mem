package com.anvs.mem.client;

import com.anvs.mem.control.MemServer;
import com.anvs.mem.control.MemServerImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

public class MemApp {

	public static void main(String[] args) {
		MemServer server = new MemServerImpl();
		ClientHandler clientHandler = new ClientHandler(server);
		try {
			clientHandler.openEmpListView();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
