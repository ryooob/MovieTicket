import `interface`.StdoutPresenter
import repository.TicketCsvRepository

fun main(){
    val ticketRepository = TicketCsvRepository()
    val tickets = ticketRepository.all()
    val presenter = StdoutPresenter(tickets)
    presenter.output()
}
