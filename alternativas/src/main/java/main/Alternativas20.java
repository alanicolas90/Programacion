package main;

import java.util.Scanner;

public class Alternativas20 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //el coste del servicio se basa en PESO DEL PAQUETE Y ZONA A LA QUE VA DIRIGIDA
        System.out.print("Dime cuanto pesa el paquete (OJO no puede superar los 5 KILOS): ");
        int pesoPaquete=sc.nextInt();


        if (pesoPaquete>=1 && pesoPaquete<=5){
            System.out.println("Mira la siguiente tabla y pon el numero de la zona a la que se dirige el paquete:" +
                    "\n 1.America del Norte = 1." +
                    "\n 2.America Central = 2." +
                    "\n 3.America del Sur = 3." +
                    "\n 4.Europa = 4." +
                    "\n 5.Asia = 5.");
            int zonaEnvio=sc.nextInt();

            if (zonaEnvio>=1 && zonaEnvio<=5){
                switch (zonaEnvio){
                    case 1:
                        double costeEnvioZona1=pesoPaquete*24;
                        System.out.println("El coste del paquete son "+costeEnvioZona1+" euros.");
                        break;
                    case 2:
                        double costeEnvioZona2=pesoPaquete*20;
                        System.out.println("El coste del paquete son "+costeEnvioZona2+" euros.");
                        break;
                    case 3:
                        double costeEnvioZona3=pesoPaquete*21;
                        System.out.println("El coste del paquete son "+costeEnvioZona3+" euros.");
                        break;
                    case 4:
                        double costeEnvioZona4=pesoPaquete*10;
                        System.out.println("El coste del paquete son "+costeEnvioZona4+" euros.");
                        break;
                    case 5:
                        double costeEnvioZona5=pesoPaquete*18;
                        System.out.println("El coste del paquete son "+costeEnvioZona5+" euros.");
                        break;
                }
            }
        }
        else{
            System.out.println("PESO NO ADMITIDO");
        }


    }
}
