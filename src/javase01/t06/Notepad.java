package javase01.t06;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Simulation of a simple array-based Notepad. It's capacity by design is 100 rows, each of those
 * is an instance of a Note class. Ordering is not guaranteed.
 */
public class Notepad {
    private Note[] notes = new Note[100];

    /**
     * Adds a row to any free place in an internal array
     */
    public void addNote(Note note) {
        int cell = findFreeCell();
        if (cell != -1) {
            notes[cell] = note;
        }
    }

    /**
     * Removes a row at given position if valid
     */
    public void removeNote(int position) {
        if (position >= 0 && position < notes.length) {
            notes[position] = null;
        }
    }

    /**
     * Edit a row by replacing it with a new one
     */
    public void editNote(int position, Note note) {
        if (position >= 0 && position < notes.length) {
            notes[position] = note;
        }
    }

    /**
     * Get all non-null rows as an array
     */
    public Note[] getAllNotes() {
        return Arrays.stream(notes).filter(Objects::nonNull).toArray(Note[]::new);
    }

    @Override
    public String toString() {
        return Arrays.stream(notes).map(x -> x != null ? x.toString() : "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
                .collect(Collectors.joining("\n"));
    }

    private int findFreeCell() {
        return IntStream.range(0, notes.length).filter(i -> notes[i] == null).findAny().orElse(-1);
    }

//    public static void main(String[] args) {
//        Notepad notepad = new Notepad();
//        notepad.addNote(new Note("1"));
//        notepad.addNote(new Note("2"));
//        notepad.addNote(new Note("3"));
//        notepad.addNote(new Note("4"));
//        notepad.removeNote(1);
//        notepad.editNote(2, new Note("3a"));
//        System.out.println(Arrays.toString(notepad.getAllNotes()));
//        System.out.println(notepad);
//    }
}
