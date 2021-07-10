const notificacao = () => {
    // cria-se uma variavel do tipo Date e pegar a data atual
    const date = new Date();

    // cria-se uma variavel do tipo Date e manipula-o
    const amanha = new Date()
    
    // pegar o dia de agora(getDate) e somar mais um, ou seja, o próximo dia
    // defini às horas como 12
    // defini os minutos como 30
    // defini os segundos como 0
    amanha.setDate(amanha.getDate() + 1) 
    amanha.setHours(12) 
    amanha.setMinutes(30) 
    amanha.setSeconds(0) 

    // pegando intervalo entre data atual e data de amanha e diminuindo 
    // irá devolver um valor em milisegundos, ou seja, quantos milisegundos 
    // são necessarios para que o tempo estipulado seja chamado
    const interval = amanha.getTime() - date.getTime()

    // quando o tempo estipulado for concluido, irá chamar esse método
    // que dispara um popup
    setTimeout(()=>{
        alert("!!! Bater ponto !!!")
    }, interval)

    // relógio
    let clock =() =>{
        const now = new Date()
        document.getElementById('clock').innerText = now.toLocaleDateString() + ' ' + now.toLocaleTimeString()
    }

    setInterval(clock, 1000);
}

// permissão para notificar
// tres possibilidades: default, granted e denied
if(Notification.permission === "granted"){
    notificacao();
  
}else if(Notification.permission !== "denied"){
    Notification.requestPermission().then(permission => {
        notificacao();
    })
}