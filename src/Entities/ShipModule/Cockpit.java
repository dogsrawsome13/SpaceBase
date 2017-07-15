package Entities.ShipModule;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import Entities.Entity;
import Entities.Menus.Menu;
import Entities.Menus.ShipModuleMenu;

public class Cockpit extends ShipModule {

	public Cockpit(Polygon b, int topX, int topY) {
		super(b, "Cockpit", topX, topY, 75);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void whenClicked(int x, int y) {
		// TODO Auto-generated method stub

		menuOpened = true;
	}

	@Override
	public Menu spawnMenu() {
		// TODO Auto-generated method stub
		if(menuOpened){
			//later create ship module sub classes
			
			return new ShipModuleMenu(xCoord+200, yCoord-50, 182,207, new ArrayList<Entity>(),this);
		}
		return null;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

}
