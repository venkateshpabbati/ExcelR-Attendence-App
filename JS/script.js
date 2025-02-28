function validateForm() {
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let dob = document.getElementById("dob").value;
    let phone = document.getElementById("phone").value;
    let address = document.getElementById("address").value;

    if (firstName.trim() === "" || lastName.trim() === "") {
        alert("First and Last Name are required");
        return false;
    }
    
    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address");
        return false;
    }

    if (!dob) {
        alert("Please select your Date of Birth");
        return false;
    }
    
    let phonePattern = /^[0-9]{10}$/;
    if (!phonePattern.test(phone)) {
        alert("Please enter a valid 10-digit phone number");
        return false;
    }

    if (address.trim() === "") {
        alert("Address cannot be empty");
        return false;
    }
    
    alert("Registration successful!");
    return true;
}
