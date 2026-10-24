const url = "http://localhost:8080/usuario/6adbfdf860bb7be474278d74/tasks";

function hideLoader(){
    document.getElementById("loading").style.display = "none";
}

function show(tasks){
    let tab = `<thead>
                    <th scope="col">Description</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Usuario iD</th>
                </thead>`;

    for(let task of tasks){
        tab += `
                <tr>
                    <td>${task.description}</td>
                    <td>${task.title}</td>
                    <td>${task.id}</td>
                </tr>`;
    }

    document.getElementById("tasks").innerHTML = tab;
}

async function getTasksAPI(url){
    try{
        const response = await fetch(url, { method: "GET" });
        const data = await response.json();
        console.log(data);
        show(data);
    } catch (error) {
        console.error("Erro ao buscar tarefas:", error);
    } finally {
        hideLoader();
    }
}

getTasksAPI(url);