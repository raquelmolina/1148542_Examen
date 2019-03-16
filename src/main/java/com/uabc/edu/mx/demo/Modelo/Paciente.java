package com.uabc.edu.mx.demo.Modelo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Paciente {

    @NotBlank
    @Size (min = 2, max = 40)
    private String nombre;

    private String medico;
    private String c;

    @NotBlank
    @Size (min = 2, max = 40)
    private String title;

    private String start;
    private String end;
    private String hora;


}
