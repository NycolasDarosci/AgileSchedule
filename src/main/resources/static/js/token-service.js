
// fazer uma logica em que o usuário, ao colocar o token em um input
// e apertar um botão, as informações da Alura aparecem na view
const tokenAlura = document.getElementById('tokenAlura')

const url = `https://www.alura.com.br/api/dashboard/${tokenAlura}`

const lista = document.getElementById('lista')

const listarInformacoes = () => {
    // fetch fornece uma interface JavaScript para acessar e manipular partes do pipeline HTTP, tais como os pedidos e respostas.
    return fetch(url).then(response => {
        return response.json()
    })
}

// quando essa promessa for completa, então (then) faça o seguinte passo 
listarInformacoes().then(dados =>{

    console.log(dados)
    
    let li = document.createElement('div')

    dados = dados??[]

    let items = []
    items.push(
        `<table>
            <thead>
                <tr>
                    <th>Slug</th>
                    <th>Finalizado</th>
                    <th>Nome</th>
                    <th>Último acesso</th>
                    <th>Id</th>
                    <th>Progresso</th>
                    <th>Pronto para terminar</th>
                </tr>
            </thead>
        <tbody>`)

    dados.courseProgresses.forEach(x=>{
        items.push(`<tr>`)
        items.push(`<td style='border: 1px solid'>${x.slug}</td>`)
        items.push(`<td style='border: 1px solid'>${x.finished}</td>`)
        items.push(`<td style='border: 1px solid'>${x.name}</td>`)
        items.push(`<td style='border: 1px solid'>${x.lastAccessTime.getVal}</td>`)
        items.push(`<td  style='border: 1px solid'>${x.id}</td>`)
        items.push(`<td style='border: 1px solid'>${x.progress}</td>`)
        items.push(`<td style='border: 1px solid'>${x.readyToFinish}</td>`)
        items.push(`</tr>`)
    })

    items.push(`    </tbody>
                </table>`)

    li.innerHTML = `${items.join('')}`
    lista.appendChild(li)

});