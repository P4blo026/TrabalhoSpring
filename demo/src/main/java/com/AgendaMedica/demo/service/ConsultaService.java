package com.AgendaMedica.demo.service;

import com.AgendaMedica.demo.model.Consulta;
import com.AgendaMedica.demo.model.Usuario;
import com.AgendaMedica.demo.repository.ConsultaRepository;
import com.AgendaMedica.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.CallSite;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Consulta agendarConsulta(Long medicoId, Long pacienteId, LocalDateTime data) {
        Usuario medico = usuarioRepository.findById(medicoId).orElseThrow(() -> new RuntimeException("Médico não encontrado em nosso sistema!"));
        Usuario paciente = usuarioRepository.findById(pacienteId).orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));

        Consulta consulta = new Consulta();
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setDataConsulta(data);
        consulta.setStatus("Agendada!");

        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultasPorMedico(Long medicoId) {
        return consultaRepository.findByMedicoId(medicoId);
    }

    public List<Consulta> listarConsultaPorPaciente(Long pacienteId) {
        return consultaRepository.findByPacienteId(pacienteId);
    }
}

