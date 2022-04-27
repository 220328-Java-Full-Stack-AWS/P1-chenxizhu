
//let reimbursementResourceURL = "http://localhost:port/contextpath/resourcepath"; //CHANGE ME!\
//Example backend location:
let reimbursementResourceURL = "http://localhost:8080/ERS/reimbursement";
//Note the context path is set to "/api" make sure to change that in the build config


let newReimbursement = {
    username: username,
    firstName: firstname,
    lastName: lastname,
    email: email,
    amount: reimbursementAmount,
    detail: details,
    date: date
}

async function createReimbursement(newReimbursement) {
    let response = await fetch(
        reimbursementResourceURL,
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json",






                "date": newReimbursement.date,
                "detail": newReimbursement.detail,
                "amount": newReimbursement.amount,
                "email": newReimbursement.email,
                "lastname": newReimbursement.lastName,
                "firstname": newReimbursement.firstName,
                "username": newReimbursement.username,
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