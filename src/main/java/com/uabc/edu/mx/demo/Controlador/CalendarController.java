package com.uabc.edu.mx.demo.Controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uabc.edu.mx.demo.Modelo.Paciente;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/event")
public class CalendarController {


    @GetMapping(value = "/all")
    public String getEvents(@ModelAttribute Paciente paciente, RedirectAttributes attributes) {
        String jsonMsg = null;
        try {
            //Crear objeto para asignar los atributos y crear la nueva cita en el calendario
            List<Paciente> events = new ArrayList<Paciente>();
            Paciente cita1 = new Paciente();
            cita1.setNombre("Jorge");
            cita1.setTitle("Paciente: Jorge \n"+ "Asunto: Dolor de cabeza \n"+"Hora: 3:30");
            cita1.setHora("3:40");
            cita1.setStart("2019-03-14");
            cita1.setEnd("2019-03-15");
            cita1.setMedico("Saul Martinez García");
            events.add(cita1);

            // FullCalendar
            ObjectMapper mapper = new ObjectMapper();
            jsonMsg =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(events);
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        return jsonMsg;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

    }

}
