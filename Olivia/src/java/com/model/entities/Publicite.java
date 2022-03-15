/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entities;

import java.util.Objects;

/**
 *
 * @author gabri
 */
public class Publicite {
    private int Id;
    private String contenu;
    private String imgLink;

    public Publicite() {
    }

    public Publicite(String contenu) {
        this.contenu = contenu;
    }

    public Publicite(String contenu, String imgLink) {
        this.contenu = contenu;
        this.imgLink = imgLink;
    }

    public int getId() {
        return Id;
    }

    public String getContenu() {
        return contenu;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.Id;
        hash = 79 * hash + Objects.hashCode(this.contenu);
        hash = 79 * hash + Objects.hashCode(this.imgLink);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publicite other = (Publicite) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        if (!Objects.equals(this.imgLink, other.imgLink)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publicite{" + "Id=" + Id + ", contenu=" + contenu + ", imgLink=" + imgLink + '}';
    }

    
}
