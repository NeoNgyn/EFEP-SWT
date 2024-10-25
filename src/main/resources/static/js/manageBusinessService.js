//Create new service item when click Create New
document.addEventListener("DOMContentLoaded", function() {
    // Function to get the URL parameter
    function getUrlParameter(name) {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get(name);
    }

    const newService = getUrlParameter('newService');
    const createBtn = document.querySelector('.business-service__create-btn');
    const newServiceRow = document.querySelector('.table__body-item-new');

    // Automatically show the new service row if the URL contains newService=true
    if (newService === 'true' && newServiceRow) {
        newServiceRow.style.display = 'table-row'; // Show the row
    }


    if (createBtn && newServiceRow) {
        createBtn.addEventListener('click', function() {
            if (newServiceRow.style.display === 'none' || newServiceRow.style.display === '') {
                newServiceRow.style.display = 'table-row';
            } else {
                newServiceRow.style.display = 'none';
            }
        });
    } else {
        console.error('Create button or new service row not found.');
    }
});


// Click edit to edit the business service content
function editRow(button) {
    var row = button.closest('tr');
    
    var nameText = row.querySelector('.name-text');
    var nameInput = row.querySelector('.name-input');
    
    var descText = row.querySelector('.desc-text');
    var descInput = row.querySelector('.desc-input');
    
    var priceText = row.querySelector('.price-text');
    var priceInput = row.querySelector('.price-input');
    
    var editBtn = row.querySelector('.edit-btn');
    var pencilIcon = row.querySelector('.modify-icon');
    var saveBtn = row.querySelector('.save-btn');
    var toggleBtn = row.querySelector('.toggle-btn');
    
    nameText.style.display = 'none';
    nameInput.style.display = 'inline-block';
    
    descText.style.display = 'none';
    descInput.style.display = 'inline-block';
    
    priceText.style.display = 'none';
    priceInput.style.display = 'inline-block';
    
    editBtn.style.display = 'none';
    pencilIcon.style.display = 'none';
    toggleBtn.style.display = 'none';
    
    saveBtn.style.display = 'inline-block';
}


