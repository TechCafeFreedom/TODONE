package techcafe.todone

enum class LabelColor {
    YELLOW,
    YELLOW_GREEN,
    GREEN,
    BLUE_GREEN,
    BLUE,
    BLUE_VIOLET,
    VIOLET,
    RED_VIOLET,
    RED,
    RED_ORANGE,
    ORANGE,
    YELLOW_ORANGE;

    companion object {
        fun toLabelColor(color: Int) = when (color) {
            0 -> YELLOW
            1 -> YELLOW_GREEN
            2 -> GREEN
            3 -> BLUE_GREEN
            4 -> BLUE
            5 -> BLUE_VIOLET
            6 -> VIOLET
            7 -> RED_VIOLET
            8 -> RED
            9 -> RED_ORANGE
            10 -> ORANGE
            11 -> YELLOW_ORANGE
            else -> YELLOW
        }
    }
}