package javase01.t06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Notepad {
    private Note[] notes = new Note[100];


    public void addNote(Note note) {
        int cell = findFreeCell();
        if (cell != 0) {
            notes[cell] = note;
        }
    }

    public void removeNote(int position) {
        if (position >= 0 && position < notes.length) {
            notes[position] = null;
        }
    }


    public void editNote(int position, Note note) {
        if (position >= 0 && position < notes.length) {
            notes[position] = note;
        }
    }

    public String[] getAllNotes() {
        return (String[]) Arrays.stream(notes).filter(Objects::nonNull).map(Note::toString).toArray();
    }

    private int findFreeCell() {
        return IntStream.range(0, notes.length).filter(i -> notes[i] == null).findAny().orElse(-1);
    }
}
