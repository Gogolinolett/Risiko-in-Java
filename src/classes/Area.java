package classes;

import java.util.LinkedList;

public class Area {
    private int troopCount;
    private Farben farbeOwner;
    private String name;
    LinkedList<Area> neighbours = new LinkedList<>();

    public Area(String name){
        this.name = name;
        troopCount = 1;
    }

    public void addTroops(int amount){
        troopCount += amount;
    }

    public String getName(){
        return name;
    }

    public void setFarbeOwner(Farben farbeOwner) {
        this.farbeOwner = farbeOwner;
    }

    public Farben getFarbeOwner() {
        return farbeOwner;
    }

    public void setTroopCount(int troopCount) {
        this.troopCount = troopCount;
    }

    public int getTroopCount(){
        return troopCount;
    }

    public void addNeighbour(Area area){
        if(neighbours.contains(area)){
            return;
        }
        neighbours.add(area);
        area.addNeighbour(this);


    }
}