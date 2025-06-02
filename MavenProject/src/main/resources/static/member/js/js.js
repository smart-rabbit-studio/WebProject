function allMemberSearch(){
    const printAllArea = document.getElementById('printAllArea');

    fetch('/member/findAll')
        .then(response => {
            if(!response) console.log("에러");
            return response.json();
        })
        .then(data => {
            printAllArea.innerHTML = '';

            data.forEach(member => {
                printAllArea.innerHTML += `
                <tr><td id="printId">${member.id}</td><td id="printName">${member.name}</td></tr>`
            })
        })
        .catch(error => {
            console.log(error);
        })
}

function printAreaSetting(id = null, name=null){
    const printArea = document.getElementById('printArea');

    if(id || name)
        printArea.innerHTML += `
                    <tr><td id="printId">${id}</td><td id="printName">${name}</td></tr>`;
    else
        printArea.innerHTML +=  `
                    <tr><td id="printId">nothing</td><td id="printName">nothing</td></tr>`;
}

function fetchMemberById(id){
    fetch(`/member/find/${id}`)
        .then(response => {
            if(!response) console.log("에러");
            return response.json();
        })
        .then(data => {
            console.log(data);
            if(!data)
                printAreaSetting();
            else
                printAreaSetting(data.id, data.name);
        })
        .catch(error => {
            console.log(error);
        })
}

function fetchMemberByName(name){
    fetch(`/member/find?name=${encodeURIComponent(name)}`)
        .then(response => {
            if(!response) console.log("에러");
            return response.json();
        })
        .then(data => {
            console.log(data);
            if(!data)
                printAreaSetting();
            else
                printAreaSetting(data.id, data.name);
        })
        .catch(error => {
            console.log(error);
        })
}

document.addEventListener("DOMContentLoaded",  () => {
    const memberForm = document.getElementById('memberForm');
    const searchBtn = document.getElementById('searchBtn');
    const searchAllBtn = document.getElementById('searchAllBtn');

    memberForm.addEventListener("submit", (e) => {
        e.preventDefault();

        const name = document.getElementById('name').value;

        fetch("/member/save", {
            method: "POST",
            headers: {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify({
                name : name
            })
        })
            .then(response => {
                if(!response) console.log("에러");
                return response.json();
            })
            .catch(error => {
                console.log(error);
            })
    });

    searchBtn.addEventListener("click", (e) => {
        e.preventDefault();

        const searchId = document.getElementById('searchId').value;
        const searchName = document.getElementById('searchName').value;

        if(searchId)
            fetchMemberById(searchId);
        else if(searchName)
            fetchMemberByName(searchName);
        else
            printAreaSetting();
    })

    searchAllBtn.addEventListener("click", (e) => {
        e.preventDefault();

        if(searchId)
            allMemberSearch();
    })
})