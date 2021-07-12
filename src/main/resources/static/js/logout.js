function sair() {
        swal({
                title: "Tem certeza?",
                icon: "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.vexels.com%2Fmedia%2Fusers%2F3%2F152600%2Fisolated%2Flists%2F1c6716b235863cb53f9b3dbd3aa36ab8-icone-de-ponto-de-interrogacao-do-circulo-vermelho.png&f=1&nofb=1",
                buttons: ["Voltar", "Sair"],
                dangerMode: true,
            })
            .then((willDelete) => {
                if (willDelete) {
                    swal("Usuario deslogado!", {
                        icon: "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia.istockphoto.com%2Fvectors%2Fhand-waving-vector-icon-of-hello-welcome-or-goodbye-gesture-line-on-vector-id987654988&f=1&nofb=1",
                        button: false
                    });
                    var delayInMilliseconds = 1000;
                    setTimeout(function() { location.href = "/logout" }, delayInMilliseconds);
                }
                return false;
            });
    }