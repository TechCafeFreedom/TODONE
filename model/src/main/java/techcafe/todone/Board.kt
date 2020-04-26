package techcafe.todone

data class Board(
    val id: Int,
    val title: String,
    val description: String,
    val author: User,
    val members: List<User>,
    val kanbans: List<Kanban>,
    val labels: List<Label>,
    val is_archive: Boolean
)
