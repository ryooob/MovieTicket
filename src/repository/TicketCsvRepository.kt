package repository

import TicketCollection
import entity.Movie
import entity.PriceType
import entity.Ticket
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TicketCsvRepository(): TicketRepository {
    override fun all(): TicketCollection {
        val file = File("source.csv").absoluteFile
        val reader = file.readText()
        val rows  = reader.split(Regex("\n"))
        val tickets = TicketCollection()
        for (row in rows) {
            val columns = row.split(Regex(","))
            val dateColumn = columns[0].replace("\"", "")
            val movieNameColumn = columns[1].replace("\"", "")
            val priceTypeColumn = columns[2].replace("\"", "")
            val dateTime = LocalDateTime.parse(dateColumn, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            val movie = Movie(movieNameColumn)
            val plan = PriceType.fromString(priceTypeColumn)
            val ticket = Ticket(movie, plan, dateTime)
            tickets.add(ticket)
        }
        return tickets
    }
}