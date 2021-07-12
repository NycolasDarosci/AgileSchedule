const Modal = {

    open(){
        //abrir o modal
        //document- DOM - é o modelo de toda estrutura html passado para o js
        //modelagem do HTML para o JS
        document.querySelector('.modal-overlay')
        //adicionar a classe active sob o modal
        .classList.add('active')
    },

    close(){
        //fechar o modal
        document.querySelector('.modal-overlay')
        //remover a classe active do modal
        .classList.remove('active')
    }
}
