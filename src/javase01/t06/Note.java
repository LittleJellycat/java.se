package javase01.t06;

/**
 * Object representation of a note
 */

class Note {
    private String text;

    Note(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
