package Entities.ShipModule;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import Entities.Entity;
import Entities.Menus.Menu;
import Entities.Menus.MenuSpawnable;
import Entities.Menus.ShipModuleMenu;

public abstract class ShipModule extends Entity implements MenuSpawnable{

	ArrayList<Entity> resources;
	String moduleType;
	int relX, relY;
	boolean menuOpened;
	public boolean nextLevel=false;
	int modLevel;
	public int health;
	public int clickCount;
	public ShipModule(Polygon b, String modType, int topX, int topY, int maxHealth) {
		super(topX,topY,0,0, 0.0, "");
		health = maxHealth;
		moduleType = modType;
		bounds = b;
		resources = new ArrayList<Entity>();
		menuOpened = false;
		modLevel = 0;
		clickCount = 0;
	}

	@Override
	public void whenClicked(int x, int y){
		clickCount++;
	}
		
	
	@Override
	public abstract Menu spawnMenu();
	
	public String getModType(){
		return moduleType;
	}
	
	public int getLevel(){
		return modLevel;
	}
	
	public void upgrade(){
		modLevel++;
	}

	public abstract void draw(Graphics g);
	
	public ArrayList<Entity> getResources(){
		return resources;
	}
	
	public void setNextLevelPoss(){
		nextLevel = true;
	}

}

