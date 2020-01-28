package repository

import TicketCollection

interface TicketRepository {
    public fun all(): TicketCollection
}