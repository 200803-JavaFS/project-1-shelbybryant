const url = "http://localhost:8080/project1/"

document.getElementById("loginbtn").addEventListener("click", loginFunc);
console.log("javascript loaded...");
console.log(document.getElementById("loginbtn"));
console.log("username field value:", document.getElementById("username"))

async function loginFunc() {
    console.log("login function started..");
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    console.log("username:", username)
    console.log("password:", password)

    let user = {
        username: username,
        password: password
    }

    try {
        let resp = await fetch(url + "login", {
            method: "POST",
            body: JSON.stringify(user),
            credentials: "include"
        });
        console.log("server login response:", resp);
        if (resp.status === 200) {
            document.getElementById("login-row").innerText = "You have successfully logged in! YAY!";
            //Send user to homepage
            window.location = 'homePage.html';
        } else {
            document.getElementById("login-row").innerText = `Server Error. Responded with ${res.status} code.`;
        }
    } catch (e) {
        console.log("\nFetch error:", e);
        document.getElementById("login-row").innerText = "Unexpected Server Error. Your login failed. Bummer."
    }




}
