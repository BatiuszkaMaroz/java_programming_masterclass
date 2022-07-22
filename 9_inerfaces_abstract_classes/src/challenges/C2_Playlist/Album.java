package challenges.C2_Playlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
  public static class SongList {
    private ArrayList<Song> songs = new ArrayList<Song>();

    private SongList() {
      //
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

    private Song findSong(int trackNumber) {
      trackNumber--;
      if (trackNumber < 0 || songs.size() <= trackNumber)
        return null;

      return songs.get(trackNumber);
    }

    private boolean add(Song song) {
      if (findSong(song.getTitle()) != null)
        return false;

      songs.add(song);
      return true;
    }
  }

  private String name;
  private String artist;
  private SongList songs = new SongList();

  public Album(String name, String artist) {
    this.name = name;
    this.artist = artist;
  }

  public boolean addSong(String title, double duration) {
    return songs.add(new Song(title, duration));
  }

  public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
    Song song = songs.findSong(trackNumber);
    if (song == null)
      return false;

    playlist.add(song);
    return true;
  }

  public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
    Song song = songs.findSong(songTitle);
    if (song == null)
      return false;

    playlist.add(song);
    return true;
  }
}
