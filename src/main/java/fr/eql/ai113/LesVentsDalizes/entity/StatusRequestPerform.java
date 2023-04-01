package fr.eql.ai113.LesVentsDalizes.entity;

import javax.persistence.Entity;


public enum StatusRequestPerform {
    EN_ATTENTE_DE_TRAITEMENT,
    EN_COURS_DE_TRAITEMENT,
    VALIDE,

    REFUSE,

    TERMINE
}
