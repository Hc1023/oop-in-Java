import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoint = 0;
        for (Point currPt : s.getPoints()){
            numPoint = numPoint + 1;
        }
        
        return numPoint;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        int num = getNumPoints(s);
        double length = getPerimeter(s);
        double avelength = length/num;
        return avelength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double maxlen=0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if(currDist > maxlen){
                maxlen = currDist;
            }
            //System.out.println("**sidelength = " + currDist);
            //System.out.println("x: " + currPt.getX());
            //System.out.println("y: " + currPt.getY());
            prevPt = currPt;
        }
        return maxlen;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double x = -10000;
        for (Point currPt : s.getPoints()){
            if(currPt.getX()>x){
                x = currPt.getX();
            }
        }
        return x;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double LargestPerim=0;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length > LargestPerim){
                LargestPerim = length;
            }
        }
        return LargestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double LargestPerim=0;
        File temp = null;    // replace this code
        
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length > LargestPerim){
                LargestPerim = length;
                temp = f;
            }
        }
        
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int num = getNumPoints(s);
        System.out.println("NumPoints = " + num);
        double avelength = getAverageLength(s);
        System.out.println("AverageLength = " + avelength);
        double maxlen = getLargestSide(s);
        System.out.println("LargestSide = " + maxlen);
        double x = getLargestX(s);
        System.out.println("LargestX = " + x);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double LargestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("LargestPerim = " + LargestPerim);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fname = getFileWithLargestPerimeter();
        System.out.println("LargestPerim = " + fname);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
