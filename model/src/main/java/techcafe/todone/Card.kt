package techcafe.todone

data class Card(
    val id: Int,
    val title: String,
    val content: String,
    val deadline: Int,
    val author: User,
    val labels: List<Label>,
    val created_at: Int,
    val is_archive: Boolean,
    val updated_at: Int
)