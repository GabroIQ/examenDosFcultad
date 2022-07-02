import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int cochera[] = new int[12];
        int numIngresado;
        int numIngresadoVehículo;
        int contadorDeMoto = 0;
        int contadorDeAuto = 4;
        int contadorDeCamioneta = 9;
        boolean flag = false;
        try (Scanner scanner = new Scanner(System.in)) {
            while (flag == false) {
                System.out.println("1- Registrar vehículos");
                System.out.println("2- solicitar la facturación del día,");
                System.out.println("3- Salir");
                numIngresado = scanner.nextInt();
                if (numIngresado == 1) {//PRIMER IF
                    System.out.println("Que vehículo desea registrar?");
                    System.out.println("1- Moto");
                    System.out.println("2- Auto");
                    System.out.println("3- Camioneta");
                    numIngresadoVehículo = scanner.nextInt();
   
                    switch (numIngresadoVehículo) {//APERTURA DE SWITCH
                        case 1:
                            int ocupadoMoto = Esta_Ocupado(cochera , 4);
                            if (ocupadoMoto == 1) {//SEGUNDO IF
                                System.out.println("CONCHERA PARA MOTO OCUPADAS. Solo puede elegir entre: ");
                                System.out.println("Auto");
                                System.out.println("Camioneta");
                                System.out.println("Presione cualquier tecla para continuar del 1-9: ");
                                numIngresadoVehículo = scanner.nextInt();
                            }else{
                                for (int i = 0; i <= contadorDeMoto; i++) {
                                    cochera[i] = 1;
                                }
                                contadorDeMoto++;
                            } //CIERRE SEGUNDO IF
                            break;

                            case 2:
                                int ocupadoAuto = Esta_Ocupado(cochera , 8);

                                if (ocupadoAuto == 1) { //TERCER IF
                                    System.out.println("CONCHERA PARA AUTOS OCUPADAS. Solo puede elegir entre: ");
                                    System.out.println("moto");
                                    System.out.println("Camioneta");
                                    System.out.println("Presione cualquier tecla para continuar del 1-9: ");
                                    numIngresadoVehículo = scanner.nextInt();
                                }else{
                                    for (int i = 4; i <= contadorDeAuto; i++) {
                                        cochera[i] = 1;
                                    }
                                    contadorDeAuto++;
                                }// CIERRE TERCER IF
                                break;

                               case 3:
                                ocupadoAuto = Esta_Ocupado(cochera , 12);
                                if (ocupadoAuto == 1) {//CUARTO IF
                                    System.out.println("CONCHERA PARA CAMIONETAS OCUPADAS. Solo puede elegir entre: ");
                                    System.out.println("Moto");
                                    System.out.println("Auto");
                                    System.out.println("Presione cualquier tecla para continuar del 1-9: ");
                                    numIngresadoVehículo = scanner.nextInt();
                                }else{
                                    for (int i = 8; i < contadorDeCamioneta; i++) {
                                        cochera[i] = 1;
                                    }
                                    contadorDeCamioneta++;
                                }//CIERRE CUARTO IF
                                break;           
                        default:
                                System.out.print("Error");
                            break;
                    }//CIERRE DE SWITCH
                }else{
                    if (numIngresado == 2) {//QUINTO IF
                        Mostrar_Facturacion(cochera);
                    } else {
                        flag = !flag;
                    }//CIERRE QUINTO IF
                }//CIERRE DEFINITIVO DEL PRIMER IF
            }//TERMINA EL WHILE
        }
    }//CIERRE DE FUNCIOV VOID
    
    public static int Esta_Ocupado(int arrCochera[] , int num){
        int ocupado = 0;   
        for (int i = 0; i < num; i++) {
            if (arrCochera[i] > 0) {
                arrCochera[i] = 1;
                ocupado = arrCochera[i];
            }
            else{
                ocupado = 0;
            }
        }
        return ocupado;
    }//CIERRE DE FUNCION ESTA_OCUPADO

    public static void Mostrar_Facturacion(int arrCochera[]) {
        int cantMotos = 0;
		int cantAutos = 0;
		int cantCamionetas = 0;

		for (int i = 0 ; i < arrCochera.length ; i++) {
			if (arrCochera[i] != 0) {
				if (i < 4) {
					cantMotos++;
				}else {
					if (i < 8) {
						cantAutos++;
					}else {
						cantCamionetas++;
					}
				}
			}//CIERRE IF DE FUNCION MOSTAR_FACTURACION
		}//CIERRE FOR
		System.out.println("Cantidad de Motos: " + cantMotos);
		System.out.println("Cantidad de Autos: " + cantAutos);
		System.out.println("Cantidad de Camionetas: " + cantCamionetas);
		int totalMotos = cantMotos * 150;
		int totalAutos = cantAutos * 500;
		int totalCamio = cantCamionetas * 800;
		System.out.println("Total facturado: " + (totalMotos + totalAutos + totalCamio)); 
        System.out.println("");           
}//CIERRE DE FUNCION MOSTAR_FACTURACION
}//CIERRE MAIN
