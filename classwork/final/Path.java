import java.util.*;

public class Path
{
   
   private ArrayList<Location> path;
   
   public Path(ArrayList<Location> corners)
   {
      this.path = this.create(corners);
   }
   
   //returns the completed Path
   public ArrayList<Location> getPath()
   {  return path;}
   
   //returns the Location at index within the completed Path
   public Location getLocation(int index)
   { return path.get(index);}
   
   //precondition: all Locations in corners are rounded
   private ArrayList<Location> create(ArrayList<Location> corners)
   {
      ArrayList<Location> complete = new ArrayList<Location>();
      Location location = corners.get(0);
      complete.add(location.round());
      
      for(int c = 1; c < corners.size(); c++)
      {
         double slope = corners.get(c).riseOverRun(corners.get(c-1));
         
         while(location.equals(corners.get(c)) == false)
         {
            location.changeX(location.getX() + 1);
            location.changeY(location.getY() + slope);
            complete.add(location.round());
         }
         location = corners.get(c);
      }
      return complete;
   }

}