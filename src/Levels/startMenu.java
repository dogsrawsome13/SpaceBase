package Levels;

import java.util.ArrayList;

import Entities.*;

public class startMenu extends level {

	public startMenu() {
		Ship e = new Ship(300,200,500,390,0); 
		ents.add(e);
		
		ArrayList<Entity> g = new ArrayList<Entity>();
		Button k = new Button (0,0,50,200,"","Start");
		g.add(k);
		Menu f = new Menu(700,600,200,50,g,"blank");

		ents.add(f);
	}

	@Override
	public boolean objectiveMet() {
		// TODO Auto-generated method stub
		return false;
	}

}
