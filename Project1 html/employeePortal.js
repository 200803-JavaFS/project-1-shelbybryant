const url = "http://localhost:8080/project1/"

document.getElementById("addbtn").addEventListener("click", addReimbFunc);


async function addReimbFunc() {
    let reimbAmount = document.getElementById("reimbAmount").value;
    let reimbType = document.getElementById("reimbType").value;
    let reimbDesc = document.getElementById("reimbDesc").value;
    let reimbAuthor = document.getElementById("reimbAuthor").value;

    let ticket = {
        reimbAmount,
        reimbType,
        reimbDesc,
        reimbAuthor
    }

    console.log(ticket)

    let resp = await fetch(url + "ticket", {
        method: "POST",
        body: JSON.stringify(ticket), 
        credentials: "include"    
    })

    if (resp.status === 201) {
       document.getElementById("adding-row").innerText = "The ticket was made! Please wait for approval!";
    } else {
        document.getElementById("adding-row").innerText = "The ticket could not be made. Shucks.";
    }

}

