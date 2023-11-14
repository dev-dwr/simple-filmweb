package com.pwr266521.jetpack.data

import com.pwr266521.jetpack.R
import com.pwr266521.jetpack.movie.domain.Actor
import com.pwr266521.jetpack.movie.domain.Movie

object MOVIES_DATA {
    val MOVIES = listOf(
        Movie(
            R.drawable.spiderman,
            "Spiderman 2",
            "1:30h",
            "This movie follows the story of Peter Parker, a high school student who gains spider-like abilities after being bitten by a genetically-modified spider. He adopts the superhero identity of Spider-Man to fight crime",
            ACTORS_SPIDERMAN,
            SCENES_SPIDERMAN
        ),
        Movie(
            R.drawable.batman,
            "The Batman",
            "2h",
            "Set in the dark and gritty Gotham City, this film focuses on Bruce Wayne, a billionaire who, traumatized by the murder of his parents as a child",
            ACTORS_BATMAN,
            SCENES_BATMAN
        ),
        Movie(
            R.drawable.flash,
            "The Flash",
            "1h",
            "This movie centers around Barry Allen, a forensic scientist who gains super-speed abilities after an accident involving lightning and chemicals.",
            ACTORS_FLASH,
            SCENES_FLASH
        ),
        Movie(
            R.drawable.superman,
            "The Superman 2",
            "3h",
            "The story of Superman revolves around Kal-El, the last survivor of the planet Krypton, sent to Earth as a baby. Raised as Clark Kent in a rural town.",
            ACTORS_SUPERMAN,
            SCENES_SUPERMAN
        )
    )
}


val SCENES_SPIDERMAN = listOf(
    R.drawable.sscene1,
    R.drawable.sscene2,
    R.drawable.sscene3,
    R.drawable.sscene4,
    R.drawable.sscene5,
    R.drawable.sscene6,
    R.drawable.sscene7,
    R.drawable.sscene8,
    R.drawable.sscene9,
)
val SCENES_BATMAN = listOf(
    R.drawable.sbatman1,
    R.drawable.sbatman2,
    R.drawable.sbatman3,
    R.drawable.sbatman4,
    R.drawable.sbatman5,
    R.drawable.sbatman6,
    R.drawable.sbatman7,
    R.drawable.sbatman8,
    R.drawable.sbatman9,
)
val SCENES_FLASH = listOf(
    R.drawable.sflash1,
    R.drawable.sflash2,
    R.drawable.sflash3,
    R.drawable.sflash4,
    R.drawable.sflash5,
    R.drawable.sflash6,
    R.drawable.sflash7,
    R.drawable.sflash8,
    R.drawable.sflash9,
)
val SCENES_SUPERMAN = listOf(
    R.drawable.ssuperman1,
    R.drawable.ssuperman2,
    R.drawable.ssuperman3,
    R.drawable.ssuperman4,
    R.drawable.ssuperman5,
    R.drawable.ssuperman6,
    R.drawable.ssuperman7,
    R.drawable.ssuperman8,
    R.drawable.ssuperman9,
)

val ACTORS_SPIDERMAN = listOf(
    Actor(R.drawable.holland, "Tom Holland"),
    Actor(R.drawable.tobey, "Tobey Maguire"),
    Actor(R.drawable.drake, "Drake Bell"),
    Actor(R.drawable.josh, "Josh Keaton"),
)

val ACTORS_BATMAN = listOf(
    Actor(R.drawable.robert, "Robert Pattinson"),
    Actor(R.drawable.zoe, "Zoë Kravitz"),
    Actor(R.drawable.paul, "Paul Dano"),
    Actor(R.drawable.colin, "Colin Farrell"),
)

val ACTORS_FLASH = listOf(
    Actor(R.drawable.grant, "Grant Gustin"),
    Actor(R.drawable.candice, "Candice Patton"),
    Actor(R.drawable.tom, "Tom Cavanagh"),
    Actor(R.drawable.danielle, "Danielle Panabaker"),
)

val ACTORS_SUPERMAN = listOf(
    Actor(R.drawable.christopher, "Christopher Reeve"),
    Actor(R.drawable.marlon, "Marlon Brando"),
    Actor(R.drawable.margot, "Margot Kidder"),
)