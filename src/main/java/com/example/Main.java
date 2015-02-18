package com.example;

import com.example.models.Clinica;
import com.example.models.Doctor;
import com.example.models.Episodio;
import com.example.models.Paciente;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *
 * This class launches the web application in an embedded Jetty container. This
 * is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Clinica clinica = Clinica.darInstancia();

        Episodio ep1 = new Episodio(01, "01", "01", "2010", "13", "12", 12, "Frente", 2, 2, null, null, null);
        clinica.setPacientes(new Paciente("Paciente1", "ApellidoPaciente1", 01));
        Paciente pac1 = clinica.buscarPaciente(01);
        pac1.agregarEpisodio(ep1);

        Episodio ep2 = new Episodio(02, "01", "01", "2010", "13", "12", 12, "Frente", 2, 2, null, null, null);
        clinica.setPacientes(new Paciente("Paciente2", "ApellidoPaciente2", 02));
        Paciente pac2 = clinica.buscarPaciente(02);
        pac2.agregarEpisodio(ep2);

        Episodio ep3 = new Episodio(03, "01", "01", "2010", "13", "12", 12, "Frente", 2, 2, null, null, null);
        clinica.setPacientes(new Paciente("Paciente3", "ApellidoPaciente3", 03));
        Paciente pac3 = clinica.buscarPaciente(03);
        pac3.agregarEpisodio(ep3);

        clinica.setDoctor(new Doctor("Doctor1", "Apellido1", 11));
        clinica.buscarDoctor(11).agregarPaciente(pac1);

        clinica.setDoctor(new Doctor("Doctor2", "Apellido2", 12));
        clinica.buscarDoctor(12).agregarPaciente(pac2);

        clinica.setDoctor(new Doctor("Doctor3", "Apellido3", 13));
        clinica.buscarDoctor(13).agregarPaciente(pac3);

        String webappDirLocation = "src/main/webapp/";

        // The port that we should run on can be set into an environment variable
        // Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        Server server = new Server(Integer.valueOf(webPort));
        WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);

        // Parent loader priority is a class loader setting that Jetty accepts.
        // By default Jetty will behave like most web containers in that it will
        // allow your application to replace non-server libraries that are part of the
        // container. Setting parent loader priority to true changes this behavior.
        // Read more here: http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading
        root.setParentLoaderPriority(true);

        server.setHandler(root);

        server.start();
        server.join();
    }

}
