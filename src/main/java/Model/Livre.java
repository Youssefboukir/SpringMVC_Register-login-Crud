/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Livre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String auteur;
    private String titre;
    private String domaine;
    private String nb_exemplaire;
    private String date;

    public Livre() {
    }

    public Livre(int id) {
        this.id = id;
    }

    public Livre(String auteur, String titre, String domaine, String nb_exemplaire, String date) {
        this.auteur = auteur;
        this.titre = titre;
        this.domaine = domaine;
        this.nb_exemplaire = nb_exemplaire;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getNb_exemplaire() {
        return nb_exemplaire;
    }

    public void setNb_exemplaire(String nb_exemplaire) {
        this.nb_exemplaire = nb_exemplaire;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Livre{" + "id=" + id + ", auteur=" + auteur + ", titre=" + titre + ", domaine=" + domaine + ", nb_exemplaire=" + nb_exemplaire + ", date=" + date + '}';
    }

}
