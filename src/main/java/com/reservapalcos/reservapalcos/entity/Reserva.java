package com.reservapalcos.reservapalcos.entity;

import java.time.LocalDateTime;

import com.reservapalcos.reservapalcos.enums.DiasSemana;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="palco_id")
    private Palco palco;
    @Enumerated(EnumType.STRING)
    private DiasSemana dia;
    private Integer ano;
    @Column(nullable=true)
    private LocalDateTime fechaSalida;

    public Reserva() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Palco getPalco() {
        return palco;
    }
    public void setPalco(Palco palco) {
        this.palco = palco;
    }
    public DiasSemana getDia() {
        return dia;
    }
    public void setDia(DiasSemana dia) {
        this.dia = dia;
    }
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }    
    
    

}
