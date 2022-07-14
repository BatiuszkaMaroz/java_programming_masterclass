package challenges.C2_Playlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
  private String name;
  private String artist;
  private ArrayList<Song> songs = new ArrayList<Song>();

  public Album(String name, String artist) {
    this.name = name;
    this.artist = artist;
  }

  private Song findSong(String title) {
    Iterator<Song> i = songs.iterator();

    while (i.hasNext()) {
      Song cur = i.next();
      if (cur.getTitle().equals(title))
        return cur;
    }

    return null;
  }

  public boolean addSong(String title, double duration) {
    if (findSong(title) != null)
      return false;

    songs.add(new Song(title, duration));
    return true;
  }

  public boolean addToPlayList(int songIndex, LinkedList<Song> playlist) {
    Song song;
    try {
      song = songs.get(songIndex - 1);
    } catch (IndexOutOfBoundsException err) {
      song = null;
    }

    if (song == null)
      return false;

    playlist.add(song);
    return true;
  }

  public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
    Song song = findSong(songTitle);
    if (song == null)
      return false;

    playlist.add(song);
    return true;
  }
}
