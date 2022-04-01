"use strict";

const FORM = document.getElementById("formulaire-connexion");
const MDP = document.getElementById("mdp");
const NUMDA = document.getElementById("numDA");

FORM.addEventListener("submit", (e) => {
    e.preventDefault();

    verificationEntrees();
});

function verificationEntrees() {
    // prendre les valeurs des entrees
    const valeurMdp = MDP.value.trim();
    const valeurNumDA = NUMDA.value.trim();

    if (valeurMdp === '') {
        setErrorFor(MDP, "Le mot de passe ne peut pas être vide.");
    } else {
        setSuccessFor(MDP);
    }


    if (valeurNumDA === '') {
        setErrorFor(NUMDA, "Le numéro DA ne peut pas être vide.");
    } else if (!checkForNums(valeurNumDA)) {
        setErrorFor(NUMDA, "Le numéro DA n'est pas valide.");
    } else if (valeurNumDA.length != 7){
        setErrorFor(NUMDA,"Le numéro DA n'est pas valide.")
    } else {
        setSuccessFor(NUMDA);
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

// Teste si le string contient seulement des chiffres entre 0 et 9
function checkForNums(input) {
    let result = /^\d+$/.test(input);
    return result;
}

