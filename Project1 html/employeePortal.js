const url = "http://localhost:8080/project1/";

document.getElementById("addbtn").addEventListener("click", addReimbFunc);
document.getElementById("findbtn").addEventListener("click", findReimbFunc);


async function addReimbFunc() {
    let reimbAmount = document.getElementById("reimbAmount").value;
    let reimbType = document.getElementById("reimbType").value;
    let reimbDescription = document.getElementById("reimbDesc").value;
    let reimbAuthorId = document.getElementById("reimbAuthor").value;

    console.log("reimbursement amount: ", reimbAmount);
    console.log("reimbursement type: ", reimbType);
    console.log("reimbursement description: ", reimbDescription);
    console.log("reimbursement author: ", reimbAuthorId);

    let ticket = {
        reimbAmount,
        reimbType,
        reimbDescription,
        reimbAuthorId
    }

    console.log(ticket)

    try {
        let resp = await fetch(url + "ticket", {
            method: "POST",
            body: JSON.stringify(ticket),
            credentials: "include"
        })
        console.log(resp);
        if (resp.status === 201) {
            document.getElementById("adding-row").innerText = "The ticket was made! Please wait for approval!";
        } else {
            document.getElementById("login-row").innerText = `Server Error. Responded with ${resp.status} code.`;
        }

    } catch (e) {
        console.log("\nFetch error:", e);
        document.getElementById("login-row").innerText = "Unexpected Server Error. Your login failed. Bummer."
    }


}

async function findReimbFunc() {
    console.log("finding a users reibursements function has started...")
    let userId = document.getElementById("userId").value;

    console.log("user id is: ", userId);


    try {
        let resp = await fetch(url + `author/${userId}`, {
            credentials: "include"
        });

        if (resp.status === 200) {
            const data = await resp.json();
            console.log('\n\nfind all:', data);
            addDataToTable(data);

        } else {
        }
    } catch (error) {
        console.log("\nFetch error:", error);
    }
}

function addDataToTable(data) {
    try {
        //Get table body
        const oldTableBody = document.getElementById("tableBody");
        
        //Create new body
        const newTableBody = document.createElement("tbody");
        newTableBody.setAttribute("id", 'tableBody');
        //Replace new table body with 
        oldTableBody.parentNode.replaceChild(newTableBody, oldTableBody);

        //Iterate data array
        for (let i = 0; i < data.length; i++) {
            //Get current record
            let record = data[i];

            //For each element in the array..
            //Create a row
            const row = document.createElement("tr");

            //And then create a cell <td> for each property
            const idCell = document.createElement("td");
            idCell.innerHTML = record.reimbId;
            row.appendChild(idCell);

            const amountCell = document.createElement("td");
            amountCell.innerHTML = record.reimbAmount;
            row.appendChild(amountCell);

            const descCell = document.createElement("td");
            descCell.innerHTML = record.reimbDescription;
            row.appendChild(descCell);

            const userCell = document.createElement("td");
            if (record.reimbAuthorId) {
                userCell.innerHTML = record.reimbAuthorId.userId;
            }
            row.appendChild(userCell);

            const reimbResolverIdCell = document.createElement("td");
            if (record.reimbResolverId) {
                reimbResolverIdCell.innerHTML = record.reimbResolverId.userId;
            }
            row.appendChild(reimbResolverIdCell);

            const submittedCell = document.createElement("td");
            submittedCell.innerHTML = record.reimbSubmitted;
            row.appendChild(submittedCell);

            const resolvedCell = document.createElement("td");
            resolvedCell.innerHTML = record.reimbResolved;
            row.appendChild(resolvedCell);

            const statusCell = document.createElement("td");
            statusCell.innerHTML = record.reimbStatus.reimbStatus;
            row.appendChild(statusCell);

            const typeCell = document.createElement("td");
            typeCell.innerHTML = record.reimbType.reimbType;
            row.appendChild(typeCell);

            document.getElementById('tableBody').appendChild(row);
        }

    } catch (e) {
        console.log('\n\nTABLE ERROR:', e);
    }
}
