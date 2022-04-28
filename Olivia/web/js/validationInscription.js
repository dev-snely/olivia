"use strict";

const FORM = document.getElementById("formulaire-inscription");
const NOM = document.getElementById("nom");
const PRENOM = document.getElementById("prenom");
const MDP = document.getElementById("mdp");
const MDP2 = document.getElementById("mdp2");
const NUMDA = document.getElementById("numDA");
const COURRIEL = document.getElementById("courriel");

FORM.addEventListener("submit", (e) => {
    e.preventDefault();

    if (verificationEntrees() === true) {
        FORM.submit();
    }
});

function verificationEntrees() {
    
    let isValid = false;
        
    // prendre les valeurs des entrees
    const valeurNom = NOM.value.trim();
    const valeurPrenom = PRENOM.value.trim();
    const valeurMdp = MDP.value.trim();
    const valeurMdp2 = MDP2.value.trim();
    const valeurNumDA = NUMDA.value.trim();
    const valeurCourriel = COURRIEL.value.trim();

    if (valeurNom === '') {
        //Montrer error class
        setErrorFor(NOM, "Le nom ne peut pas être vide.");
    } else {
        setSuccessFor(NOM);
    }

    if (valeurPrenom === '') {
        //Montrer error class
        setErrorFor(PRENOM, "Le prénom ne peut pas être vide.");
    } else {
        setSuccessFor(PRENOM);
    }

    if (valeurMdp === '') {
        setErrorFor(MDP, "Le mot de passe ne peut pas être vide.");
    } else if (valeurMdp.length < 6) {
        setErrorFor(MDP, "Attention: Insérer une minuscule, une majuscule, un chiffre et un minimum de 6 caractères.");
    } else if (valeurMdp.search(/[a-z]/) < 0) {
        setErrorFor(MDP, "Attention: Insérer une minuscule, une majuscule, un chiffre et un minimum de 6 caractères.");
    } else if (valeurMdp.search(/[A-Z]/) < 0) {
        setErrorFor(MDP, "Attention: Le mot de passe doit contenir une minuscule, une majuscule, un chiffre et un minimum de 6 caractères.");
    } else if (valeurMdp.search(/[0-9]/) < 0) {
        setErrorFor(MDP, "Attention: Le mot de passe doit contenir une minuscule, une majuscule, un chiffre et un minimum de 6 caractères.");
    } else {
        setSuccessFor(MDP);
    }

    if (valeurMdp2 === '') {
        setErrorFor(MDP2, "La confirmation ne peut pas être vide.");
    } else if (valeurMdp2 !== valeurMdp) {
        setErrorFor(MDP2, "Vos mots de passe ne correspondent pas.");
    } else {
        setSuccessFor(MDP2);
    }

    if (valeurNumDA === '') {
        setErrorFor(NUMDA, "La numéro DA ne peut pas être vide.");
    } else if (!checkForNums(valeurNumDA)) {
        setErrorFor(NUMDA, "La numéro DA ne contient que des chiffres.");
    } else if (valeurNumDA.length !== 7){
        setErrorFor(NUMDA,"Le numéro DA doit contenir 7 chiffres.");
    } else {
        setSuccessFor(NUMDA);
    }

    if (valeurCourriel === '') {
        setErrorFor(COURRIEL, "Cet adresse courriel est vide.");
    } else if (!isCourriel(valeurCourriel)) {
        setErrorFor(COURRIEL, "Cet adresse courriel n'est pas valide.");
    } else {
        setSuccessFor(COURRIEL);
    }
    
    if (!(valeurNom === '') &&
            !(valeurPrenom ==='') &&
            !(valeurMdp === '') &&
            !(valeurMdp.length < 6) &&
            !(valeurMdp.search(/[a-z]/) < 0) &&
            !(valeurMdp.search(/[A-Z]/) < 0) &&
            !(valeurMdp.search(/[0-9]/) < 0) && 
            !(valeurCourriel === '') &&
            !(!isCourriel(valeurCourriel)) &&
            !(valeurNumDA === '') &&
            !(!checkForNums(valeurNumDA)) &&
            !(valeurNumDA.length !== 7) &&
            !(valeurMdp2 === '') &&
            !(valeurMdp2 !== valeurMdp)) {

        isValid = true;
    } 
    
    return isValid;
}

function setErrorFor(input, message) {
    const ctrlForm = input.parentElement.parentElement;
    const small = ctrlForm.querySelector('small');

    //ajout du message d'erreur 
    small.innerText = message;

    //ajout de la classe js-error
    ctrlForm.className = 'controle-formulaire js-error';
}

function setSuccessFor(input) {
    const ctrlForm = input.parentElement.parentElement;
    ctrlForm.className = 'controle-formulaire js-success';
}

function isCourriel(courriel) {
    return /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(courriel);
}

// Teste si le string contient seulement des chiffres entre 0 et 9
function checkForNums(input) {
    let result = /^\d+$/.test(input);
    return result;
}

