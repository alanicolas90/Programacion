package main;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Pideme el numero del ejercicio: ");
        int numeroEjercicio=sc.nextInt();


        while (numeroEjercicio<21 && numeroEjercicio>0){

            if (numeroEjercicio==1){
                System.out.println("El ejercicio te dira si el numero A es igual, mayor o menor que B.");
                System.out.print("Dime un numero (se llamara A): ");
                int numeroA=sc.nextInt();

                System.out.print("Dime otro numero (se llmara B): ");
                int numeroB=sc.nextInt();

                if (numeroA>numeroB){
                    System.out.println("El numero A es mayor de numero B.");
                }
                else if (numeroA<numeroB){
                    System.out.println("El numero A NO es mayor que numero B.");
                }
                else {
                    System.out.println("El numero A es igual que el numero B");
                }

                break;
            }

            else if (numeroEjercicio==2){
                System.out.println("Te pide un numero y te dice si es numero positivo negativo o es 0");
                System.out.print("Digame un numero: ");
                int number=sc.nextInt();

                if (number<0){
                    System.out.println("El numero es negativo.");
                }
                else if (number>0){
                    System.out.println("El numero es positivo.");
                }
                else{
                    System.out.println("El numero es 0.");
                }
                break;
            }

            else if (numeroEjercicio==3){
                System.out.println("El ejercicio te dice si el numero es par o impar(o 0)");
                System.out.print("Digame un numero: ");
                int number=sc.nextInt();

                if (number%2==0){
                    System.out.println("El numero es par.");
                }
                else if(number==0){
                    System.out.println("el numero es 0.");

                }
                else{
                    System.out.println("El numero es impar.");
                }
                break;
            }

            else if (numeroEjercicio==4){
                System.out.println("El ejercicio divide los 2 numeros que pongas y te dice si el resto es 0 o no.");
                System.out.print("Digame su primer numero: ");
                int numero1=sc.nextInt();

                System.out.print("Digame su segundo numero: ");
                int numero2=sc.nextInt();

                int divisionEntre2Numeros=numero1%numero2;

                if(divisionEntre2Numeros==0){
                    System.out.println("La division: "+numero1+"/"+numero2+ " da 0");
                }
                else{
                    System.out.println("la division: "+numero1+"/"+numero2+" NO da 0");
                }
                break;
            }
            else if (numeroEjercicio==5){
                System.out.println("te pide usuario(que es pepe) y una contraseña que es password) y te dice si esta bien o esta mal");
                System.out.print("Digame su USUARIO: ");
                String usuario=sc.nextLine();


                if (usuario.equals("pepe")){
                    System.out.print("Digame su CONTRASEÑA: ");
                    String password= sc.nextLine();

                    if (password.equals(password)){
                        System.out.println("Has entrado al sistema.");
                    }
                    else{
                        System.out.println("CONTRASEÑA INCORRECTA.");
                    }
                }
                else{
                    System.out.println("USUARIO incorrecto.");
                }
                break;
            }
            else if (numeroEjercicio==6){
                System.out.println("Te dice si la primera letra es mayuscula o minuscuula.");
                System.out.print("Dime tu nombre: ");
                String nombre=sc.nextLine();
                char inicialNombre=nombre.charAt(0);

                if (inicialNombre>=65 && inicialNombre<=90){
                    System.out.println("La primera letra es mayuscula.");
                }

                else{
                    System.out.println("La primera letra es minuscula");
                }
                break;
            }
            else if (numeroEjercicio==7){
                System.out.println("Te pide la base de la potencia y luego el exponente y te lo calcula");
                System.out.print("Digame la base de la potencia: ");
                int baseDeLaPotencia=sc.nextInt();

                System.out.print("Digame el exponente de la potencia: ");
                int exponenteDeLaPotencia=sc.nextInt();

                double resultadoPotencia=  Math.pow(baseDeLaPotencia,exponenteDeLaPotencia);

                if (exponenteDeLaPotencia>0){
                    System.out.println("El resultado de "+baseDeLaPotencia+" elevado a "+ exponenteDeLaPotencia+" es: "+(int)resultadoPotencia);
                }
                else if(exponenteDeLaPotencia==0){
                    System.out.println("El resultado de "+baseDeLaPotencia+" elevado a "+ exponenteDeLaPotencia+" es: 1");
                }
                else if(exponenteDeLaPotencia<0){
                    System.out.println("El resultado de "+baseDeLaPotencia+" elevado a "+ exponenteDeLaPotencia+" es: "+resultadoPotencia);
                }
                break;
            }
            else if (numeroEjercicio==8){
                System.out.println("Te pide nota edad y sexo y te dice la respuesta del enunciado");
                System.out.print("Dime tu NOTA: ");
                int nota=sc.nextInt();

                System.out.print("Dime tu EDAD: ");
                int edad= sc.nextInt();
                sc.nextLine();

                System.out.print("Dime tu SEXO(SOLO DIME F/M): ");
                String sexo=sc.nextLine();

                if (nota>=5){
                    if(edad>=18) {

                        if(sexo.equalsIgnoreCase("F")){
                            System.out.println("ACEPTADA");
                        }
                        else if(sexo.equalsIgnoreCase("M")){
                            System.out.println("POSIBLE");
                        }
                        else{
                            System.out.println("NO ACEPTADA");
                        }
                    }
                    else {
                        System.out.println("NO ACEPTADA");
                    }
                }
                else{
                    System.out.println("NO ACEPTADA");
                }
                break;
            }
            else if (numeroEjercicio==9){
                System.out.println("te pide 3 numeros y depues te coloca los numero de mayor a menor");
                System.out.print("Dime el pimer numero: ");
                int numero1=sc.nextInt();

                System.out.print("Dime el segundo numero: ");
                int numero2=sc.nextInt();

                System.out.print("Dime el tercer numero: ");
                int numero3=sc.nextInt();

                if(numero1>numero2 && numero1>numero3){
                    if(numero2>numero3){
                        System.out.println(numero1+" "+numero2+" "+numero3);
                    }
                    else if(numero2<numero3){
                        System.out.println(numero1+" "+numero3+" "+numero2);
                    }
                    else{
                        System.out.println(numero1+" "+numero3+" "+numero2);
                    }
                }
                else if(numero2>numero1 && numero2>numero3){
                    if(numero1>numero3){
                        System.out.println(numero2+" "+numero1+" "+numero3);
                    }
                    else if(numero1<numero3){
                        System.out.println(numero2+" "+numero3+" "+numero1);
                    }
                    else{
                        System.out.println(numero2+" "+numero3+" "+numero1);
                    }
                }
                else if(numero3>numero1 && numero3>numero2){
                    if (numero1>numero2){
                        System.out.println(numero3+" "+numero1+" "+numero2);
                    }
                    else if(numero1<numero2){
                        System.out.println(numero3+" "+numero2+" "+numero1);
                    }
                    else{
                        System.out.println(numero3+" "+numero2+" "+numero1);
                    }
                }
                break;
            }
            else if (numeroEjercicio==10){
                System.out.println("Te pide las coordenadas  de dos circunferencias y te dice como son una respecto a la otra");
                System.out.print("Dame la coordenada x1: ");
                int coordenadaX1=sc.nextInt();
                System.out.print("Dame la coordenada y1: ");
                int coordenadaY1=sc.nextInt();
                System.out.print("Dame el radio de la circunferencia r1: ");
                int radioR1=sc.nextInt();

                System.out.print("Dame la coordenada x2: ");
                int coordenadaX2=sc.nextInt();
                System.out.print("Dame la coordenada y2: ");
                int coordenadaY2=sc.nextInt();
                System.out.print("Dame el valor r2: ");
                int radioR2=sc.nextInt();

                int restaCoordenadas1=(coordenadaX2-coordenadaX1);
                int restaCoordenadas2=(coordenadaY2-coordenadaY1);
                int sumaRadios=radioR1+radioR2;
                int restaRadios=Math.abs(radioR1-radioR2);


                double distanciaEntreOrigenes= Math.sqrt((Math.pow(restaCoordenadas1,2)) + (Math.pow(restaCoordenadas2,2)));

                if(distanciaEntreOrigenes==0){
                    System.out.println("Son circunferencias CONCENTRICAS");
                }
                else if(distanciaEntreOrigenes==restaRadios){
                    System.out.println("Son circunferencias TANGENTES INTERIORES");
                }
                else if(distanciaEntreOrigenes==sumaRadios){
                    System.out.println("Son circunferencias TANGENTES EXTERIORES");
                }
                else if(distanciaEntreOrigenes>sumaRadios){
                    System.out.println("Son circunferencias EXTERIORES.");
                }
                else if(distanciaEntreOrigenes<sumaRadios){
                    System.out.println("Son circunferencias SECANTES.");
                }
                else if(distanciaEntreOrigenes<restaRadios){
                    System.out.println("Son circunferencias INTERIORES");
                }
                break;
            }
            else if (numeroEjercicio==11){
                System.out.println("te pide las longitudes de los lados del triangulo y te dice que tipo de triangulo es");
                System.out.print("Dime la longitud del lado A: ");
                int ladoA=sc.nextInt();

                System.out.print("Dime la longitud del lado B: ");
                int ladoB=sc.nextInt();

                System.out.print("Dime la longitud del lado C: ");
                int ladoC=sc.nextInt();

                if(ladoA==ladoB && ladoA==ladoC){
                    System.out.println("El triangulo es equilatero.");
                }
                else if(ladoA==ladoB || ladoA==ladoC ||ladoB==ladoC){
                    System.out.println("El triangulo es isosceles.");
                }

                else if(ladoA>ladoB && ladoA>ladoC){

                    int hipotenusa=ladoA;
                    double catetosTriangulo=Math.sqrt(Math.pow(ladoB,2)+Math.pow(ladoC,2));

                    if (hipotenusa==catetosTriangulo){
                        System.out.println("Es triangulo rectángulo.");
                    }
                    else{
                        System.out.println("Es un triangulo escaleno.");
                    }


                }
                else if(ladoB>ladoA && ladoB>ladoC){

                    int hipotenusa=ladoB;
                    double catetosTriangulo=Math.sqrt(Math.pow(ladoA,2)+Math.pow(ladoC,2));

                    if (hipotenusa==catetosTriangulo){
                        System.out.println("Es triangulo rectángulo.");
                    }
                    else{
                        System.out.println("Es un triangulo escaleno.");
                    }

                }
                else if(ladoC>ladoA && ladoC>ladoB){

                    int hipotenusa=ladoC;
                    double catetosTriangulo=Math.sqrt(Math.pow(ladoB,2)+Math.pow(ladoA,2));

                    if (hipotenusa==catetosTriangulo){
                        System.out.println("Es triangulo rectángulo.");
                    }
                    else{
                        System.out.println("Es un triangulo escaleno.");
                    }

                }
                break;
            }
            else if (numeroEjercicio==12){
                System.out.println("Te pide un año y te dice si es bisiesto o no");
                System.out.print("Dime un año: ");
                int year=sc.nextInt();

                if (year%4==0){
                    System.out.println("el año SI es bisiesto.");
                }
                else{
                    System.out.println("El año NO es bisiesto.");
                }
                break;
            }
            else if (numeroEjercicio==13){
                System.out.println("Te pide dia/mes/año (que esta puesto para el 22/9/2021) y te dice si esta bien o no");
                final int day=22;
                final int month=9;
                final int year=2021;

                System.out.print("Dime el dia: ");
                int dayTyped=sc.nextInt();

                System.out.print("Dime el mes: ");
                int monthTyped=sc.nextInt();

                System.out.print("Dime el año: ");
                int yearTyped=sc.nextInt();

                if(day==dayTyped){
                    if(month==monthTyped){
                        if(year==yearTyped){
                            System.out.println("CORRECTO");
                        }
                        else{
                            System.out.println("INCORRECTO");
                        }
                    }
                    else{
                        System.out.println("INCORRECTO");
                    }
                }
                else{
                    System.out.println("INCORRECTO");
                }
                break;
            }
            else if (numeroEjercicio==14){
                System.out.print("Cuantos kilos de uva quieres vender: ");
                int kilosUva=sc.nextInt();

                sc.nextLine();

                System.out.print("Que tipo de uvas son?(A/B): ");
                String tipoUva=sc.nextLine();

                if (tipoUva.equalsIgnoreCase("A")){

                    System.out.print("Que tamaño son?(1/2): ");
                    int sizeUva=sc.nextInt();

                    if(sizeUva==1){
                        int ganancias=kilosUva*20;
                        System.out.println("Vas a ganar "+ganancias+" centimos respecto al precio base.");

                    }
                    else if(sizeUva==2){
                        int ganancias=kilosUva*30;
                        System.out.println("Vas a ganar "+ganancias+" centimos respecto al precio base.");

                    }
                    else{
                        System.out.println("SOLO HAY TAMAÑO 1 y 2.");
                    }
                }
                else if(tipoUva.equalsIgnoreCase("B")){

                    System.out.print("Que tamaño son?(1/2): ");
                    int sizeUva=sc.nextInt();

                    if(sizeUva==1){
                        int ganancias=kilosUva*(30);
                        System.out.println("Vas a perder "+ganancias+" centimos respecto al precio base.");
                    }
                    else if(sizeUva==2){
                        int ganancias=kilosUva*(50);
                        System.out.println("Vas a perder "+ganancias+" centimos respecto al precio base.");
                    }
                }
                else{
                    System.out.println("No hay un tipo asi de uvas. PONGA SOLO A o B.");
                }
                break;
            }
            else if (numeroEjercicio==15){

                break;
            }
            else if (numeroEjercicio==16){
                System.out.println("segun los minutos de llamada te dice cuanto tienes que pagar a la compañia");
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
                break;
            }
            else if (numeroEjercicio==17){
                System.out.println("Te pide el lado de un dado y te da el opuesto");
                System.out.print("Introduzca el numero del dado: ");
                int numeroDado=sc.nextInt();

                if (numeroDado<0 || numeroDado>6){
                    System.out.println("ERROR: número incorrecto");
                }
                switch (numeroDado){
                    case 1:
                        System.out.println("La cara opuesta es: SEIS");
                        break;
                    case 2:
                        System.out.println("La cara opuesta es: CINCO");
                        break;
                    case 3:
                        System.out.println("La cara opuesta es: CUATRO");
                        break;
                    case 4:
                        System.out.println("La cara opuesta es: TRES");
                        break;
                    case 5:
                        System.out.println("La cara opuesta es: DOS");
                        break;
                    case 6:
                        System.out.println("La cara opuesta es: UNO");
                        break;
                }
                break;
            }
            else if (numeroEjercicio==18){
                System.out.println("Te pide el numero del dia de la semana(1-7) y te dice que dia es.");
                System.out.print("Dime el numero de la semana: ");
                int numeroDelDia=sc.nextInt();

                if(numeroDelDia>=1 && numeroDelDia<=7) {

                    switch (numeroDelDia) {
                        case 1:
                            System.out.println("LUNES");
                            break;
                        case 2:
                            System.out.println("MARTES");
                            break;
                        case 3:
                            System.out.println("MIERCOLES");
                            break;
                        case 4:
                            System.out.println("JUEVES");
                            break;
                        case 5:
                            System.out.println("VIERNES");
                            break;
                        case 6:
                            System.out.println("SABADO");
                            break;
                        case 7:
                            System.out.println("DOMINGO");
                            break;
                    }
                }
                else if(numeroDelDia<0){
                    System.out.println("No existe numero de la semana negativo.");
                }
                else{
                    System.out.println("Los dias de la semana van del 1 al 7 pringado");
                }
                break;
            }
            else if (numeroEjercicio==19){
                System.out.println("Pones el numero del mes(1-12) y te dice cuantos dias tiene ese mes.");
                System.out.print("Dime el mes en numeros (1-12): ");
                int numeroDelMes=sc.nextInt();

                if(numeroDelMes>=1 && numeroDelMes<=12){
                    switch (numeroDelMes){
                        case 1:
                            System.out.println("El mes de Enero tiene 31 dias.");
                            break;
                        case 2:
                            System.out.println("El mes de Febrero tiene 28 o 29(en año bisiesto) dias.");
                            break;
                        case 3:
                            System.out.println("El mes de Marzo tiene 31 dias.");
                            break;
                        case 4:
                            System.out.println("El mes de Abril tiene 30 dias.");
                            break;
                        case 5:
                            System.out.println("El mes de Mayo tiene 31 dias.");
                            break;
                        case 6:
                            System.out.println("El mes de Junio tiene 30 dias.");
                            break;
                        case 7:
                            System.out.println("El mes de Julio tiene 31 dias.");
                            break;
                        case 8:
                            System.out.println("El mes de Agosto tiene 31 dias.");
                            break;
                        case 9:
                            System.out.println("El mes de Septiembre tiene 30 dias.");
                            break;
                        case 10:
                            System.out.println("El mes de Octubre tiene 31 dias.");
                            break;
                        case 11:
                            System.out.println("El mes de Noviembre tiene 30 dias.");
                            break;
                        case 12:
                            System.out.println("El mes de Diciembre tiene 31 dias.");
                            break;
                    }
                }
                else{
                    System.out.println("Los meses estan comprendidos entre 1 y 12");
                }
                break;
            }
            else if (numeroEjercicio==20){
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
                break;
            }


        }





    }
}
