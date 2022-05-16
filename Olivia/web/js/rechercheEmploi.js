function rechercheNomPoste(){
    let input, motFiltre, table, tr, td, txtValue;
    
    //initialisation
    input = document.getElementById("myInput");
    motFiltre = input.value.toUpperCase();
    table = document.getElementById('myTable');
    tr = table.getElementsByTagName("tr");
    
    for (let i = 0; i < tr.length; i++ ){
        td = tr[i].getElementsByTagName("td")[0]; 
        if(td){
            txtValue = td.textContent || td.innerText;
            if ( txtValue.toUpperCase().indexOf(motFiltre) > -1){
                tr[i].style.display = "";
            }
            else {
                tr[i].style.display = "none";
            }
        }
    }  
}
function rechercheEntreprise(){
    let input, motFiltre, table, tr, td, txtValue;
    
    //initialisation
    input = document.getElementById("myInput2");
    motFiltre = input.value.toUpperCase();
    table = document.getElementById('myTable');
    tr = table.getElementsByTagName("tr");
    
    for (let i = 0; i < tr.length; i++ ){
        td = tr[i].getElementsByTagName("td")[3]; 
        if(td){
            txtValue = td.textContent || td.innerText;
            if ( txtValue.toUpperCase().indexOf(motFiltre) > -1){
                tr[i].style.display = "";
            }
            else {
                tr[i].style.display = "none";
            }
        }
    }  
}




