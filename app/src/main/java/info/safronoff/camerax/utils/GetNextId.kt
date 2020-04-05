package info.safronoff.camerax.utils

object GetNextId {
    private var value = 1000

    fun exec(): Int {
        return value++
    }
}