package techcafe.todone

data class Kanban(
    val id: Int,
    val name: String,
    val author: User,
    val cards: List<Card>,
    val is_archive: Boolean
)