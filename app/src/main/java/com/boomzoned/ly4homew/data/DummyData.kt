package com.boomzoned.ly4homew.data

import com.boomzoned.ly4homew.domain.model.HYMN
import com.boomzoned.ly4homew.domain.model.Song
import com.boomzoned.ly4homew.domain.model.SongTag

fun fetchSongs(): List<Song> {
    return listOf(
        Song("There Shall Be Showers", HYMN(), listOf(SongTag()), lyThereShallBeShowers()),
        Song("All the way my savior Leads me", HYMN(), listOf(SongTag()),lyThereShallBeShowers()),
        Song("Blessed Assurance", HYMN(), listOf(SongTag()),lyThereShallBeShowers()),
        Song("Great is thy faithfulness", HYMN(), listOf(SongTag()),lyThereShallBeShowers()),
    )
}


fun lyThereShallBeShowers() :String {

    return  "1.There shall be showers of blessing:\n" +
            "  This is the promise of love;\n" +
            "There shall be seasons refreshing,\n" +
            "  Sent from the Savior above.\n" +
            "\n" +
            " CH :\tShowers of blessing,\n" +
            "  Showers of blessing we need;\n" +
            "Mercy-drops round us are falling,\n" +
            "    But for the showers we plead.\n" +
            "\n" +
            "2.There shall be showers of blessing\n" +
            "  Precious reviving again;\n" +
            "Over the hills and the valleys,\n" +
            "  Sound of abundance of rain.\n" +
            "\n" +
            "3.There shall be showers of blessing;\n" +
            "  Send them upon us, O Lord!\n" +
            "Grant to us now a refreshing;\n" +
            "  Come, and now honor Thy Word.\n" +
            "\n" +
            "4.There shall be showers of blessing;\n" +
            "  O that today they might fall,\n" +
            "Now as to God we’re confessing,\n" +
            "  Now as on Jesus we call!\n" +
            "\n" +
            "5.There shall be showers of blessing,\n" +
            "  If we but trust and obey;\n" +
            "There shall be seasons refreshing,\n" +
            "  If we let God have His way."

}