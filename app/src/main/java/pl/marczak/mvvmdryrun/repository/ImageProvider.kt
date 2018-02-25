package pl.marczak.mvvmdryrun.repository

object ImageProvider {

    fun provideImage(creatureId: Int, anotherCreatureId: Int): String {
        return "http://images.alexonsager.net/pokemon/fused/$creatureId/$creatureId.$anotherCreatureId.png"
    }

}