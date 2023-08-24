package view;

import java.util.Scanner;

import model.Figure;
import presenter.Presenter;

public class Runner {
	Presenter presenter = new Presenter();
	Scanner input;

	public static void main(String[] args) {

		Runner runner = new Runner();
		runner.input = new Scanner(System.in);
		runner.menu();

	}

	public void menu() {

		String option;
		boolean j = false;
		int side = 0;
		int width = 0;
		int high = 0;
		int down = 0;
		int up = 0;
		int right = 0;
		int left = 0;
		boolean flag = false;

		String color = "blue";
		String name = "";
		boolean optionVisible;

		System.out.println("  What figure do you want to create?  \n" + "1. Circle \n" + "2. Square \n"
				+ "3. Triangle \n" + "4. Star \n" + "5. Leave \n" + "  <<<  please select an option >>>");

		option = input.next();
		optionVisible = false;

		switch (option) {
		case "1":
			System.out.println(" ---------------  CREATE CIRCLE  ------------------");

			System.out.println("Enter radius  ");
			side = input.nextInt();
			name = "circle";
			break;
		case "2":
			System.out.println(" ---------------  CREATE SQUARE  ------------------");

			System.out.println("Enter side  \n ");
			side = input.nextInt();
			name = "square";
			break;

		case "3":
			j = true;
			System.out.println(" ---------------  CRAETE TRIANGLE  ------------------");

			System.out.print("Enter hight: ");
			high = input.nextInt();
			System.out.print("Enter widtch: ");
			width = input.nextInt();
			name = "triangle";
			break;
		case "4":
			j = true;
			System.out.println(" ---------------  CRAETE STAR  ------------------");

			System.out.println("Enter high:");
			high = input.nextInt();
			System.out.println("Enter width");
			width = input.nextInt();
			name = "star";
			break;
		case "5":
			System.out.println("close pragram!!!");
			System.exit(0);

		}
		Figure figure = presenter.getFigure(name, side, high, width, flag);
		int optionWhile;

		/////

		do {
			System.out.println(" do you want to modify?  \n" + "1. Yes \n" + "2. No \n" + "Enter option  \n");
			optionWhile = input.nextInt();
			if (optionWhile == 1) {
				System.out.println(
						" what do you want to modify \n" + "1. Color \n" + "2. size \n" + "3. Move with movement \n"
								+ "4. Move \n" + "5. Make visible \n" + "6. Make invisible \n" + "7. Leave ");
				option = input.next();

				switch (option) {
				case "1":
					System.out.println(" What color do you want to change to? \n"
							+ "red, black, blue, yellow, green, magenta, white\n" + " Enter new color \n ");
					color = input.next();

					presenter.changeFigure(figure, color, side, flag, width);

					break;
				case "2":
					if (j) {
						System.out.print("Enter a new height: ");
						high = input.nextInt();
						System.out.print("Enter a new width: ");
						width = input.nextInt();
						presenter.changeFigure(figure, color, high, flag, width);

					} else {
						System.out.println(" Enter a new size ");
						side = input.nextInt();
						presenter.changeFigure(figure, color, side, flag, width);
						if (optionVisible) {

						}
					}

					break;
				case "3":
					flag = true;
					System.out.println("Enter the number of pixels to traverse in each direction.");
					System.out.print("Right : ");
					right = input.nextInt();
					System.out.print("izquierda : ");
					left = input.nextInt();
					System.out.println("arriba : ");
					up = input.nextInt();
					System.out.println("abajo : ");
					down = input.nextInt();

					presenter.slowMove(figure, down, up, right, left, flag);
					break;

				case "4":

					System.out.println("Enter the number of pixels to traverse in each direction. ");
					System.out.print("derecha : ");
					right = input.nextInt();
					System.out.print("izquierda : ");
					left = input.nextInt();
					System.out.println("arriba : ");
					up = input.nextInt();
					System.out.print("abajo");

					down = input.nextInt();

					presenter.slowMove(figure, down, up, right, left, flag);

					break;
				case "5":
					flag = true;
					presenter.makeVisible(figure, flag);

					break;
				case "6":
					flag = false;
					presenter.makeVisible(figure, flag);
					break;
				case "7":
					System.exit(0);
					break;

				}
			} else {
				menu();
			}
		} while (optionWhile == 1);

	}

}
