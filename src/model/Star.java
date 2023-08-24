package model;


import java.awt.Point;
import java.awt.Polygon;


public class Star extends Figure {

	private int height;
	private int width;

	public Star(Point point, int height, int width) {
		super(point);
		this.height = height;
		this.width = width;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		if (isVisible) {
			Canvas canvas = Canvas.getCanvas();
            int[] xPoints = new int[10];
            int[] yPoints = new int[10];

            for (int i = 0; i < 10; i++) {
                double angle = Math.PI / 5 * i;
                if (i % 2 == 0) {
                    xPoints[i] = (int) (point.x + height * Math.cos(angle));
                    yPoints[i] = (int) (point.y + width * Math.sin(angle));
                } else {
                    xPoints[i] = (int) (point.x + height * Math.cos(angle));
                    yPoints[i] = (int) (point.y + height * Math.sin(angle));
                }
            }

            canvas.draw(this, color, new Polygon(xPoints, yPoints, 10));
            canvas.wait(10);
        }
    }
		
	  public void changeSize(int newHeight, int newWidth)
	    {
	        erase();
	        height = newHeight;
	        width = newWidth;
	        draw();
	    }
	




	

}
