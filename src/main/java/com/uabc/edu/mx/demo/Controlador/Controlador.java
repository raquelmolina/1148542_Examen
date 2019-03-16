package com.uabc.edu.mx.demo.Controlador;

import com.uabc.edu.mx.demo.Modelo.Cubiculo;
import com.uabc.edu.mx.demo.Modelo.Medico;
import com.uabc.edu.mx.demo.Modelo.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Controlador {
    //Controlador que llama la pagina principal
    @GetMapping("/")
    public String home(){
        return "principal";
    }

    //Controlador de pagina de citas
    @GetMapping("/pacientes")
    public String List (Model modelo, @ModelAttribute Paciente paciente){
        //Creacion del objeto
        Medico medico1 = new Medico();
        Medico medico2 = new Medico();
        Medico medico3 = new Medico();
        Medico medico4 = new Medico();
        List<Medico> med = new ArrayList<Medico>();

        //Asginacion de los atributos
        medico1.setNombre("Juan");
        medico1.setApellido("Perez Meza");
        medico1.setTipo("Dr.");
        medico2.setNombre("Daniel");
        medico2.setApellido("Lares Almanza");
        medico2.setTipo("Dr.");
        medico3.setNombre("Manuel");
        medico3.setApellido("Arvizú Iglesias");
        medico3.setTipo("Dr.");
        medico4.setNombre("Saúl");
        medico4.setApellido("Martínez García");
        medico4.setTipo("Dr.");

        //Creacion de los objetos
        Cubiculo cub = new Cubiculo();
        Cubiculo cub2 = new Cubiculo();
        Cubiculo cub3 = new Cubiculo();
        List<Cubiculo> c = new ArrayList<Cubiculo>();

        //Asignacion de los atributos
        cub.setCubo("A");
        cub.setCubo("B");
        cub.setCubo("C");

        System.out.println(paciente.toString() + "objeto");
        return "paciente";
    }

    //controlador de datos del formulario
    @PostMapping("/add")
    public String add(@ModelAttribute Paciente paciente, RedirectAttributes attributes){
        //Recibe los datos, pero no los envía al controler de Calendario
        return "cal";
    }

    @GetMapping("/cal")
    public  String calendario(){
        return("cal");
    }

}
