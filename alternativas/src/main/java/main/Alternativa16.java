package main;

import java.util.Scanner;

public class Alternativa16 {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);

        System.out.print("Dime los minutos de tu llamada: ");
        int minutosLlamada=sc.nextInt();

        if(minutosLlamada<=5){
            int cobro5Mins=minutosLlamada;
            System.out.println(cobro5Mins+" EUROS");
        }

        else if (minutosLlamada>5 && minutosLlamada<=8){
            int cobro5Mins=5;
            int cobro3Mins=(minutosLlamada-5)*80;
            int cobroCentimosTotales=cobro3Mins%100;
            int cobroEurosTotales=cobro5Mins+cobro3Mins/100;
            System.out.println(cobroEurosTotales+" EUROS y "+cobroCentimosTotales+" centimos");
        }

        else if( minutosLlamada>8 && minutosLlamada<=10 ){
            int cobro5Mins=500;
            int cobro3Mins=240;
            int cobro2Mins=(minutosLlamada-8)*70;
            int cobroCentimosTotales=((cobro3Mins%100)+(cobro2Mins%100))%100;
            int eurosDeCetimos=((cobro3Mins%100)+(cobro2Mins%100))/100;
            int cobroEurosTotales=(cobro3Mins/100+cobro5Mins/100+cobro2Mins/100+eurosDeCetimos);
            System.out.println(cobroEurosTotales+" EUROS y "+cobroCentimosTotales+" centimos");

        }

        else{
            int cobro5Mins=500;
            int cobro3Mins=240;
            int cobro2Mins=140;
            int cobroMasDe10Mins=(minutosLlamada-10)*50;
            int cobroCentimosTotales=((cobro3Mins%100)+(cobro2Mins%100)+(cobroMasDe10Mins%100))%100;
            int eurosDeCetimos=((cobro3Mins%100)+(cobro2Mins%100)+(cobroMasDe10Mins))/100;
            int cobroEurosTotales=(cobro3Mins/100+cobro5Mins/100+cobro2Mins/100+eurosDeCetimos);
            System.out.println(cobroEurosTotales+" EUROS y "+cobroCentimosTotales+" centimos");
        }
    }
}
