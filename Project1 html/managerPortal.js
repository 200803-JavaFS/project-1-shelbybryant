const url = "http://localhost:8080/project1/";

document.getElementById("findByStatusBtn").addEventListener("click", findReimbByStatusFunc);
document.getElementById("findAllBtn").addEventListener("click", findAllReimbFunc);
document.getElementById("updateStatusBtn").addEventListener("click", updateStatusFunc);

async function findReimbByStatusFunc() {
    console.log("finding a reimbursements by status function has started...")
    let statusId = document.getElementById("statusId").value;

    console.log("status id is: ", statusId);


    try {
        let resp = await fetch(url + `filter/${statusId}`, {
            credentials: "include"
        });

        console.log("\n\nBY STATUS CODE:", resp.status);

        if (resp.status === 200) {
            const data = await resp.json();

            console.log("\n\nBy status:", data);

            addDataToTable(data);

        } else {
            resetTable();
        }
    } catch (error) {
        console.log("\nFetch error:", error);
    }
}

function resetTable() {
    //Get table body
    const oldTableBody = document.getElementById("tableBody");

    //Create new body
    const newTableBody = document.createElement("tbody");
    newTableBody.setAttribute("id", 'tableBody');
    //Replace new table body with 
    oldTableBody.parentNode.replaceChild(newTableBody, oldTableBody);
}

function addDataToTable(data) {
    console.log("adding data to the table function has started....");
    try {
        //Reset table body
        resetTable();

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
            userCell.innerHTML = record.reimbAuthorId.userId;
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

async function findAllReimbFunc() {
    console.log("in finding all reimbursements function...");

    try {
        let resp = await fetch(url + "filter", {
            credentials: "include"
        });

        if (resp.status === 200) {
            const data = await resp.json();

            addDataToTable(data);

        } else {

        }

    } catch (e) {
        console.log('\n\nFETCH ERROR:', e);
    }
}

async function updateStatusFunc() {
    let reimbId = document.getElementById("reimbIdInput").value;
    let status = document.getElementById("statusSelect").value;
    let reimbResolverId = document.getElementById("resolverIdInput").value;

    console.log("dropdown status:", status);


    let body = {
        id: reimbId,
        reimbStatus: status,
        reimbResolverId
    };
    console.log("body:", body)
    try {
        let resp = await fetch(url + "status", {
            method: "POST",
            body: JSON.stringify(body),
            credentials: "include"
        });
        console.log("\n\nResponse:", resp);
        console.log("STATUS CODE: ", resp.status);
        if (resp.status === 202) {
            document.getElementById("responseMessage").innerHTML = "The reimbursement update was successful!";
        } else {
            document.getElementById("responseMessage").innerHTML = "The reimbursement update did not work."
        }
    } catch (e) {
        console.log('\n\nFETCH ERROR:', e);
    }

}
