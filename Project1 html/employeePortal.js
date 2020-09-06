const url = "http://localhost:8080/project1/";

document.getElementById("addbtn").addEventListener("click", addReimbFunc);
document.getElementById("findbtn").addEventListener("click", findReimbFunch);


async function addReimbFunc() {
    let reimbAmount = document.getElementById("reimbAmount").value;
    let reimbType = document.getElementById("reimbType").value;
    let reimbDesc = document.getElementById("reimbDesc").value;
    let reimbAuthor = document.getElementById("reimbAuthor").value;

    console.log("reimbursement amount: ", reimbAmount);
    console.log("reimbursement type: ", reimbType);
    console.log("reimbursement description: ", reimbDesc);
    console.log("reimbursement author: ", reimbAuthor);

    let ticket = {
        reimbAmount,
        reimbType,
        reimbDesc,
        reimbAuthor
    }

    console.log(ticket)

    try {
        let resp = await fetch(url + "ticket", {
            method: "POST",
            body: JSON.stringify(ticket),
            credentials: "include"
        })

        if (resp.status === 201) {
            console.log(resp);
            document.getElementById("adding-row").innerText = "The ticket was made! Please wait for approval!";
        } else {
            document.getElementById("login-row").innerText = `Server Error. Responded with ${res.status} code.`;
        }

    } catch (e) {
        console.log("\nFetch error:", e);
        document.getElementById("login-row").innerText = "Unexpected Server Error. Your login failed. Bummer."
    }


}

async function findReimbFunch() {
    console.log("finding a users reibursements function has started...")
    let userId = document.getElementById("userId").value;

    console.log("user id is: ", userId);


    try {
        let resp = await fetch(url + `author/${userId}`, {
            credentials: "include"
        });

        if (resp.status === 200) {
            const data = await resp.json();

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
        //Clear the current the data in the table body
        // tableBody.remove();
        
        
        //Create new body
        const newTableBody = document.createElement("tbody");
        newTableBody.setAttribute("id", 'tableBody');
        //Replace new table body with 
        oldTableBody.parentNode.replaceChild(newTableBody, oldTableBody);

        //Iterate data array
        for (let i = 0; i < data.length; i++) {
            let record = data[i];
            //For each element in the array..
            //Create a row
            const row = document.createElement("tr");

            //And then create a cell <td> for each property
            const rowNumberCell = document.createElement("td");
            rowNumberCell.innerHTML = i + 1;
            row.appendChild(rowNumberCell);

            const amountCell = document.createElement("td");
            amountCell.innerHTML = record.reimbAmount;
            row.appendChild(amountCell);

            const descCell = document.createElement("td");
            descCell.innerHTML = record.reimbDescription;
            row.appendChild(descCell);

            const userCell = document.createElement("td");
            userCell.innerHTML = record.reimbAuthorId.userId;
            row.appendChild(userCell);

            const reimbResolverIdCell = document.createElement("td");
            reimbResolverIdCell.innerHTML = record.reimbResolverId.userId;
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

            //Append each cell to row
            // row.appendChild(rowNumberCell).appendChild(amountCell).appendChild(descCell).appendChild(userCell).appendChild(reimbResolverIdCell)
            //     .appendChild(submittedCell).appendChild(resolvedCell).appendChild(statusCell).appendChild(typeCell);

            console.log("Row with tds:", row);
            document.getElementById('tableBody').appendChild(row);
        }

    } catch (e) {
        console.log('\n\nTABLE ERROR:', e);
    }
}
