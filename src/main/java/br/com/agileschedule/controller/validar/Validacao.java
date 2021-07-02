/*
 * package br.com.agileschedule.controller.validar;
 * 
 * import java.time.LocalDate;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Component;
 * 
 * import br.com.agileschedule.entity.Calendario; import
 * br.com.agileschedule.form.CalendarioForm;
 * 
 * @Component public class Validacao {
 * 
 * // método verificar se data informado for antes da data atual public
 * ResponseEntity<?> verificarData(CalendarioForm form) {
 * 
 * LocalDate dataInformado = form.getDiaInicial(); LocalDate dataAgora =
 * LocalDate.now();
 * 
 * if (dataInformado.isBefore(dataAgora)) { return
 * ResponseEntity.status(HttpStatus.BAD_REQUEST).
 * body("Não é possivel informar uma data antes"); } return
 * ResponseEntity.ok().build(); } }
 */
