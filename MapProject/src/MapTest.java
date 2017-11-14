
public class MapTest{
	public static void main(String[] args){
    MapPlayerRepository dreamteam = new MapPlayerRepository();
    
    dreamteam.put("forward", "henry");
    dreamteam.put("rightwing", "ronaldo");
    dreamteam.put("goalkeeper", "cech");
    
    System.out.println("Forward is " + dreamteam.get("forward"));
    System.out.println("Right wing is " + dreamteam.get("rightwing"));
    System.out.println("Goalkeeper is " + dreamteam.get("goalkeeper"));    
  }
}