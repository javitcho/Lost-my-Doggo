package com.progra.grupo.lostmydoggo;

import android.location.Location;
import android.location.LocationManager;

import java.util.ArrayList;
import java.util.Scanner;

public class tempMain {
    //Utilicemos la base de datos temporal de un arrayList para simular el comportamiento de la conexion con mySQL
    //Para fines demostrativos se crearán usuarios demos
    public static void main(String args[]){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(2,"JuanitoPerez123","piñaConCoco",22000000));
        ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota(1,"coco","Blanco y negro y lindo","Blanco y Negro",null,usuarios.get(0)));
        ArrayList<Alertas> alertas = new ArrayList<>();
        Location location = new Location(LocationManager.GPS_PROVIDER);
        location.setLatitude(0.00);
        location.setLongitude(0.00);
        alertas.add(new Alertas(1,mascotas.get(0),location,2));
        moduloPrincipal modulo = new moduloPrincipal(alertas, usuarios, mascotas);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al simulador de Lost My Doggo\n Esto es básicamente una muestra del funcionamiento del programa antes del lanzamiento en PLay Store \n Dado que la naturaleza del programa requiere el estricto uso de un smartphone con GPS y pantalla táctil, rogamos que comprenda la necesidad de limitar las opciones de esta versión");
        System.out.println("Para empezar ingrese un nuevo usuario: \n Usuario: ");
        String userName = scanner.nextLine();
        System.out.println("contrasena:");
        String password = scanner.nextLine();
        System.out.println("número de teléfono:");
        int phone = scanner.nextInt();
        Usuario usuario = new Usuario(1,userName,password,phone);
        modulo.agregarUsuario(usuario);
        System.out.println("Usuario nuevo creado!");
        System.out.println("Ahora acceda desde un usuario registrado. Puede ser el usuario que acaba de crear o el usuario demo:" +
                "\n usuario: JuanitoPerez123 contraseña: piñaconCoco\n ingrese el usuario: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();

        int idUsuario;
        int indiceUsuario = 0;
        boolean valid = false;
        while(!valid) {
            if (modulo.login(nombre, contrasena) != -1) {
                indiceUsuario = modulo.login(nombre, contrasena);
                idUsuario = modulo.getUsuarios().get(modulo.login(nombre, contrasena)).getId();
                valid = true;
            } else {
                System.out.println("EL USUARIO O LA CONTRASEÑA SON INCORRECTOS");
                System.out.println("Ingrese el nombre de usuario:");
                nombre = scanner.nextLine();
                System.out.println("Ingrese la contraseña: ");
                contrasena = scanner.nextLine();
            }
        }

        System.out.println("Elija una de sus opciones:\n 1.Ver alertas 2.Poner una alerta");
        int r = scanner.nextInt();
        if(r==1){
            ArrayList<Alertas> alertasCercanas = modulo.filtrarAlertas(location);
        }else if(r==2){
            System.out.println("Primero ingrese los datos sobre su mascota perdida: \n Nombre: ");
            String name = scanner.nextLine();
            System.out.println("descripcion: ");
            String desc = scanner.nextLine();
            System.out.println("color: ");
            String color = scanner.nextLine();
            System.out.println("Ingrese el rango de búsqueda: ");
            int range = scanner.nextInt();
            modulo.nuevaAlerta(new Alertas(2,new Mascota(2,name,desc,color,null,modulo.getUsuarios().get(indiceUsuario)),location,range));
        }else{
            System.out.println("La instrucción no es válida");
        }
    }
}
