# Sqlite3

## Known Issues

- `attempt to write a readonly database` - change permissions for file and directory.

## Run

### Pure

`docker run --rm -it -v "$(pwd)/db:/workspace" -w /workspace keinos/sqlite3`

### Based on file with additional configuration

`docker run --rm -it -v "$(pwd)/db:/workspace" keinos/sqlite3 sqlite3 /workspace/music.db -header -column`

## Commands

### Administration

- `.help` - show help.
- `.backup filename` - backup db to file.
- `.restore filename` - restore db from file.
- `.open filename` - close current db, and open one from file.

### Restoring

- `.schema` - returns SQL code needed to recreate tables.
- `.dump` - returns SQL code needed to recreate current state of db.

### Querying

- `.databases` - show all dbs.
- `.tables` - show tables in current db.
- `.schema` - show schema for all tables.
- `.schema table` - show schema for selected table.

### Format

- `.headers on/off` - show headers while SELECT-ing.
- `.mode box/column` - best formats for tables.
  - `mode markdown/table/list/line`

## SQL

### 1. Intro

```
CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT);

INSERT INTO contacts (name, phone, email) VALUES ('Eugene', 111222333, 'eugene@mail.com');
INSERT INTO contacts (name, email) VALUES ('Abbass', 'abbass@mail.com');
SELECT * FROM contacts;

UPDATE contacts SET name = 'Babbass' WHERE name = 'Abbass';
SELECT name FROM contacts;

DELETE FROM contacts WHERE email = 'eugene@mail.com';
SELECT * FROM contacts;
```

### 2. Select

```
.open music.db
.mode column
.headers on

SELECT name FROM albums WHERE _id=367;
SELECT name FROM albums ORDER BY name;
SELECT name FROM albums ORDER BY name COLLATE NOCASE; #case-insensitive
SELECT name FROM albums ORDER BY name DESC;

SELECT artist, name FROM albums ORDER BY artist, name;

SELECT
  album,
  track AS track_number,
  title
FROM songs
WHERE _id = 1
ORDER BY album, track;
```

### 3. Joins

```
SELECT albums.name, songs.track, songs.title FROM songs INNER JOIN albums ON songs.album = albums._id ORDER BY albums.name, songs.track;

SELECT artists.name, albums.name FROM albums INNER JOIN artists ON albums.artist = artists._id ORDER BY artists.name;

SELECT
  artists.name AS artist_name,
  albums.name AS album_name,
  songs.track AS track_number,
  songs.title AS song_title
FROM songs
INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id
WHERE albums._id = 19
ORDER BY artists.name, albums.name, songs.track;
```

### 4. Wildcards

```
SELECT * FROM songs WHERE title LIKE '%doctor%'; #case-insensitive
```

### 5. Views

```
CREATE VIEW enchanted_songs AS
SELECT
  artists.name AS artist_name,
  albums.name AS album_name,
  songs.track AS track_number,
  songs.title AS song_title
FROM songs
INNER JOIN albums ON songs.album = albums._id
INNER JOIN artists ON albums.artist = artists._id
ORDER BY artists.name, albums.name, songs.track;

.schema

SELECT * FROM enchanted_songs;

DROP VIEW enchanted_songs;
```

### 6. Count

```
DELETE FROM songs WHERE track < 50;
SELECT * FROM songs;

SELECT * FROM songs WHERE track <> 71;

SELECT count(*) FROM songs;
SELECT count(*) FROM songs WHERE track <> 71;
```

### 7. Challenge

```
SELECT
  songs.track,
  songs.title
FROM
  songs
INNER JOIN
  albums ON songs.album = albums._id
WHERE
  albums.name = 'Forbidden'
ORDER BY
  songs.track;

SELECT
  songs.title
FROM
  songs
INNER JOIN
  albums ON songs.album = albums._id
INNER JOIN
  artists ON albums.artist = artists._id
WHERE
  artists.name = 'Deep Purple';

SELECT * FROM artists WHERE name = 'Mehitabel';
SELECT * FROM artists WHERE _id = 3;

UPDATE artists
SET name = 'One Kitten'
WHERE name = 'Mehitabel';

SELECT
  songs.title
FROM
  songs
INNER JOIN
  albums ON songs.album = albums._id
INNER JOIN
  artists ON albums.artist = artists._id
WHERE
  artists.name = 'Aerosmith'
ORDER BY
  songs.title;

SELECT
  count(songs.title)
FROM
  songs
INNER JOIN
  albums ON songs.album = albums._id
INNER JOIN
  artists ON albums.artist = artists._id
WHERE
  artists.name = 'Aerosmith'
ORDER BY
  songs.title;

SELECT DISTINCT
  songs.title
FROM
  songs
INNER JOIN
  albums ON songs.album = albums._id
INNER JOIN
  artists ON albums.artist = artists._id
WHERE
  artists.name = 'Aerosmith'
ORDER BY
  songs.title;

SELECT
  count(DISTINCT songs.title)
FROM
  songs
INNER JOIN
  albums ON songs.album = albums._id
INNER JOIN
  artists ON albums.artist = artists._id
WHERE
  artists.name = 'Aerosmith'
ORDER BY
  songs.title;

SELECT
  count(DISTINCT albums._id)
FROM
  songs
INNER JOIN
  albums ON songs.album = albums._id
INNER JOIN
  artists ON albums.artist = artists._id
WHERE
  artists.name = 'Aerosmith'
ORDER BY
  songs.title;

SELECT
  count(DISTINCT artists.name)
FROM
  songs
INNER JOIN
  albums ON songs.album = albums._id
INNER JOIN
  artists ON albums.artist = artists._id
WHERE
  artists.name = 'Aerosmith'
ORDER BY
  songs.title;
```
