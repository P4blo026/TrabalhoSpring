package com.AgendaMedica.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario medico;

    @ManyToOne
    private Usuario paciente;

    private LocalDataTime dataconsulta;

    private String status;
}
