package org.example.onlineagendaapp.io.impl;

import org.example.onlineagendaapp.io.OnlineAgendaIO;
import org.example.onlineagendaapp.model.OnlineAgenda;

public class DBOnlineAgendaIO implements OnlineAgendaIO {

	@Override
	public OnlineAgenda getOnlineAgenda() {
		System.out.println("DB");
		return null;
	}

	@Override
	public void saveOnlineAgenda(OnlineAgenda onlineAgenda) {
		// TODO Auto-generated method stub
	}

}
