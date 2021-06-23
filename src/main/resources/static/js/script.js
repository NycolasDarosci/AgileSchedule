// devolve a data atual no horário de Brásilia
const date = new Date();

const renderCalendar = () => {
    date.setDate(1);


    const monthDays = document.querySelector('.days');

    // pegando o último dia do mês
    const lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();

    const prevLastDay = new Date(date.getFullYear(), date.getMonth(), 0).getDate();

    const firstDayIndex = date.getDay();

    const lastDayIndex = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDay();

    const nextDays = 7 - lastDayIndex - 1;

    // criando um array de meses para manipular
    const months = [
    
        "Janeiro", //0
        "Fevereiro", //1
        "Março", //2
        "Abril", //3
        "Maio", //4
        "Junho", //5
        "Julho", //6
        "Agosto", //7
        "Setembro", //8
        "Outubro", //9
        "Novembro", //10
        "Dezembro", //11
    ]

    // escolhendo a classe date tag h1 e atribuindo o valor
    // months[date.getMonth()] para colocá-lo no html
    // com o arary 
    document.querySelector('.date h1').innerHTML = months[date.getMonth()];
    // aplicando a data atual na tag p da classe date
    document.querySelector('.date p').innerHTML = new Date().toDateString();

    let days = "";

    for (let x = firstDayIndex; x > 0; x--) {
        days += `<div class="prev-date">${prevLastDay - x + 1}</div>`;
    }

    for(let i = 1; i <= lastDay; i++){
        if(i === new Date().getDate() && date.getMonth() === new Date().getMonth()){
            days += `<div class="today">${i}</div>`;
        }else
            days += `<div>${i}</div>`;
    }

    for (let j = 1; j <= nextDays; j++) {
        days += `<div class="next-date">${j}</div>`;
    }
    monthDays.innerHTML = days;
}



document.querySelector('.prev').addEventListener('click', () => {
    date.setMonth(date.getMonth() - 1);
    renderCalendar();
});

document.querySelector('.next').addEventListener('click', () => {
    date.setMonth(date.getMonth() + 1);
    renderCalendar();
});

renderCalendar();



     
