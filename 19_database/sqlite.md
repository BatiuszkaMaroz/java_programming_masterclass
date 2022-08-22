# Sqlite3

### Run

`docker run --rm -it -v "$(pwd)/db:/workspace" -w /workspace keinos/sqlite3`

### Commands

#### Administration

- `.help` - show help.
- `.headers on/off` - show headers while SELECT-ing.
- `.backup filename` - backup db to file.
- `.restore filename` - restore db from file.
- `.open filename` - close current db, and open one from file.

### Restoring

- `.schema` - returns SQL code needed to recreate tables.
- `.dump` - returns SQL code needed to recreate current state of db.

#### Querying

- `.databases` - show all dbs.
- `.tables` - show tables in current db.
- `.schema` - show schema for current table.

### SQL

1.

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

2.

```
.open music.db;
.schema

#CREATE TABLE songs (_id INTEGER PRIMARY KEY, track INTEGER, title TEXT NOT NULL, album INTEGER);
#CREATE TABLE albums (_id INTEGER PRIMARY KEY, name TEXT NOT NULL, artist INTEGER);
#CREATE TABLE artists (_id INTEGER PRIMARY KEY, name TEXT NOT NULL);

SELECT name FROM albums WHERE _id=367;
SELECT name FROM albums ORDER BY name;
SELECT name FROM albums ORDER BY name COLLATE NOCASE;
SELECT name FROM albums ORDER BY name DESC;

SELECT artist, name FROM albums ORDER BY artist, name;

SELECT title, album FROM songs ORDER BY album;
```
