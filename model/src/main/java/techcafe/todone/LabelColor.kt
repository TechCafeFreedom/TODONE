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
        fun toLabelNumber(color: LabelColor) = when (color) {
            YELLOW -> 0
            YELLOW_GREEN -> 1
            GREEN -> 2
            BLUE_GREEN -> 3
            BLUE -> 4
            BLUE_VIOLET -> 5
            VIOLET -> 6
            RED_VIOLET -> 7
            RED -> 8
            RED_ORANGE -> 9
            ORANGE -> 10
            YELLOW_ORANGE -> 11
            else -> 0
        }
    }
}