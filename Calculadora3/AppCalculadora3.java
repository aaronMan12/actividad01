import java.util.Scanner;
public class AppCalculadora3{
	public static void main(String[]arg){

		Calculadora3 cal1;
		cal1=new Calculadora3();
		char respuesta='s';
		Scanner console =new Scanner(System.in);
		Scanner in=new Scanner(System.in);

		do{
			System.out.println("1.suma:");
			System.out.println("2.resta:");
			System.out.println("3.multiplicaion:");
			System.out.println("4.division:");
			System.out.println("elija una de las 4 opciones");
			int opcion = in.nextInt();

			System.out.println("introduzca un numero");
			float n1 = in.nextFloat();	
			System.out.println("introduzca otro numero");
			float n2 =in.nextFloat();
			System.out.println("calculadora basica");
			
			switch(opcion){
				case 1:System.out.println("la suma es:" + cal1.sumar(n1,n2));
				break;

				case 2:System.out.println("la resta es:" + cal1.restar(n1,n2));
				break;

				case 3:System.out.println("la multiplicacion es:" + cal1.multiplicar(n1,n2));
				break;

				case 4:System.out.println("la division es:" + cal1.dividir(n1,n2));
				break;

				default:

			}

			System.out.println("desea realizar otra opcion (S/N)");
			respuesta=console.next().charAt(0);
			}while((respuesta=='S')||(respuesta=='s'));


	}
		
}