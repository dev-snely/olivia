"use strict";

const FORM = document.getElementById("formulaire-connexion");
const MDP = document.getElementById("mdp");
const COURRIEL = document.getElementById("courriel");

FORM.addEventListener("submit", (e) => {
    e.preventDefault();

    verificationEntrees();
});

function verificationEntrees() {
    // prendre les valeurs des entrees
    const valeurMdp = MDP.value.trim();
    const valeurCourriel = COURRIEL.value.trim();
    
    if (valeurCourriel === '') {
        setErrorFor(COURRIEL, "Cet adresse courriel est vide.");
    } else if (!isCourriel(valeurCourriel)) {
        setErrorFor(COURRIEL, "Cet adresse courriel n'est pas valide.");
    } else {
        setSuccessFor(COURRIEL);
    }

    if (valeurMdp === '') {
        setErrorFor(MDP, "Le mot de passe ne peut pas être vide.");
    } else {
        setSuccessFor(MDP);
    }

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

