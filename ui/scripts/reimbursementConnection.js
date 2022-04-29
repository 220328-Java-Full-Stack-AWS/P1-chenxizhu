
//let reimbursementResourceURL = "http://localhost:port/contextpath/resourcepath"; //CHANGE ME!\
//Example backend location:
let reimbursementResourceURL = "http://localhost:8080/ERS/reimbursement";
//Note the context path is set to "/api" make sure to change that in the build config


let newReimbursement = {

    firstname: firstname,
    lastname: lastname,
    reimbursementAmount: amount,
    details: details,
    email: email,
    date: date,
    username: username

}

async function createReimbursement(newReimbursement) {
    let response = await fetch(
        reimbursementResourceURL,
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                /*
                "username": newReimbursement.username,
                "firstname": newReimbursement.firstName,
                "lastname": newReimbursement.lastName,
                "email": newReimbursement.email,
                "reimbursementAmount": newReimbursement.reimbursementAmount,
                "details": newReimbursement.details,
                "date": newReimbursement.date,
                */
            },
            body: JSON.stringify(newReimbursement)
        }
    );

    return response;
}

async function getReimbursement(id) {
    let response = await fetch(
        reimbursementResourceURL,
        {
            method: "GET",
            headers: {
                reimbursementId: id
            }
        }
    );

    return response;
}

async function updateReimbursement(reimbursement) {
    let response = await fetch(
        reimbursementResourceURL,
        {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(reimbursement)
        }
    );

    return response;
}

async function deleteReimbursement(reimbursement) {
    let response = await fetch(
        reimbursementResourceURL,
        {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reimbursement)
        }
    );

    return response;
}