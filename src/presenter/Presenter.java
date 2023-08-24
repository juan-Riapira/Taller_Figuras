package presenter;

import java.awt.Point;

import model.Circle;
import model.Figure;
import model.Square;
import model.Star;
import model.Triangle;

public class Presenter {

     //Figure figure = new Figure(new Point(45,45),45,true);	
   
	public Figure getFigure(String name,int diametro,int hight,int width,boolean flag) {
		if (name.equals("circle") ){
			Figure circle = new Circle (new Point (40,40), diametro);
			if (flag == true) {
				circle.makeVisible(true);;
			}
			
			return circle;
		}else if (name.equals("square")) {
			Figure square = new Square(new Point(60,60),  diametro);
			//square.draw();
			return square;
			
		}else if (name.equals("triangle")) {
			Figure triangle= new Triangle(new Point (150, 60),hight,width);
			//triangle.draw();
			return triangle;
		}else if (name.equals("star")) {
			Figure star = new Star (new Point (70,70),hight,width);
			//star.draw();
			return star;
		}
		
		return null;
	}
	
	
	public Figure changeFigure(Figure figure,String color,int size,boolean flag,int heigth ) {
		

		figure.chanceColor(color);
	
		if (figure instanceof Circle) {
           ((Circle) figure).newSize(size);
        } else if (figure instanceof Square) {
            ((Square) figure).newSize(size); 
        } else if (figure instanceof Triangle) {
			((Triangle) figure).newSize(size, size);
		}else if (figure instanceof Star) {
			
		}
	
  	
		
		

		return figure ;
	}
	
	
	public void slowMove(Figure figure,int abajo,int arriba,int derecha,int izquierda,boolean flag) {
	
		
		if (flag == true) {
		figure.slowMoveHorizontal(derecha);
		figure.slowMoveHorizontal(-(izquierda));
		figure.slowMoveVertical(-(arriba));
		figure.slowMoveVertical(abajo);
		
		}else {
			figure.moveVertical(abajo);
		figure.moveVertical(-(arriba));
		figure.moveHorizontal(derecha);
		figure.moveHorizontal(-(izquierda));
		}
		
		
		
	}
	
	public void makeVisible(Figure figure ,boolean flag) {
		if (flag == true) {
			if (figure instanceof Circle) {
		        figure.makeVisible(flag);
		        } else if (figure instanceof Square) {
		            figure.makeVisible(flag);
		        } else if (figure instanceof Triangle) {
					figure.makeVisible(flag);
				}else if (figure instanceof Star) {
					figure.makeVisible(flag);
				}
	
		}else {
			figure.makeInvisible();
		}
		
	}
	
}


 
